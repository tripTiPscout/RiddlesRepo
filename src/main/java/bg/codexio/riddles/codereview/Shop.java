package bg.codexio.riddles.codereview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static Shop instance;

    private final List<Worker> workers;

    private Shop() {
        workers = new ArrayList<>();
    }

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public BigDecimal getTurnover() {
        BigDecimal turnOver = BigDecimal.ZERO;

        for (Worker worker : this.workers) {
            if (worker instanceof SalesConsultant) {
                turnOver = turnOver.add(((SalesConsultant) worker).getMoney());
            } else if (worker instanceof MarketingSpecialist) {
                turnOver = turnOver.add(((MarketingSpecialist) worker).getBudget());
            } else {
                System.out.printf("Unrecognized worker type for: %s\n", worker);
            }
        }
        return turnOver;
    }
}
