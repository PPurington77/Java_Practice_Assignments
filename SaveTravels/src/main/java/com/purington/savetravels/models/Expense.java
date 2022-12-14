package com.purington.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//Expense will include: ID, Expense, Vendor, Amount, Description, created&updated at
//Validations: no empty fields, amount greater than 0

@Entity
@Table(name="expenses")
public class Expense {
	//***************Primary Key********************
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//**************Member Variables****************
	
	@NotNull(message="Field must not be empty")
	@Size(min = 3, max = 200, message="Must be atleast 3 characters long")
	private String type;
	
	@NotNull(message="Field must not be empty")
	@Size(min = 3, max = 200, message="Must be atleast 3 characters long")
	private String vendor;
	
	@NotNull(message="Field must not be empty")
	@Min(value =1, message="must be greater than 0")
	private Double amount;
	
	@NotNull(message="Field must not be empty")
	@Size(min = 3, max = 200, message="Must be atleast 3 characters long")
	private String description;
	
	//************Data Creation Variables************
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//************Data Creation Event***************
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//***********Constructors***********************
	
	public Expense() {
	}
	
	public Expense(String type, String vendor, Double amount, String description) {
		this.type = type;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	//********Getters and Setters*******************
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
