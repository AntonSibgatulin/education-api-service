package jp.antonsibgatulin.educationapiservice.controllers.profile.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.antonsibgatulin.educationapiservice.entity.access.Access;
import jp.antonsibgatulin.educationapiservice.entity.home_task.HomeTask;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import jp.antonsibgatulin.educationapiservice.repository.*;
import jp.antonsibgatulin.educationapiservice.response.profile.ResponseUserProfile;
import jp.antonsibgatulin.educationapiservice.response.standarlone.ResponseNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;
    private final AccessRepository accessRepository;
    private final ItemRepository itemRepository;
    private final HomeTaskRepository homeTaskRepository;

    public ResponseEntity get(Long id) {
        User user = userRepository.getUserById(id);
        if (user == null) return ResponseEntity.ok(new ResponseNotFound());

        var teacher = teacherRepository.getTeacherByUser(user);

        List<Item> itemList = null;

        if (teacher != null) {
            itemList = itemRepository.findAllByTeacher(teacher);
        }

        List<HomeTask> homeTasks = homeTaskRepository.findAllByUser(user);
        List<Access> accessList = accessRepository.findAllByUser(user);

        teacher.setUser(null);
        for (Item item : itemList) {
            item.setTeacher(null);
        }

        return ResponseEntity.ok(new ResponseUserProfile(user, teacher, itemList, homeTasks, accessList));
    }


    public ResponseEntity getMyProfile(Authentication authentication) {
        return null;
    }
}
