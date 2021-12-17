package com.homebudgetmanager.expensesservice.repository;

import com.homebudgetmanager.expensesservice.dao.Expense;
import com.homebudgetmanager.expensesservice.enums.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository <Expense, Long> {
    List<Expense> findByUserIdAndYear(Long userId, int year);
    List<Expense> findByUserIdAndCategoryAndYear(Long userId, String category, int year);
    List<Expense> findByUserIdAndMonthAndYear(Long userId, Month month, int year);
    List<Expense> findByUserIdAndMonthAndCategoryAndYear(Long userId, Month month, String category, int year);
    void deleteByUserId(Long id);
    void deleteByCategory(String category);
}