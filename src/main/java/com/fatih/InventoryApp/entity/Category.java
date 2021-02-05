package com.fatih.InventoryApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	public Category() {

	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(Integer id) {
		this.id = id;
	}
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
