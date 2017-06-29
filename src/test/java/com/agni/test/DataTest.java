package com.agni.test;


import org.junit.Test;

import com.agni.model.Product;
import com.agni.student.service.ProductService;


public class DataTest {
private ProductService studentService;

@Test
public void getProperties(){
	studentService= new ProductService();
	Product data =studentService.getProductDetails("112331");
	System.out.println(data);
}
}
