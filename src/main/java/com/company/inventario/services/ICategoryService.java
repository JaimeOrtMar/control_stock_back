package com.company.inventario.services;
import com.company.inventario.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
	
	public ResponseEntity<CategoryResponseRest> search();
	
}
