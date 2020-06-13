<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="urlEdit" value="/ajax-edit-user.html">
    <c:param name="urlType" value="edit"/>
</c:url>
<c:url var="listAfter" value="/admin-list-user.html">

</c:url>
<html>
<head>
    <title><fmt:message key="label.mange.user" bundle="${lang}"/></title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                </li>
                <li class="active"><fmt:message key="label.list.user" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-xs-12">
<c:if test="${not empty messageResponse}">
    <div class="alert alert-block alert-${alert}">
        <button type="button" class="close" data-dismiss="alert">
            <i class="ace-icon fa fa-times"></i>
        </button>
            ${messageResponse}
    </div>
</c:if>
                            <form action="${listUserUrl}" method="get" id="formUrl">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="table-btn-controls">
                                            <div class="pull-right tableTools-container">
                                                <div class="dt-buttons btn-overlap btn-group">
                                                    <a flag="info"
                                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                                       onclick="update(this)"/>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                                    </a>
                                                    <button type="button"
                                                            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                            id="deleteAll" disabled
                                                            data-toggle="<fmt:message key='label.delete.all' bundle='${lang}'/>"
                                                    onclick="warningBeforeDelete()">
                                                 <span>
                                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                                </span>
                                                    </button>
                                                    <a flag="info"
                                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                                       href="${importUrl}">
                                                <span>
                                                    <i class="fa fa-file" aria-hidden="true"></i>
                                                </span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <fmt:bundle basename="ResourceBundle">
                                        <display:table id="tableList" name="${items.listResult}" partialList="true"
                                                       size="${items.totalItems}"
                                                       pagesize="${items.maxPageItems}"
                                                       sort="external"
                                                       requestURI="${requestUrl}"
                                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                       style="margin: 3em 0 1.5em;">
                                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                            headerClass="center select-cell">
                                                <fieldset>
                                                    <input type="checkbox" name="checkList"
                                                           id="checkbox_${tableList.userId}" value="${tableList.userId}"
                                                           class="check-box-element"/>
                                                </fieldset>
                                            </display:column>
                                            <display:column property="name" titleKey="label.user.name" sortable="true"
                                                            sortName="name"/>
                                            <display:column property="fullName" titleKey="label.user.fullName"
                                                            sortable="true" sortName="fullName"/>
                                            <display:column headerClass="col-actions" titleKey="label.action">
                                                <c:url value="/ajax-edit-user.html" var="editUrl">
                                                    <c:param name="urlType" value="edit"/>
                                                    <c:param name="pojo.userId" value="${tableList.userId}"/>
                                                </c:url>
                                                <a class="btn btn-sm btn-primary btn-edit" sc-url="${editUrl}"
                                                   onclick="update(this)" data-toggle="tooltip"
                                                   title="<fmt:message key='label.user.edit' bundle='${lang}'/>"><i
                                                        class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                            </display:column>
                                        </display:table>
                                    </fmt:bundle>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
</div>
<script>
    $(document).ready(function () {

    })

    function update(btn) {
        var url = $(btn).attr('sc-url');
        if (typeof url == 'undefined') {
            url = '${urlEdit}';
        }
        $('#myModal').load(url,'', function () {
            $('#myModal').modal('toggle');
            updateOrAdd();
        })

    }

    function validateDataUser() {
        $('#editUserForm').validate({
            rules: [],
            messages: [],
        });
        $('#username').rules("add", {
            required: true,
            messages: {
                required: '<fmt:message bundle="${lang}" key="label.empty"/>',
            }
        });
        $('#password').rules("add", {
            required: true,
            messages: {
                required: '<fmt:message bundle="${lang}" key="label.empty"/>',
            }
        });

    }

    function updateOrAdd() {
        $('#btnSave').click(function () {
            validateDataUser();
            $('#editUserForm').submit();
        });
        $('#editUserForm').submit(function (e) {
            e.preventDefault();
            var $form = $(this);
            if (!$form.valid()) return false;
            var roleId = $('#role').val();
            if (roleId == "-1") {
                alert("You must select role");
                return false;
            }
            var data = {};
            var formData = $('#editUserForm').serializeArray();
            $.each(formData, function (i, v) {
                data['' + v.name + ''] = v.value;
            });
            if (data["userId"] == null) {
                addNewUser(data);
            } else {
                updateUser(data);
            }
        })
    }

    function addNewUser(data) {
$.ajax({
    url: '${listAfter}',
    type:'POST',
    contentType: 'application/json',
    data:JSON.stringify(data),
    dataType: 'json',
    success:function (result) {
window.location.href="${listAfter}?urlType=list&&crudaction=save"
    },
    error:function (error) {
        window.location.href="${listAfter}?urlType=list&&crudaction=error"

    }
})
    }

    function updateUser(data) {
$.ajax({
    url:'${listAfter}',
    type:'PUT',
    contentType:'application/json',
    data:JSON.stringify(data),
    dataType:'json',
    success:function (result) {
window.location.href="${listAfter}?urlType=list&&crudaction=update"
    },
    error:function (error) {
window.location.href="${listAfter}?urlType=list&&crudaction=error"
    }
})
    }
    function warningBeforeDelete() {
showAlertBeforeDelete(function () {
var data={};
var ids=$('tbody input[type=checkbox]:checked').map(function () {
return $(this).val();
}).get();
data['ids']=ids;
deleteData(data);
})
    }
    function deleteData(data) {
        $.ajax({
            url:'${urlEdit}',
            type:'DELETE',
            contentType:'application/json',
            data:JSON.stringify(data),
            dataType:'json',
            success:function (result) {
window.location.href='${listAfter}?urlType=list&&crudaction=delete';
            },
            error:function (error) {
window.location.href='${listAfter}?urlType=list&&crudaction=error';
            }

        })

    }
</script>
</body>
</html>