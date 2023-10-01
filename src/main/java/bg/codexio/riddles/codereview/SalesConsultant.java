package bg.codexio.riddles.codereview;

import java.math.BigDecimal;

public class SalesConsultant implements Worker {

    private final Shop workingShop;

    private BigDecimal earnedMoney;

    public SalesConsultant() {
        this.workingShop = Shop.getInstance();
        this.workingShop.addWorker(this);
        this.earnedMoney = BigDecimal.ZERO;
    }

    public void sellProduct(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Error: price must be non-negative.");
        }
        this.earnedMoney = this.earnedMoney.add(price);
    }

    public BigDecimal getMoney() {
        return this.earnedMoney;
    }
}
