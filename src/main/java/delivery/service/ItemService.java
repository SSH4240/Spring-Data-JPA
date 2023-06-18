package delivery.service;

import delivery.domain.Item;
import delivery.domain.Option;
import delivery.repository.ItemRepository;

import java.util.List;

public class ItemService {
    private static final ItemRepository itemRepository = new ItemRepository();

    public void createItem(Long id, String name, int price, int stockQuantity, List<Option> options){
        Item item = new Item(id, name, price, stockQuantity, options);
        itemRepository.create(item);
        System.out.println("New Item Created : " + item.toString());
    }
    public Item findItem(Long id){
        return itemRepository.findById(id);
    }

    public void updateItem(Item item){
        Item findItem = itemRepository.findById(item.getId());
        findItem.setName(item.getName());
        findItem.setPrice(item.getPrice());
        findItem.setStockQuantity(item.getStockQuantity());
        findItem.setOptions(item.getOptions());

        System.out.println("Item Updated : " + findItem.toString());
    }
    public void deleteItem(Item item){
        Long itemId = item.getId();
        itemRepository.delete(item);
        System.out.println("Item Deleted. id : " + itemId);
    }
}
