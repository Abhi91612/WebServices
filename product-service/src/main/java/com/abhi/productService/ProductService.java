package com.abhi.productService;

import java.util.List;

import com.abhi.model.Product;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getList();



	Product getProductById(int pid);

	List<Product> getListByName(String name);

	List<Product> getListByPriceRange(int price1, int price2);

	void deleteProduct(int pid);

	void updateProduct(Product product);

	

	void partupdateProductById(Product product, Product producto);

}
