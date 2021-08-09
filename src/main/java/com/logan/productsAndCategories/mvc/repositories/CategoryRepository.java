package com.logan.productsAndCategories.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.logan.productsAndCategories.mvc.models.Category;
import com.logan.productsAndCategories.mvc.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository< Category, Long > {

	// Retrieve

	List< Category > findAll(); // find all categories

	Optional< Category > findById( Long id ); // find category by id

	List< Category > findAllByProducts( Product product ); // find all categories by product

	List< Category > findByProductsNotContains( Product product ); // find all categories by product not contains

}
