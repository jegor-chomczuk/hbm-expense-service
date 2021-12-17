package com.homebudgetmanager.expensesservice.interfaces;

import com.homebudgetmanager.expensesservice.dao.Expense;

import java.util.List;
import java.util.Optional;

public interface IExpensesService {
    List<Expense> filterExpenses(Long userId, int year, Optional<String> month, Optional<String> category);
    void updateExpense(Expense expense);
}
