package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.model.Product;
import com.abhi.productService.ProductService;

@RestController
@RequestMapping(value = "product-service")
public class Controller {
	@Autowired private ProductService productService;
	
	// localhost:8080/product-service/add
	
	@PostMapping(value = "add" , produces = {"application/json"}, consumes = {"application/json"})
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		   productService.saveProduct(product);
		   ResponseEntity<Product> response=ResponseEntity.status(HttpStatus.CREATED).body(product);
		   return response;
	   }
	@GetMapping(value = "list")
	public ResponseEntity<List<Product>> getProductList(){
		List<Product> plist=productService.getList();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping(value = "getById/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable int pid){
		Product product=productService.getProductById(pid);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	// localhost:8080/product-service/getById?pid=101
	@GetMapping(value = "getById")
	public ResponseEntity<Product> getProductById1(@RequestParam int pid){
		Product product=productService.getProductById(pid);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	@GetMapping(value = "list/byname")
	public ResponseEntity<List<Product>> ProductListbyName(@RequestParam String name){
		List<Product> pList=productService.getListByName(name);
		if(pList==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pList);
	}
	//localhost:8080/product-service/list/price-range?price1=200&price2=90000
	@GetMapping(value = "list/price-range")
	public ResponseEntity<List<Product>> ProductListbyPriceRange(@RequestParam int price1,@RequestParam int price2){
		List<Product> pList=productService.getListByPriceRange(price1, price2);
		if(pList==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pList);
	}
	@DeleteMapping(value = "deleteById/{pid}")
	public ResponseEntity<Product> deletebyid(@PathVariable int pid){
		Product product=productService.getProductById(pid);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		productService.deleteProduct(pid);
		return ResponseEntity.ok(product);
	}
	
	
	@PutMapping(value = "updateByid/{pid}")
	public ResponseEntity<Product> updatebyid(@PathVariable int pid,@RequestBody Product product){
		Product producto=productService.getProductById(pid);
		if(producto==null) {
			productService.saveProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		}
		product.setPid(pid);
		productService.updateProduct(product);
		return ResponseEntity.ok(product);
	}
	@PatchMapping(value = "partupdateByid/{pid}")
	public ResponseEntity<Product> partupdatebyid(@PathVariable int pid,@RequestBody Product product){
		Product producto=productService.getProductById(pid);
		if(producto==null) {
			
			return ResponseEntity.notFound().build();
		}
		product.setPid(pid);
		productService.partupdateProductById(product,producto);
		return ResponseEntity.ok(producto);
	}
}
