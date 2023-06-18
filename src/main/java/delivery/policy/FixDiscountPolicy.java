package delivery.policy;

public class FixDiscountPolicy implements DiscountPolicy {
    public int discount(int totalPrice){
        if (totalPrice <= 10000)
            return 0;
        else if (totalPrice <= 20000)
            return 500;
        else if (totalPrice <= 50000)
            return 1500;
        else if (totalPrice <= 100000)
            return 4000;
        else return 10000;
    }
}
