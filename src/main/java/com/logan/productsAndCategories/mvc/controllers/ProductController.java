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
@RequestMapping( "/product" )
public class ProductController {

	// Initialize Service

	private final ProductService productService;
	private final CategoryService categoryService;

	public ProductController(

		ProductService productService,
		CategoryService categoryService

	) {

		this.productService = productService;
		this.categoryService = categoryService;

	}

	// Create

	@RequestMapping( "/new" )
	public String newCategory( Model model ) {

		if ( !model.containsAttribute( "product" ) )
			model.addAttribute( "product", new Product() );
	
		return "/product/new.jsp"; // create new product form

	}

	@RequestMapping( value = "/new/submit", method = RequestMethod.POST )
	public String submitProduct(

		@Valid @ModelAttribute( "product" ) Product product,
		BindingResult result,
		RedirectAttributes redirectAttributes

	) {

		if ( !result.hasErrors() )
			productService.createProduct( product );

		else {

			redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.product", result );
			redirectAttributes.addFlashAttribute( "product", product );

		}

		return "redirect:/product/new"; // create new product submit

	}

	// Retrieve

	@RequestMapping( "/all" )
	public String allProducts( Model model ) {

		model.addAttribute( "products", productService.findAll() );

		return "/product/all.jsp"; // all products

	}

	@RequestMapping( "/id/{id}" )
	public String oneProduct(

		@PathVariable( "id" ) Long id,
		Model model,
		@ModelAttribute( "category" ) Category category

	) {

		Product product = productService.findById( id );
		model.addAttribute( "product", product );
		model.addAttribute( "categories", categoryService.findAllByProduct( product ) );
		model.addAttribute( "notCategories", categoryService.findByProductsNotContains( product ) );

		return "/product/product.jsp"; // one product

	}

	// Update

	@RequestMapping( value = "/category/add/id/{id}", method = RequestMethod.POST )
	public String addProduct(

		@PathVariable( "id" ) Long id,
		Model model,
		@ModelAttribute( "category" ) Category category

	) {

		productService.addCategory( id, category );

		return "redirect:/product/id/" + String.valueOf( id ); // add category to product

	}

}
