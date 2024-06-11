/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.company.inventario.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventario.dao.ICategoryDao;
import com.company.inventario.model.category;
import com.company.inventario.response.CategoryResponseRest;


@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;


@Override
@Transactional(readOnly = true)
public ResponseEntity<CategoryResponseRest> search() {
    CategoryResponseRest response = new CategoryResponseRest();
    try {
        List<category> category = (List<category>) categoryDao.findAll();
        response.getCategoryResponse().setCategory(category);
        response.setMetadata("Respuesta ok","00", "Respuesta con éxito");
    } catch (Exception e) {
        response.setMetadata("Respuesta noOK","-1", "Respuesta erronea");
        e.getStackTrace();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
}


@Override
@Transactional(readOnly = true)
public ResponseEntity<CategoryResponseRest> searchbyid(Long id) {
	
	 CategoryResponseRest response = new CategoryResponseRest();
	 List<category> list = new ArrayList<>();
	    try {
	    
	    	Optional<category> category = categoryDao.findById(id);
	    	if(category.isPresent()) {
	    		list.add(category.get());
	    		response.getCategoryResponse().setCategory(list);
	    		response.setMetadata("Respuesta OK","00", "Respuesta correcta");
	    	}else {
	    		response.setMetadata("Respuesta noOK","-1", "Respuesta erronea por Id");
		        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    } catch (Exception e) {
	        response.setMetadata("Respuesta noOK","-1", "Respuesta erronea por Id");
	        e.getStackTrace();
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    return new ResponseEntity<>(response, HttpStatus.OK);
}
}
