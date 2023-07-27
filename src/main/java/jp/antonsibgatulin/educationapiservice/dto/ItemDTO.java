package jp.antonsibgatulin.educationapiservice.dto;

import jakarta.annotation.Nonnull;
import jp.antonsibgatulin.educationapiservice.entity.tag.Tag;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;

public class ItemDTO {
    @NonNull
    public String name;
    @NonNull
    public String description;
    @NonNull
    public Integer price;
    @NonNull
    public Integer number_of_students;
    @NonNull
    public List<Tag> tags;

}
