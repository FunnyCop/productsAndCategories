package com.logan.productsAndCategories.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name = "categories" )
public class Category {

	// Columns/Fields

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id; // category.id

	@NotNull
	@Size( min = 2, max = 255 )
	private String name; // category.name

	@Column( updatable = false )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdAt; // category.createdAt

	@DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date updatedAt; // category.updatedAt

	@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable(

		name = "categories_products",
		joinColumns = @JoinColumn( name = "category_id" ),
		inverseJoinColumns = @JoinColumn( name = "product_id" )

	)
	private List< Product > products; // category.products

	// created_at generator

    @PrePersist
 	protected void onCreate()
    	{ this.createdAt = new Date(); } // category.createdAt

    // updated_at generator

 	@PreUpdate
 	protected void onUpdate()
 		{ this.updatedAt = new Date(); } // category.updatedAt

 	// Getters

  	public Long getId()
  		{ return this.id; } // category.id

  	public String getName()
  		{ return this.name; } // category.name

  	public Date getCreatedAt()
  		{ return this.createdAt; } // category.createdAt

  	public Date getUpdatedAt()
  		{ return this.updatedAt; } // category.updatedAt

  	public List< Product > getProducts()
  		{ return this.products; } // category.products

  	// Setters

  	public void setId( Long id )
  		{ this.id = id; } // category.id

  	public void setName( String name )
  		{ this.name = name; } // category.name

  	public void setProducts( List< Product > products )
  		{ this.products = products; } // category.products

  	// Constructors

  	public Category() {}

  	public Category( String name )
  		{ this.name = name; }

}
