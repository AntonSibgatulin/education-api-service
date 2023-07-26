package jp.antonsibgatulin.educationapiservice.controllers.items;


import jp.antonsibgatulin.educationapiservice.controllers.items.service.ItemService;
import jp.antonsibgatulin.educationapiservice.dto.ItemDTO;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    //The `getPopulars` method is mapped to the "/items/getPopulars" endpoint and retrieves a list of popular items based on the specified page number.
    @GetMapping("/getPopulars")
    public List<Item> getPopulars(@RequestParam("page") Integer page) {
        return itemService.getPopular(page);
    }

    //The `getWatches` method is mapped to the "/items/getWatches" endpoint and retrieves a list of watched items based on the specified page number.
    @GetMapping("/getWatches")
    public List<Item> getWatches(@RequestParam("page") Integer page) {
        return itemService.getWatches(page);
    }


    @GetMapping("/getItem/{id}")
    public ResponseEntity getItem(@PathVariable("id") Long id, Authentication authentication){
        return itemService.getItem(id,authentication);
    }



    @PutMapping("/putItem")
    public ResponseEntity putItem(@RequestBody ItemDTO itemDTO){
        return itemService.putItem(itemDTO);
    }

}
