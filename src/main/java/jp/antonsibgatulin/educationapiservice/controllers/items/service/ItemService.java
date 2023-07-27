package jp.antonsibgatulin.educationapiservice.controllers.items.service;


import jp.antonsibgatulin.educationapiservice.controllers.items.response.ResponseItemAuth;
import jp.antonsibgatulin.educationapiservice.controllers.items.response.ResponseItemForUnAuthUser;
import jp.antonsibgatulin.educationapiservice.dto.ItemDTO;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.post_item.PostItem;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;
import jp.antonsibgatulin.educationapiservice.entity.user.Role;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import jp.antonsibgatulin.educationapiservice.mapper.item.ItemMapper;
import jp.antonsibgatulin.educationapiservice.repository.ItemRepository;
import jp.antonsibgatulin.educationapiservice.repository.PostItemRepository;
import jp.antonsibgatulin.educationapiservice.repository.TeacherRepository;
import jp.antonsibgatulin.educationapiservice.response.ResponseAccessDenied;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static jp.antonsibgatulin.educationapiservice.utils.ResponseUtils.getAccessDenied;
import static jp.antonsibgatulin.educationapiservice.utils.ResponseUtils.getOK;
import static jp.antonsibgatulin.educationapiservice.utils.UserUtils.*;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final static int limit = 30; // Specify the desired limit

    private final ItemRepository itemRepository;
    private final PostItemRepository postItemRepository;
    private final TeacherRepository teacherRepository;
    private final ItemMapper itemMapper;


    public List<Item> getPopular(Integer page) {
        int p = 0;
        if (page != null) {
            p = page;
        }

        // Create a PageRequest with limit and sort by rating in descending order
        PageRequest pageRequest = PageRequest.of(p, limit, Sort.by(Sort.Direction.DESC, "rating"));

        // Retrieve the most popular items from the database
        return itemRepository.findAll(pageRequest).getContent();
    }

    public List<Item> getWatches(Integer page) {
        int p = 0;
        if (page != null) {
            p = page;
        }

        // Create a PageRequest with limit and sort by view count in descending order
        PageRequest pageRequest = PageRequest.of(p, limit, Sort.by(Sort.Direction.DESC, "view"));

        // Retrieve the most popular items from the database
        return itemRepository.findAll(pageRequest).getContent();
    }

    public ResponseEntity getItem(Long id, Authentication authentication) {
        var item = itemRepository.getReferenceById(id);
        User user = getUser(authentication);
        var posts = postItemRepository.findAllByItem(item);
        int hours = 0;
        for (var postItem : posts) {
            hours += postItem.getHours();
        }
        if (user == null) {
            var response = new ResponseItemForUnAuthUser(item, posts.size(), hours);
            return ResponseEntity.ok(response);
        } else {
            var response = new ResponseItemAuth(item, posts, posts.size(), hours);
            return ResponseEntity.ok(response);
        }

        /*
        if(item.getTeacher().getUser().getId() == user.getId()){
            // Do something if the user is the teacher of the item
        }
        */
    }

    public ResponseEntity putItem(ItemDTO itemDTO, Authentication authentication) {

        var teacher = getTeacher(authentication,teacherRepository);
        if(teacher == null)return getAccessDenied();
        var item = itemMapper.fromDTO(itemDTO, teacher);

        itemRepository.save(item);


        return ResponseEntity.ok(item);
    }

    public ResponseEntity deleteItem(Long id, Authentication authentication) {
        var teacher = getTeacher(authentication,teacherRepository);
        var item = itemRepository.getReferenceById(id);
        if(item == null)return getAccessDenied();
        if(checkAdmin(teacher) || checkAuthor(teacher,item)){
            item.getTags().clear();
            //this part need a test
            itemRepository.delete(item);
            return getOK();
        }
        else{
            return getAccessDenied();
        }

    }



}