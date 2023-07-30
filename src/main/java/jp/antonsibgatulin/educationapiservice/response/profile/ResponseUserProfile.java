package jp.antonsibgatulin.educationapiservice.response.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import jp.antonsibgatulin.educationapiservice.entity.access.Access;
import jp.antonsibgatulin.educationapiservice.entity.home_task.HomeTask;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import jp.antonsibgatulin.educationapiservice.response.AResponse;

import java.util.List;

public class ResponseUserProfile extends AResponse {

    public User user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Teacher teacher;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Item> items;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<HomeTask> homeTasks;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Access> courses;

    public ResponseUserProfile(User user, Teacher teacher, List<Item> items, List<HomeTask> homeTasks, List<Access> courses) {
        this.user = user;
        this.teacher = teacher;
        this.items = items;
        this.homeTasks = homeTasks;
        this.courses = courses;
    }
}
