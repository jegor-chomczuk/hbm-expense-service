package com.homebudgetmanager.expensesservice.controller;

import com.homebudgetmanager.expensesservice.dao.Expense;
import com.homebudgetmanager.expensesservice.interfaces.IExpensesService;
import com.homebudgetmanager.expensesservice.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
//@Transactional
@RestController
@RequestMapping("/expense/")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private IExpensesService expensesService;


    // GET Methods
    //  http://localhost:8200/expense/all
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    //  http://localhost:8200/expense/id/1
    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseRepository.findById(id);
    }

    //  http://localhost:8200/expense/user-id/1/year/2021
    //  http://localhost:8200/expense/user-id/1/year/2021/?month=january
    //  http://localhost:8200/expense/user-id/1/year/2021/?category=Debt repayment
    //  http://localhost:8200/expense/user-id/1/year/2021/?month=january&category=Debt repayment
    @GetMapping("user-id/{userId}/year/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<Expense> getFilteredExpenses(@PathVariable Long userId, @PathVariable int year, @RequestParam Optional<String> month, @RequestParam Optional<String> category) {
        return expensesService.filterExpenses(userId, year, month, category);
    }

//    //  http://localhost:8200/expense/user-id/1/year/2021
//    @GetMapping("user-id/{userId}/year/{year}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Expense> getExpenseByUserIdAndYear(@PathVariable Long userId, @PathVariable int year) {
//        return expenseRepository.findByUserIdAndYear(userId, year);
//    }
//
//    //  http://localhost:8200/expense/user-id/1/month/january/year/2021
//    @GetMapping("user-id/{userId}/month/{month}/year/{year}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Expense> getExpenseByUserIdAndMonthAndYear(@PathVariable Long userId, @PathVariable String month, @PathVariable int year) {
//        return expenseRepository.findByUserIdAndMonthAndYear(userId, Month.valueOf(month.toUpperCase()), year);
//    }
//
//    //  http://localhost:8200/expense/user-id/1/category/Debt repayment/year/2021
//    @GetMapping("user-id/{userId}/category/{category}/year/{year}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Expense> getExpenseByUserIdAndCategoryAndYear(@PathVariable Long userId, @PathVariable String category, @PathVariable int year) {
//        return expenseRepository.findByUserIdAndCategoryAndYear(userId,category, year);
//    }
//
//    //  http://localhost:8200/expense/user-id/1/category/Debt repayment/month/january/year/2021
//    @GetMapping("user-id/{userId}/category/{category}/month/{month}/year/{year}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Expense> getExpenseByUserIdAndCategoryAndMonthAndYear(@PathVariable Long userId, @PathVariable String month, @PathVariable String category, @PathVariable int year) {
//        return expenseRepository.findByUserIdAndMonthAndCategoryAndYear(userId, Month.valueOf(month.toUpperCase()), category, year);
//    }

    //  DELETE Methods
    //  http://localhost:8200/expense/delete/id/1
    @DeleteMapping("delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpenseById(@PathVariable Long id){
        expenseRepository.deleteById(id);
    }

    //  http://localhost:8200/expense/delete/user-id/1
    @DeleteMapping("delete/user-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpensesByUserId(@PathVariable Long id){
        expenseRepository.deleteByUserId(id);
    }

    //  http://localhost:8200/expense/delete/category/Debt repayment
    @DeleteMapping("delete/category/{category}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpensesByCategory(@PathVariable String category){
        expenseRepository.deleteByCategory(category);
    }

    //  POST Method
    //  http://localhost:8200/expense/add
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExpense(@RequestBody Expense expense){
        expenseRepository.save(expense);
    }

    //  PUT Method
    //  http://localhost:8200/expense/update/id/1
    @PutMapping("update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExpense(@RequestBody Expense expense){
        expensesService.updateExpense(expense);
    }
}