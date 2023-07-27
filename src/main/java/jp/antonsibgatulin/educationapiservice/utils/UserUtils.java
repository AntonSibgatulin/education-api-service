package jp.antonsibgatulin.educationapiservice.utils;

import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;
import jp.antonsibgatulin.educationapiservice.entity.user.Role;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import jp.antonsibgatulin.educationapiservice.repository.TeacherRepository;
import org.springframework.security.core.Authentication;

public class UserUtils {

    public static User getUser(Authentication authentication) {
        if(authentication==null)return null;
        return (User) authentication.getPrincipal();
    }


    public static boolean checkAuthor(Teacher teacher, Item item) {
        return teacher.getUser().getId() == item.getTeacher().getUser().getId();
    }

    public static boolean checkAdmin(Teacher teacher) {
        return teacher.getUser().getRole() == Role.ADMIN;
    }

    public static Teacher getTeacher(Authentication authentication, TeacherRepository teacherRepository) {
        var user = getUser(authentication);
        if (user == null) return null;
        var teacher = teacherRepository.getTeacherByUser(user);
        if (teacher == null) return null;
        return teacher;
    }

}
