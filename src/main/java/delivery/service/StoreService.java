package delivery.service;

import delivery.domain.Store;
import delivery.dto.Address;
import delivery.policy.DiscountPolicy;
import delivery.repository.ItemRepository;
import delivery.repository.StoreRepository;

import java.time.LocalDateTime;

public class StoreService {
    private final DiscountPolicy discountPolicy;
    private static final StoreRepository storeRepository = new StoreRepository();

    public StoreService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void createStore(Long id, String name, Address address, String open, String close, int 가격){
        Store store = new Store(id, name, address, open, close, discountPolicy, 가격);
        storeRepository.create(store);
        System.out.println("new store created : " + store.toString());
    }

    public Store findStore(Long id){
        return storeRepository.findById(id);
    }

    public void updateStore(Store store){
        Store findStore = storeRepository.findById(store.getId());
        findStore.setName(store.getName());
        findStore.setAddress(store.getAddress());
        findStore.setOpen(store.getOpen());
        findStore.setClose(store.getClose());
        findStore.setDiscountPolicy(store.getDiscountPolicy());
        System.out.println("store updated : " + findStore.toString());
    }

    public void deleteStore(Store store){
        Long storeId = store.getId();
        storeRepository.delete(store);
        System.out.println("store deleted. id : " + storeId);
    }
}
