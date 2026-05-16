/**
 * Standard loyalty strategy: 1 point per £1 spent (rounded up).
 */
public class StandardLoyaltyStrategy implements LoyaltyStrategy {
    @Override
    public int calculatePoints(double cost) {
        return (int) Math.ceil(cost);
    }
}
