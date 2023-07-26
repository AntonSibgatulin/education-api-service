package jp.antonsibgatulin.educationapiservice.controllers.items.response;

import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.post_item.PostItem;

import java.util.List;

public class ResponseItemAuth {
    public Item item;
    public List<PostItem> postItems;
    public int count_of_posts;
    public int hours_of_course;

    public ResponseItemAuth(Item item, List<PostItem> postItems, int count_of_posts, int hours_of_course) {
        this.item = item;
        this.postItems = postItems;
        this.count_of_posts = count_of_posts;
        this.hours_of_course = hours_of_course;
    }
}
