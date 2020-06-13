package Abstract;

import Constant.WebConstant;
import Generic.Generic_Dao;
import SessionFactory.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Abstract_Dao<T,ID extends Serializable> implements Generic_Dao<T,ID> {
    private Class<T> persistenceClass;
    private final Logger log = Logger.getLogger(this.getClass());

    public Abstract_Dao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String getClassName() {
        return persistenceClass.getSimpleName();
    }

    @Override
    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = (T) session.get(this.persistenceClass, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            log.error(e.getMessage(), e);
            throw e;
        }
        return result;
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<T> list = new ArrayList<T>();
        try {
            StringBuilder sql = new StringBuilder("FROM ").append(this.getClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }


    @Override
    public void upDate(T t) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
session.update(t);
transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
    }


    @Override
    public void save(T t) {
Session session=HibernateUtils.getSessionFactory().openSession();
Transaction transaction=session.beginTransaction();
try {
session.persist(t);
transaction.commit();
}catch (HibernateException e){
    transaction.rollback();
    throw  e;
}
    }

    @Override
    public Object[] findByProperties(Map<String, Object> properties, String sortDirection, String sortExpression, Integer first, Integer end) {
        Object[] objects=new Object[2];
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            List<String> listProperties=new ArrayList<String>();
            List<Object> listValue=new ArrayList<Object>();
            for(Map.Entry item: properties.entrySet()){
                listProperties.add(item.getKey().toString());
                listValue.add(item.getValue());
            }
            StringBuilder sql1=new StringBuilder("FROM ").append(this.getClassName());
            sql1.append(" WHERE 1=1  ");
            if(listProperties.size()>0){
                for (int i=0;i<listProperties.size();i++) {
                    sql1.append("AND LOWER("+listProperties.get(i)+") LIKE :"+listProperties.get(i));
                }
            }
            Query query1=session.createQuery(sql1.toString());
            if(listProperties.size()>0){
                for(int i=0;i<listProperties.size();i++){
                    query1.setParameter(listProperties.get(i),"%"+listValue.get(i)+"%");
                }
            }
            if(sortDirection!=null&&sortExpression!=null){
                sql1.append(" ORDER BY ").append(sortExpression);
                sql1.append(" ").append(sortDirection.equals(WebConstant.SORT_ASC)?"asc":"desc");
            }
            if(first!=null&&first>=0){
                query1.setFirstResult(first);
            }
            if(end!=null&&end>0){
                query1.setMaxResults(end);
            }
            objects[0]=query1.list();
            StringBuilder sql2=new StringBuilder("SELECT COUNT(*) FROM ").append(this.getClassName());
            sql2.append(" WHERE 1=1 ");
            if(listProperties.size()>0){
                for (int i=0;i<listProperties.size();i++) {
                    sql2.append("AND LOWER("+listProperties.get(i)+") LIKE :"+listProperties.get(i));
                }
            }
            Query query2=session.createQuery(sql2.toString());
            if(listProperties.size()>0){
                for(int i=0;i<listProperties.size();i++){
                    query2.setParameter(listProperties.get(i),"%"+listValue.get(i)+"%");
                }
            }
            objects[1]=query2.list().get(0);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
        return objects;
    }

    @Override
    public Integer delete(List<Integer> ids) {
        int count=0;
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            for (Integer item:ids) {
                T t= (T) session.get(this.persistenceClass,item);
                session.delete(t);
                count++;
                transaction.commit();
            }
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
        return count;
    }

    @Override
    public T findEqualUnique(String property, Object value) {
        return null;
    }

    @Override
    public T getByName(String name) {
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        T result=null;
        try {
            StringBuilder sql=new StringBuilder("FROM ").append(this.getClassName()).append(" WHERE NAME= :NAME");
            Query query=session.createQuery(sql.toString());
            query.setParameter("NAME",name);
            result=(T)query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
return result;
    }
}
