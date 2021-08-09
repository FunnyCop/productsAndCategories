package com.logan.productsAndCategories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.logan.productsAndCategories.mvc.models.Category;
import com.logan.productsAndCategories.mvc.models.Product;
import com.logan.productsAndCategories.mvc.repositories.CategoryRepository;

@Service
public class CategoryService {

	// Initialize Repository

	public final CategoryRepository categoryRepository; // categoryRepository

	public CategoryService( CategoryRepository categoryRepository )
		{ this.categoryRepository = categoryRepository; }

	// Create

	public Category createCategory( Category category )
		{ return categoryRepository.save( category ); } // create new category

	// Retrieve

	public List< Category > findAll()
		{ return categoryRepository.findAll(); } // find all categories

	public Category findByID( Long id ) {

		Optional< Category > category = categoryRepository.findById( id );

		if ( category.isPresent() )
			return category.get(); // find category by id

		return null; // or null

	}

	public List< Category > findAllByProduct( Product product )
		{ return categoryRepository.findAllByProducts( product ); } // find all categories by product

	public List< Category > findByProductsNotContains( Product product )
		{ return categoryRepository.findByProductsNotContains( product ); } // find all categories by product not contains

	// Update

	public Category addProduct( Long id, Product product ) {

		Optional< Category > optionalCategory = categoryRepository.findById( id );

		if ( optionalCategory.isPresent() ) {

			Category category = optionalCategory.get();
			List< Product > products = category.getProducts();
			products.add( product );
			category.setProducts( products );
			category.setId( id );

			return categoryRepository.save( category ); // add product to category

		}

		return null; // or null

	}

	// Delete

	public String deleteCategory( Long id ) {

		categoryRepository.deleteById( id );

		return "Deleted ID " + String.valueOf( id ); // delete category by id

	}

}
