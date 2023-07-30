package jp.antonsibgatulin.educationapiservice.controllers.items.response;

import jp.antonsibgatulin.educationapiservice.entity.item.Item;

import java.util.List;

public class ResponsePopularsAndWatches {
    public List<Item> itemList;

    public ResponsePopularsAndWatches(List<Item> itemList) {
        this.itemList = itemList;
    }
}
