package com.abhi.productService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.Repository.ProductRepository;
import com.abhi.model.Product;

@RestController
@RequestMapping(value = "product-service")
public class ProductServiceImpl  implements ProductService{
   @Autowired	private ProductRepository productRepository;

	public void saveProduct(Product product) {
	productRepository.save(product);
	
   }
   public List<Product> getList() {
	
	return productRepository.findAll();
   }
   public Product getProductById(int pid) {
	
	return productRepository.findById(pid).orElse(null);
   }
   public List<Product> getListByName(String name) {
	
	return productRepository.findByName(name);
   }
   public List<Product> getListByPriceRange(int price1, int price2) {
	
	return productRepository.findByPriceBetween(price1, price2);
   }
   public void deleteProduct(int pid) {
	
	productRepository.deleteById(pid);
   }
   public void updateProduct(Product product) {
	productRepository.save(product);
	
   }
   @Override
   public void partupdateProductById(Product productn, Product producto) {
	
	String name =productn.getName();
	if(name!=null) {
		producto.setName(name);
	}
	String brand=productn.getBrand();
	if(brand!=null) {
		producto.setBrand(brand);
	}
	int price =productn.getPrice();
	if(price!=0) {
		producto.setPrice(price);
	}
	
	productRepository.save(producto);
   }
   
   
    
   
}
