package com.purington.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.purington.savetravels.models.Expense;
import com.purington.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	////will instantiate the service object and put it in the member variable for us
	@Autowired
	private ExpenseService expenseService;
	//could alternatively use something like this:
//	 private final BookService bookService;
//	    public BooksApi(BookService bookService){
//	        this.bookService = bookService;
//	    }
	
	//Display
	@GetMapping("/")
	public String index() {
		
		return "redirect:/expenses";
	}
	
	//Display
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	//Action
	@PostMapping("/expenses")
	public String expenses(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses",expenses);
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	//Display
	@GetMapping("/expenses/{id}/edit")
	public String editExpenses(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		
		return "editExpense.jsp";
	}
	
	//Action
	@PutMapping("/expenses/{id}/update")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long expenseId) {
		if (result.hasErrors()) {
			return "editExpense.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}
	
	//Action
	@DeleteMapping("/expenses/{id}/delete")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		
		return "redirect:/expenses";
	}
	

}
