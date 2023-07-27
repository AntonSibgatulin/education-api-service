package jp.antonsibgatulin.educationapiservice.configure;

import jp.antonsibgatulin.educationapiservice.dto.ItemDTO;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;
import jp.antonsibgatulin.educationapiservice.mapper.item.ItemMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ItemMapper itemMapper() {
        return new ItemMapper() {
            @Override
            public Item fromDTO(ItemDTO itemDTO, Teacher teacher) {
                return new Item(itemDTO.name, itemDTO.description, teacher,
                        itemDTO.price, itemDTO.number_of_students, itemDTO.tags);

            }
        };
    }


}
