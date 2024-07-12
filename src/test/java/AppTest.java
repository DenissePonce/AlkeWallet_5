package test;

import models.User;
import org.junit.Before;
import org.junit.Test;
import services.AccountService;
import services.CurrencyConverterService;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private AccountService accountService;
    private CurrencyConverterService currencyConverterService;
    private User user;

    @Before
    public void setUp() {
        accountService = new AccountService();
        currencyConverterService = new CurrencyConverterService();
        user = new User("TestUser");
    }

    @Test
    public void testDeposit() {
        accountService.deposit(user, 100);
        assertEquals(100, user.getAccount().getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        accountService.deposit(user, 100);
        accountService.withdraw(user, 50);
        assertEquals(50, user.getAccount().getBalance(), 0.01);
    }

    @Test
    public void testConvertToEuros() {
        accountService.deposit(user, 100);
        double euros = currencyConverterService.convertToEuros(user.getAccount().getBalance());
        assertEquals(85, euros, 0.01);
    }
}
