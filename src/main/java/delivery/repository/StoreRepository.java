package delivery.repository;

import delivery.domain.Store;
import delivery.dto.Address;
import delivery.policy.DiscountPolicy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    private final List<Store> stores = new ArrayList<>();

    public void create(Store store){
        stores.add(store);
    }
    public Store findById(Long id){
        for (Store s :stores){
            if (s.getId().equals(id))
                return s;
        }
        return null;
    }
    public void delete(Store store){
        stores.remove(store);
    }
}
