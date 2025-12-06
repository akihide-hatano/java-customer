package customer;

public class Main {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();

        System.out.println(service.getCustomerRank(500000, 5, true));  // S
        System.out.println(service.getCustomerRank(150000, 1, true));  // A
        System.out.println(service.getCustomerRank(20000,  0, false)); // B
        System.out.println(service.getCustomerRank(5000,   0, false)); // C
    }
}
