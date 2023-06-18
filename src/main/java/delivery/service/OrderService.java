package delivery.service;

import delivery.domain.*;
import delivery.dto.DeliveryStatus;
import delivery.exception.NotEnoughStockException;
import delivery.repository.ItemRepository;
import delivery.repository.MemberRepository;
import delivery.repository.OrderRepository;
import delivery.repository.StoreRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public final OrderRepository orderRepository = new OrderRepository();
    private final ItemRepository itemRepository = new ItemRepository();
    private final MemberRepository memberRepository = new MemberRepository();
    private final StoreRepository storeRepository = new StoreRepository();

    public void order(Long storeId, String memberId, List<Long> itemIds, int count) {
        Store store = storeRepository.findById(storeId);
        if (Integer.parseInt(store.getOpen()) > LocalDateTime.now().getHour() || Integer.parseInt(store.getClose()) < LocalDateTime.now().getHour())
        {
            System.out.println("주문 가능한 시간대가 아닙니다.");
            return;
        }

        Member member = memberRepository.findById(memberId);
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        List<OrderItem> orderItems = new ArrayList<>();
        int totalPrice = 0;

        for (Long itemId : itemIds){
            Item item = itemRepository.findById(itemId);
            if (item.getStockQuantity() < 1){
                throw new NotEnoughStockException("재고가 부족하여 주문이 불가능합니다.");
            }
            OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
            orderItems.add(orderItem);
            totalPrice += item.getPrice();
        }
        
        if (totalPrice < store.getMinimumOrderPrice()){
            System.out.println("최소주문금액 미달로 주문이 불가능합니다.");
            return;
        }
        
        Order order = Order.createOrder(member, delivery, orderItems);

        orderRepository.create(order);

        System.out.println("주문 번호 : " + order.getId());
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
