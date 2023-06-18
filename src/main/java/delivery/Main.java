package delivery;

import delivery.domain.Item;
import delivery.domain.Member;
import delivery.domain.Store;
import delivery.dto.Address;
import delivery.dto.RoleType;
import delivery.policy.DiscountPolicy;
import delivery.policy.FixDiscountPolicy;
import delivery.policy.RateDiscountPolicy;
import delivery.service.ItemService;
import delivery.service.MemberService;
import delivery.service.StoreService;

import java.time.LocalDateTime;

public class Main {
    private static DiscountPolicy policy = new FixDiscountPolicy();
    private static final MemberService memberService = new MemberService();
    private static final ItemService itemService = new ItemService();
    private static final StoreService storeService = new StoreService(policy);

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            memberService.createMember("user"+i, "홍길동" + i, new Address("구미시", "대학로", "61"), RoleType.CUSTOMER);
        }
        for (int i=0;i<30;i++){
            itemService.createItem((long) i, "메뉴"+i, (int)(Math.random()*10000), (int)(Math.random()*100), null);
        }
        for (int i=0;i<10;i++){
            storeService.createStore((long) i, "맘스터치 "+i+"호점", new Address("구미시", "대학로", "61"), "09:00", "18:00");
        }
        System.out.println("\n\ntest start");
        test();
    }
    public static void test(){
        System.out.println("########회원 기능 테스트#######");
        System.out.println("임의의 회원 추가");
        memberService.createMember("manager001", "관리자", new Address("구미시", "대학로", "61"), RoleType.MANAGER);
        System.out.println("회원 검색 (user51)");
        Member member = memberService.findMember("user51");
        System.out.println("찾은 회원 : " + member.toString());
        System.out.println("\n회원정보 수정");
        member.setName("강태공");
        member.setAddress(new Address("아산시", "백암리", "116"));
        memberService.updateMember(member);
        System.out.println("\n회원 삭제");
        memberService.deleteMember(member);

        System.out.println("\n\n########상품 기능 테스트########");
        System.out.println("임의의 상품 추가");
        itemService.createItem(197L, "딥치즈 싸이", 7600, 50, null);
        System.out.println("상품 검색 (26번 메뉴)");
        Item item = itemService.findItem(26L);
        System.out.println("찾은 상품 : " + item.toString());
        System.out.println("\n상품 정보 수정");
        item.setName("간장마늘 싸이버거");
        item.setStockQuantity(3);
        item.setPrice(9990);
        itemService.updateItem(item);
        System.out.println("\n상품 삭제");
        itemService.deleteItem(item);


        DiscountPolicy policy = new RateDiscountPolicy();
        System.out.println("\n\n########가게 기능 테스트########");
        System.out.println("임의의 가게 추가");
        storeService.createStore(177L, "맘스터치 금오공대점", new Address("구미시", "대학로", "61"), "00:00", "23:59");
        System.out.println("가게 검색 (4호점)");
        Store store = storeService.findStore(4L);
        System.out.println("찾은 가게 : " + store.toString());
        System.out.println("\n가게 정보 수정");
        store.setName("맘스터치 구미점");
        store.setDiscountPolicy(policy);
        storeService.updateStore(store);
        System.out.println("\n가게 삭제");
        storeService.deleteStore(store);
    }
}
