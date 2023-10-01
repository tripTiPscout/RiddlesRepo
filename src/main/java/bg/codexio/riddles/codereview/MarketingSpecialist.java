package bg.codexio.riddles.codereview;

import java.math.BigDecimal;

public class MarketingSpecialist implements Worker {

    private final Shop workingShop;

    private BigDecimal budget = new BigDecimal("5000.00");

    public MarketingSpecialist() {
        this.workingShop = Shop.getInstance();
        this.workingShop.addWorker(this);
    }

    public void spendMoney(BigDecimal marketingCampaignCost) {
        if (marketingCampaignCost.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Error: marketingCampaignCost must be non-negative.");
        }
        this.budget = this.budget.subtract(marketingCampaignCost);
    }

    public BigDecimal getBudget() {
        return this.budget;
    }
}
