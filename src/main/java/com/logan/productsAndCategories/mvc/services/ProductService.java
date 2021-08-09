package com.logan.productsAndCategories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.logan.productsAndCategories.mvc.models.Category;
import com.logan.productsAndCategories.mvc.models.Product;
import com.logan.productsAndCategories.mvc.repositories.ProductRepository;

@Service
public class ProductService {

	// Initialize Repository

	private final ProductRepository productRepository;

	public ProductService( ProductRepository productRepository )
		{ this.productRepository = productRepository; }

	// Create

	public Product createProduct( Product product )
		{ return productRepository.save( product ); } // create new product

	// Retrieve

	public List< Product > findAll()
		{ return productRepository.findAll(); } // find all products

	public Product findById( Long id ) {

		Optional< Product > product = productRepository.findById( id );

		if ( product.isPresent() )
			return product.get(); // find product by id

		return null; // or null

	}

	public List< Product > findAllByCategories( Category category )
		{ return productRepository.findAllByCategories( category ); } // find all products by category

	public List< Product > findByCategoriesNotContains( Category category )
		{ return productRepository.findByCategoriesNotContains( category ); } // find all products by category not contains

	// Update

	public Product addCategory( Long id, Category category ) {

		Optional< Product > optionalProduct = productRepository.findById( id );

		if ( optionalProduct.isPresent() ) {

			Product product = optionalProduct.get();
			List< Category > categories = product.getCategories();
			categories.add( category );
			product.setCategories( categories );
			product.setId( id );

			return productRepository.save( product ); // add category to product

		}

		return null; // or null

	}

	// Delete

	public String deleteProduct( Long id ) {

		productRepository.deleteById( id );

		return "Deleted ID " + String.valueOf( id ); // delete product by id
	}

}
