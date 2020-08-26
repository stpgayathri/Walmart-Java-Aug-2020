package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Product;
import com.repository.ProductRepostory;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepostory repository;
	
	
	@GetMapping("/add")
	public String add(Model model){
		
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		
		List<Product> products =  repository.fetchAll();
		return new ModelAndView("listProducts", "allProducts", products);
	}
	
	@PostMapping("/save")
	public String save(@Valid Product product, BindingResult bindingResult) {
		
		System.out.println("ProductController.save(): " + product.getId() + " " + product.getName() + " " + product.getPrice());
		if(bindingResult.hasErrors()) {
			
			return "addProduct";
		}
		else {
			
			try {
				
				repository.save(product);
				return "redirect: list";
				
			} catch (Exception e) {
				
				e.printStackTrace();
				bindingResult.addError(new ObjectError("product", "Failed to Save " + e.getMessage()));
				return "addProduct";
			}	
		}
	}
	
}
