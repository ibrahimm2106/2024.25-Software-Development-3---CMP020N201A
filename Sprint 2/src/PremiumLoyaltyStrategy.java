/**
 * Premium loyalty strategy: 2 points per £1 spent (rounded up).
 */
public class PremiumLoyaltyStrategy implements LoyaltyStrategy {
    @Override
    public int calculatePoints(double cost) {
        return (int) Math.ceil(cost * 2);
    }
}
