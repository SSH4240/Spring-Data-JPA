package delivery.repository;

import delivery.domain.Member;
import delivery.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public Order create(Order order){
        orders.add(order);
        return order;
    }
    public List<Order> findAll(){
        return orders;
    }
    public Order findById(Long orderId){
        for (Order order : orders){
            if (order.getId().equals(orderId))
                return order;
        }
        return null;
    }
    public List<Order> findOrdersByUserId(String userId) {
        List<Order> orderList = new ArrayList<>();
        for(Order order : orders){
            if (order.getMember().getId().equals(userId)){
                orderList.add(order);
            }
        }
        return orderList;
    }
    public void delete(Order order){
        orders.remove(order);
    }
}
