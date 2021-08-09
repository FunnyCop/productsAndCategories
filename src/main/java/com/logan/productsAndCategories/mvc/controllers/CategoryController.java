package com.logan.productsAndCategories.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.logan.productsAndCategories.mvc.models.Category;
import com.logan.productsAndCategories.mvc.models.Product;
import com.logan.productsAndCategories.mvc.services.CategoryService;
import com.logan.productsAndCategories.mvc.services.ProductService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Controller
@RequestMapping( "/category" )
public class CategoryController {

	// Initialize Service

	private final CategoryService categoryService;
	private final ProductService productService;

	public CategoryController(

		CategoryService categoryService,
		ProductService productService

	) {

		this.categoryService = categoryService;
		this.productService = productService;

	}

	// Create

	@RequestMapping( "/new" )
	public String newCategory( Model model ) {

		if ( !model.containsAttribute( "category" ) )
			model.addAttribute( "category", new Category() );
	
		return "/category/new.jsp"; // create new category form

	}

	@RequestMapping( value = "/new/submit", method = RequestMethod.POST )
	public String submitCategory(

		@Valid @ModelAttribute( "category" ) Category category,
		BindingResult result,
		RedirectAttributes redirectAttributes

	) {

		if ( !result.hasErrors() )
			categoryService.createCategory( category );

		else {

			redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.category", result );
			redirectAttributes.addFlashAttribute( "category", category );

		}

		return "redirect:/category/new"; // create new category submit

	}

	// Retrieve

	@RequestMapping( "/all" )
	public String allCategories( Model model ) {

		model.addAttribute( "categories", categoryService.findAll() );

		return "/category/all.jsp"; // all categories

	}

	@RequestMapping( "/id/{id}" )
	public String oneCategory(

		@PathVariable( "id" ) Long id,
		Model model,
		@ModelAttribute( "product" ) Product product

	) {

		Category category = categoryService.findByID( id );
		model.addAttribute( "category", category );
		model.addAttribute( "products", productService.findAllByCategories( category ) );
		model.addAttribute( "notProducts", productService.findByCategoriesNotContains( category ) );

		return "/category/category.jsp"; // one category

	}

	// Update

	@RequestMapping( value = "/product/add/id/{id}", method = RequestMethod.POST )
	public String addProduct(

		@PathVariable( "id" ) Long id,
		Model model,
		@ModelAttribute( "product" ) Product product

	) {

		categoryService.addProduct( id, product );

		return "redirect:/category/id/" + String.valueOf( id ); // add product to category

	}
}
