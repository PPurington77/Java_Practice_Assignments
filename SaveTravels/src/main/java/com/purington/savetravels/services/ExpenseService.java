package com.purington.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.purington.savetravels.models.Expense;
import com.purington.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	//adding ExpenseRepository as a dependency
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	//CRUD BELOW************************
	
	//READ******************************
	
	//Gets all expenses
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	//Gets a single expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else return null;
	}
	
	//CREATE**************************
	
	//create a single expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	//UPDATE*************************
	
	//update a single expense
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	//DELETE************************
	
	//delete a single expense
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
