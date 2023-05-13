package delivery.domain;

import lombok.Data;

@Data
public class OrderItem {
    private Long id;
    private Order order;
    private Item item;
    private int orderPrice;
    private int count;

    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }
    public void cancel() {
        getItem().addStock(count);
    }
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
