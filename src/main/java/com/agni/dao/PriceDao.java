package com.agni.dao;



import com.agni.nosql.MongoDAOImpl;
import com.agni.nosql.NoSQLDAOTemplate;


public class PriceDao implements NoSQLDAOTemplate{

	@Override
	public void saveObject(String id, Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObjectByID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findObjectByID(String id) {
		return MongoDAOImpl.getDocumentbyId("collection", id);
	}

	@Override
	public void updateObjectSet(Object object, String id) {
		// TODO Auto-generated method stub
		
	}

}
