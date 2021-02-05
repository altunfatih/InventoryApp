package com.fatih.InventoryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatih.InventoryApp.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
