package com.company.inventario.dao;
import com.company.inventario.model.category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<category, Long> {

}
