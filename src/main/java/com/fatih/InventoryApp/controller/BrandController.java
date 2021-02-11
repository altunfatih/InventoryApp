package com.fatih.InventoryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatih.InventoryApp.entity.Brand;
import com.fatih.InventoryApp.entity.Category;
import com.fatih.InventoryApp.repository.BrandRepository;
import com.fatih.InventoryApp.repository.CategoryRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/brands/new")
	@ApiOperation(value = "Show Create New Brand")
	public String showCreateNewBrandForm(Model model) {
		List<Category> listCategories = categoryRepository.findAll();

		model.addAttribute("listCategories", listCategories);
		model.addAttribute("brand", new Brand());

		return "brand_form";
	}

	@PostMapping("brands/save")
	@ApiOperation(value = "Save Brand")
	public String saveBrand(Brand brand) {
		brandRepository.save(brand);

		return "redirect:/brands";
	}

	@GetMapping("/brands")
	@ApiOperation(value = "List Brand")
	public String listBrands(Model model) {
		List<Brand> listBrands = brandRepository.findAll();
		model.addAttribute("listBrands", listBrands);

		return "brands";
	}

	@GetMapping("/brands/edit/{id}")
	@ApiOperation(value = "Show Edit Brand")
	public String showEditBrandForm(@PathVariable("id") Integer id, Model model) {
		List<Category> listCategories = categoryRepository.findAll();
		Brand brand = brandRepository.findById(id).get();

		model.addAttribute("listCategories", listCategories);
		model.addAttribute("brand", brand);

		return "brand_form";
	}
}
