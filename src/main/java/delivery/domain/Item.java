package delivery.domain;

import delivery.exception.NotEnoughStockException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Item {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private List<Option> options;

    public Item(Long id, String name, int price, int stockQuantity, List<Option> options) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.options = options;
    }

    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
