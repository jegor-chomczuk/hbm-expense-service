package com.homebudgetmanager.expensesservice.dao;

import com.homebudgetmanager.expensesservice.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String comment;
    private String date;
    private Double amount;
    private Month month;
    private int year;
    @Column(name="user_id")
    private Long userId;

//    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Expense(String category, Double amount, String month, int year, Long userId)  {
        this.category = category;
        this.amount = amount;
        this.month = Month.valueOf(month.toUpperCase());
        this.year = year;
        this.userId = userId;
        this.date = "0000-00-00";
        this.comment = "";
    }

    public Expense(String category, String comment, String date, Double amount, String month, int year, Long userId){
        this.category = category;
        this.comment = comment;
        this.date = date;
        this.amount = amount;
        this.month = Month.valueOf(month.toUpperCase());
        this.year = year;
        this.userId = userId;
    }
}
