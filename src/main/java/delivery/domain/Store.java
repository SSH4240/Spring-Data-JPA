package delivery.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Store {
    private Long id;
    private String name;
    private Address address;
    private LocalDateTime open;
    private LocalDateTime close;
}
