package delivery.repository;

import delivery.domain.Item;
import delivery.domain.Option;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private final List<Item> items = new ArrayList<>();

    public void create(Item item){
        items.add(item);
    }


    public void delete(Item item){
        items.remove(item);
    }

    public Item findById(Long itemId){
        for (Item item : items){
            if (item.getId().equals(itemId))
                return item;
        }
        return null;
    }
}
