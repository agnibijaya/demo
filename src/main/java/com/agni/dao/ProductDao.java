package com.agni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.agni.api.APITemplate;
import com.agni.model.Price;

public class ProductDao implements APITemplate{
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Object findObjectByID(String id) {
		String price;
		try {
			price = restTemplate.getForObject("http://api.target.com/api/random/"+id, String.class);
			return price;
		} catch (RestClientException e) {
			// handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object updateObject(String id, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
