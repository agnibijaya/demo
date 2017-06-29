package com.agni.nosql;

public interface NoSQLDAOTemplate {
	public void saveObject(String id,Object object);

	public Object findAllObjects();

	public void deleteObjectByID(String id);

	public Object findObjectByID(String id);

	public void updateObjectSet(Object object, String id);
}
