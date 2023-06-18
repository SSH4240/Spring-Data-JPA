package delivery.domain;

import delivery.dto.Address;
import delivery.policy.DiscountPolicy;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Store {
    private Long id;
    private String name;
    private Address address;
    private String open;
    private String close;
    private DiscountPolicy discountPolicy;
    private int minimumOrderPrice;

    public Store(Long id, String name, Address address, String open, String close, DiscountPolicy discountPolicy, int price) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.open = open;
        this.close = close;
        this.discountPolicy = discountPolicy;
        this.minimumOrderPrice = price;
    }
}
