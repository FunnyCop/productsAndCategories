package com.logan.productsAndCategories.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.logan.productsAndCategories.mvc.models.Category;
import com.logan.productsAndCategories.mvc.models.Product;

@Repository
public interface ProductRepository extends CrudRepository< Product, Long > {

	// Retrieve

	List< Product > findAll(); // find all products

	Optional< Product > findById( Long id ); // find product by id

	List< Product > findAllByCategories( Category category ); // find all products by category

	List< Product > findByCategoriesNotContains( Category category ); // find all products not by category

}
