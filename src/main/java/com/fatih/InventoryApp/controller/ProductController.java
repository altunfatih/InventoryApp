package com.fatih.InventoryApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatih.InventoryApp.entity.Category;
import com.fatih.InventoryApp.entity.Product;
import com.fatih.InventoryApp.repository.CategoryRepository;
import com.fatih.InventoryApp.repository.ProductRepository;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping("/products/new")
	@ApiOperation(value = "Show New Product")
	public String showNewProductForm(Model model) {
		List<Category> listCategories = categoryRepo.findAll();

		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", listCategories);

		return "product_form";
	}

	@PostMapping("/products/save")
	@ApiOperation(value = "Save Product")
	public String saveProduct(Product product, HttpServletRequest request) {
		String[] detailIDs = request.getParameterValues("detailID");
		String[] detailNames = request.getParameterValues("detailName");
		String[] detailValues = request.getParameterValues("detailValue");

		for (int i = 0; i < detailNames.length; i++) {
			if (detailIDs != null && detailIDs.length > 0)
				product.setDetails(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
			else
				product.addDetail(detailNames[i], detailValues[i]);
		}
		 
		productRepo.save(product);

		return "redirect:/products";
	}

	@GetMapping("/products")
	@ApiOperation(value = "List Product")
	public String listProducts(Model model) {
		List<Product> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);

		return "products";
	}

	@GetMapping("/products/edit/{id}")
	@ApiOperation(value = "Show Edit Product")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
		Product product = productRepo.findById(id).get();
		model.addAttribute("product", product);

		List<Category> listCategories = categoryRepo.findAll();

		model.addAttribute("listCategories", listCategories);

		return "product_form";
	}

	@GetMapping("/products/delete/{id}")
	@ApiOperation(value = "Delete Product")
	public String deleteProductForm(@PathVariable("id") Integer id, Model model) {
		productRepo.deleteById(id);

		return "redirect:/products";
	}
}
