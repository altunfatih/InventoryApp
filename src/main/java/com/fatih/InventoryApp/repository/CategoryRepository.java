package com.fatih.InventoryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatih.InventoryApp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
