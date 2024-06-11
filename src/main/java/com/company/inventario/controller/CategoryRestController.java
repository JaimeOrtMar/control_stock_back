package com.company.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventario.response.CategoryResponseRest;
import com.company.inventario.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	@Autowired
	private ICategoryService service;
	
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchcategories(){
		ResponseEntity<CategoryResponseRest> response = service.search();
		return response;
	}
}
