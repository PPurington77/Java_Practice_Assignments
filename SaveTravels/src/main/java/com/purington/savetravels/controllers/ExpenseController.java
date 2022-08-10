package com.purington.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/")
	public String index() {
		
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
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
	

}
