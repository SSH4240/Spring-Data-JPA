package delivery.service;

import delivery.domain.*;
import delivery.dto.DeliveryStatus;
import delivery.repository.ItemRepository;
import delivery.repository.MemberRepository;
import delivery.repository.OrderRepository;

public class OrderService {
    public final OrderRepository orderRepository = new OrderRepository();
    private final ItemRepository itemRepository = new ItemRepository();
    private final MemberRepository memberRepository = new MemberRepository();

    public Long order(String memberId, Long itemId, int count) {
        Member member = memberRepository.findById(memberId);
        Item item = itemRepository.findById(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.create(order);

        return order.getId();
    }
    public void updateOrder(Order order){
        Order findOrder = orderRepository.findById(order.getId());
        findOrder.setMember(order.getMember());
        findOrder.setOrderDate(order.getOrderDate());
        findOrder.setOrderItems(order.getOrderItems());
        findOrder.setStatus(order.getStatus());
        findOrder.setDelivery(order.getDelivery());
    }
    public Order findOrder(Long orderId){
        return orderRepository.findById(orderId);
    }
    public void deleteOrder(Order order){
        Long id = order.getId();
        orderRepository.delete(order);
        System.out.println("order deleted, id : " + id);
    }
}
