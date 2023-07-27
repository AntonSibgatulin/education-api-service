package jp.antonsibgatulin.educationapiservice.mapper.item;

import jp.antonsibgatulin.educationapiservice.dto.ItemDTO;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;

public interface ItemMapper {
    public Item fromDTO(ItemDTO itemDTO, Teacher teacher);
}
