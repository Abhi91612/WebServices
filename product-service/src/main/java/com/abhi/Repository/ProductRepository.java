package com.abhi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByPriceBetween(int price1, int price2);



}
