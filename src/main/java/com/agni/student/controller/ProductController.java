package com.agni.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agni.model.Product;
import com.agni.student.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Product> listProductDetails(@PathVariable String id) {
	    	Product product = 	productService.getProductDetails(id);
	        if(product == null){
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Product>(product, HttpStatus.OK);
	    }
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<String> saveProductDetails(Product product) {
		boolean status = productService.updateProduct(product);
		
	    if(!status)
	    	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    
	    
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }
	
}
