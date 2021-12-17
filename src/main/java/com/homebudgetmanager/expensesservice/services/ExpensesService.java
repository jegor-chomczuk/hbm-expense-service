package com.homebudgetmanager.expensesservice.services;

import com.homebudgetmanager.expensesservice.dao.Expense;
import com.homebudgetmanager.expensesservice.enums.Month;
import com.homebudgetmanager.expensesservice.interfaces.IExpensesService;
import com.homebudgetmanager.expensesservice.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService implements IExpensesService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> filterExpenses(Long userId, int year, Optional<String> month, Optional<String> category){

        if (month.isPresent() && category.isPresent()){
            return expenseRepository.findByUserIdAndMonthAndCategoryAndYear(userId, Month.valueOf(month.get().toUpperCase()), category.get(), year);
        } else if (!month.isPresent() && category.isPresent()){
            return expenseRepository.findByUserIdAndCategoryAndYear(userId,category.get(), year);
        } else if (month.isPresent() && !category.isPresent()) {
            return expenseRepository.findByUserIdAndMonthAndYear(userId, Month.valueOf(month.get().toUpperCase()), year);
        } else {
            return expenseRepository.findByUserIdAndYear(userId, year);
        }
    }

    public void updateExpense(Expense expense){
        Optional<Expense> storedExpense = expenseRepository.findById(expense.getId());
        if (storedExpense.isPresent()) {
            storedExpense.get().setCategory(expense.getCategory());
            storedExpense.get().setComment(expense.getComment());
            storedExpense.get().setDate(expense.getDate());
            storedExpense.get().setAmount(expense.getAmount());

            expenseRepository.save(storedExpense.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no expense with provided id.");
        }
    }
}