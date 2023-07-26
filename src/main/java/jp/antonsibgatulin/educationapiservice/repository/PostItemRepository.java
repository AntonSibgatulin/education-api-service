package jp.antonsibgatulin.educationapiservice.repository;

import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.post_item.PostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostItemRepository extends JpaRepository<PostItem,Long> {
    Long countPostItemByItem(Item item);
    List<PostItem> findAllByItem(Item item);
}
