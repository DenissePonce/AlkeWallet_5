package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;
import services.CurrencyConverterService;

public class HomeController {
    
    private AccountService accountService;
    private CurrencyConverterService currencyConverterService;
    
    public HomeController() {
        this.accountService = new AccountService();
        this.currencyConverterService = new CurrencyConverterService();
    }

    public String index(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login.jsp";
        }
        request.setAttribute("balance", accountService.getBalance(user));
        return "/index.jsp";
    }

    public String deposit(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login.jsp";
        }
        double amount = Double.parseDouble(request.getParameter("amount"));
        accountService.deposit(user, amount);
        request.setAttribute("balance", accountService.getBalance(user));
        return "/deposit.jsp";
    }

    public String withdraw(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login.jsp";
        }
        double amount = Double.parseDouble(request.getParameter("amount"));
        accountService.withdraw(user, amount);
        request.setAttribute("balance", accountService.getBalance(user));
        return "/withdraw.jsp";
    }

    public String convert(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login.jsp";
        }
        double balance = accountService.getBalance(user);
        double convertedAmount = currencyConverterService.convertToEuros(balance);
        request.setAttribute("convertedAmount", convertedAmount);
        return "/convert.jsp";
    }
}
