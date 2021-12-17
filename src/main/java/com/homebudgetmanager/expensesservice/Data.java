package com.homebudgetmanager.expensesservice;

import com.homebudgetmanager.expensesservice.dao.Expense;
import com.homebudgetmanager.expensesservice.enums.Month;
import com.homebudgetmanager.expensesservice.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Data {
    @Autowired
    private ExpenseRepository expenseRepository;

    public void populate() throws ParseException {
//        expenseRepository.save(new Expense("Debt repayment", 10.00, "january", 2021, 1l));
//        expenseRepository.save(new Expense("Debt repayment", 11.00, Month.MARCH, 2021, 1l));
//        expenseRepository.save(new Expense("Savings", 12.00, Month.JANUARY, 2021, 1l));
//        expenseRepository.save(new Expense("Debt repayment", 13.00, Month.JANUARY, 2022, 2l));
//        expenseRepository.save(new Expense("Food", 14.00, Month.FEBRUARY, 2021, 1l));
//        expenseRepository.save(new Expense("Apartment / house", 15.00, Month.FEBRUARY, 2021, 1l));
//        expenseRepository.save(new Expense("Savings", 16.00, Month.FEBRUARY, 2022, 2l));

    }
}
