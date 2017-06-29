package com.agni.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agni.dao.PriceDao;
import com.agni.dao.ProductDao;
import com.agni.model.Price;
import com.agni.model.Product;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



@Service("productService")
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private PriceDao priceDao;
	
	public Product getProductDetails(String id){
		Gson gson = new Gson();
		Product product = null;
		Price price = gson.fromJson(priceDao.findObjectByID(id).toString(),Price.class);
		String name = (String) productDao.findObjectByID(id);
		
		if(name!= null && price != null){
			product = new Product(id, name);
			product.setCurrent_price(price);
			return product;
		}
		
		return null;
	}
	public boolean updateProduct(Product product){
		String id= product.getId();
    	String name = product.getName();
    	Price price = product.getCurrent_price();
    	priceDao.saveObject(id, price);
    	return true;
	}
}

