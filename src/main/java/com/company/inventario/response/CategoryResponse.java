package com.company.inventario.response;

import java.util.List;
import com.company.inventario.model.category;

import lombok.Data;

@Data
public class CategoryResponse {
	private List<category> category;

}
