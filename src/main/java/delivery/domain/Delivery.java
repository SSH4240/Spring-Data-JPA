package delivery.domain;

import delivery.dto.Address;
import delivery.dto.DeliveryStatus;
import lombok.Data;

@Data
public class Delivery {
    private Long id;

    private Order order;

    private Address address;

    private DeliveryStatus status;
}
