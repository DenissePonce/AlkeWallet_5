package models;

public class User {
    private String name;
    private Account account;

    public User(String name) {
        this.name = name;
        this.account = new Account();
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}
