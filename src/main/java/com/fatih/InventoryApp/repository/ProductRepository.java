package com.fatih.InventoryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatih.InventoryApp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
