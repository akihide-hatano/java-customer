package customer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomerServiceTest {

    CustomerService service = new CustomerService();

    @Test
    void testRankS() {
        assertEquals("S", service.getCustomerRank(300000, 3, true));
        assertEquals("S", service.getCustomerRank(500000, 10, true));
    }

    @Test
    void testRankA() {
        assertEquals("A", service.getCustomerRank(150000, 1, true));
    }

    @Test
    void testRankB() {
        assertEquals("B", service.getCustomerRank(20000, 0, false));
    }

    @Test
    void testRankC() {
        assertEquals("C", service.getCustomerRank(5000, 0, false));
        assertEquals("C", service.getCustomerRank(0, 0, false));
    }

    @Test
    void testNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                    () -> service.getCustomerRank(-1, 1, true));
    }

    @Test
    void testNegativeYears() {
        assertThrows(IllegalArgumentException.class,
                    () -> service.getCustomerRank(1000, -1, true));
    }

      @Test
    void testCalcPriceWithTax_normal() {
        // 1000円・税率10% → 1100円になってほしい
        int result = service.calcPriceWithTax(1000, 0.1);
        assertEquals(1100, result);
    }

    @Test
    void testCalcPriceWithTax_zero() {
        // 0円ならもちろん0円
        int result = service.calcPriceWithTax(0, 0.1);
        assertEquals(0, result);
    }

    @Test
    void testCalcPriceWithTax_negative() {
        // マイナスなら例外が飛ぶべき
        assertThrows(IllegalArgumentException.class,
            () -> service.calcPriceWithTax(-1, 0.1));
    }
}
