package utilInterface;

import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;

public interface MotherUtils {
     MotherDTO entityToDTO(MotherEntity entity);
    MotherEntity dtoToEntity(MotherDTO dto);
}
