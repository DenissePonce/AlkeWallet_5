package services;

import models.User;

public class AccountService {

    public double getBalance(User user) {
        return user.getAccount().getBalance();
    }

    public void deposit(User user, double amount) {
        user.getAccount().deposit(amount);
    }

    public void withdraw(User user, double amount) {
        user.getAccount().withdraw(amount);
    }
}
