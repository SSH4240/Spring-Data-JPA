package delivery.policy;

public class RateDiscountPolicy implements DiscountPolicy{
    public int discount(int totalPrice){
        return (totalPrice/10);
    }
}
