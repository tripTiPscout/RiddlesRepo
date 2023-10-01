package bg.codexio.riddles.codereview;

public class Main {

    public static void main(String[] args) {

        Shop shop = Shop.getInstance(); // Get the Shop instance

        Worker consultant = new SalesConsultant(); // Get the SalesConsultant instance

        Worker specialist = new MarketingSpecialist(); // Get the MarketingSpecialist instance

    }

}
