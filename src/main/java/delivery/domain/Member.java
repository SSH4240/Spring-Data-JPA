package delivery.domain;

import delivery.dto.Address;
import delivery.dto.RoleType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Member {
    private String id;
    private String name;
    private Address address;
    private List<Order> orders = new ArrayList<>();
    private RoleType roleType;

    public void addOrder(Order order){
        orders.add(order);
        order.setMember(this);
    }

    public Member(String id, String name, Address address, RoleType roleType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.roleType = roleType;
    }
}
