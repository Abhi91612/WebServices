package com.abhi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RequestMapping("product")
public class productController {

	@GetMapping
	private Product getProduct() {
		Product product=new Product();
		product.setPid(101);
		product.setName("Mouse");
		product.setBrand("Logitech");
		product.setPrice(1200);
		return product;
	}
}
