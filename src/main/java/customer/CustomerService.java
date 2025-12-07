package customer;

public class CustomerService {

    public String getCustomerRank(int annualAmount, int years, boolean emailVerified) {

        if (annualAmount < 0 || years < 0) {
            throw new IllegalArgumentException("金額や年数はマイナスにできません");
        }

        // Sランク
        if (annualAmount >= 300000 && years >= 3 && emailVerified) {
            return "S";
        }

        // Aランク
        if (annualAmount >= 100000 && emailVerified) {
            return "A";
        }

        // Bランク
        if (annualAmount >= 10000) {
            return "B";
        }

        // Cランク
        return "C";
    }

    public int calcPriceWithTax(int priceWithoutTax,double taxRate){
        if(priceWithoutTax <0 ){
            throw new IllegalArgumentException("金額はマイナスに出来ません");
        }

        return (int)Math.round(priceWithoutTax+(1* taxRate));
    }
}
