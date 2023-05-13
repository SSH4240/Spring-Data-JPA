package delivery.domain;

import delivery.exception.NotEnoughStockException;
import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private List<Option> options;

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
