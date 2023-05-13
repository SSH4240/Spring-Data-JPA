package delivery.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Member {
    private String id;
    private String name;
    private Address address;
    private List<Order> orders = new ArrayList<>();
    private RoleType roleType;
}
