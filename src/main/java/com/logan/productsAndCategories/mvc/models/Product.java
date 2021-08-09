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
@Table( name = "products" )
public class Product {

	// Columns/Fields

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id; // product.id

	@NotNull
	@Size( min = 2, max = 255 )
	private String name; // product.name

	@NotNull
	@Size( min = 10 )
	private String description; // product.description

	@NotNull
	private double price; // product.price

	@Column( updatable = false )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdAt; // product.createdAt

	@DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date updatedAt; // product.updatedAt

	@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable(

		name = "categories_products",
		joinColumns = @JoinColumn( name = "product_id" ),
		inverseJoinColumns = @JoinColumn( name = "category_id" )

	)
	private List< Category > categories; // product.categories

	// created_at generator

    @PrePersist
 	protected void onCreate()
    	{ this.createdAt = new Date(); } // product.createdAt

    // updated_at generator

 	@PreUpdate
 	protected void onUpdate()
 		{ this.updatedAt = new Date(); } // product.updatedAt

 	// Getters

   	public Long getId()
   		{ return this.id; } // product.id

   	public String getName()
   		{ return this.name; } // product.name

   	public String getDescription()
		{ return this.description; } // product.description

   	public double getPrice()
		{ return this.price; } // product.price

   	public Date getCreatedAt()
   		{ return this.createdAt; } // product.createdAt

   	public Date getUpdatedAt()
   		{ return this.updatedAt; } // product.updatedAt

   	public List< Category > getCategories()
   		{ return this.categories; } // product.categories

   	// Setters

   	public void setId( Long id )
   		{ this.id = id; } // product.id

   	public void setName( String name )
   		{ this.name = name; } // product.name

   	public void setDescription( String description )
		{ this.description = description; } // product.description

   	public void setPrice( double price )
   		{ this.price = price; } // product.price

   	public void setCategories( List< Category > categories )
   		{ this.categories = categories; } // product.categories

   	// Constructors

   	public Product() {}

   	public Product(

   		String name,
   		String description,
   		double price

   	) {

   		this.name = name;
   		this.description = description;
   		this.price = price;

   	}

}
