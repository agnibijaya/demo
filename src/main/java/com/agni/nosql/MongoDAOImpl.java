package com.agni.nosql;


import java.io.InputStream;
import java.util.Properties;

import org.bson.Document;
import org.springframework.core.io.DefaultResourceLoader;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoDAOImpl {

	private static MongoClient client;
	private static  MongoDatabase db;
	private static  Properties prop =new Properties();
	
	 static {
			InputStream input;
			try {
				final DefaultResourceLoader loader = new DefaultResourceLoader();    
				input = loader.getResource("/mongodb.properties").getInputStream();
				prop.load(input);
				input.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			client=new MongoClient( prop.getProperty("mongodb.host"), 27017 );
			db = client.getDatabase( prop.getProperty("mongodb.dbname"));
			
			}
	

	public static void insertDocument(Object jsonString, String collectionName) {
		MongoCollection coll = db.getCollection(collectionName);
		coll.insertOne(Document.parse((String) jsonString));
		
	}
	

	public static Object getDocumentbyId(String collectionName, String id) {
		Object jsonObject="{}";
		MongoCollection coll= db.getCollection(collectionName);
		FindIterable<Document> itr = coll.find(Filters.eq("_id", id));
		for (MongoCursor localMongoCursor = itr.iterator(); localMongoCursor.hasNext();) {
			Document document = (Document) localMongoCursor.next();
			jsonObject =document.toJson();
		}
		return jsonObject;
	}
	
	public static void deleteDocumentById(String collectionName, String id) {
		MongoCollection<Document> collection = db.getCollection(collectionName);
		DeleteResult reuslt = collection.deleteOne(Filters.eq("_id", id));
		
	}

	public static void updateDocument(String collectionName, Object jsonString, String id) {
		Gson gson = new Gson();
		UpdateOptions option = new UpdateOptions();
		option.upsert(true);
		UpdateResult result = db.getCollection(collectionName).replaceOne(Filters.eq("_id", id), Document.parse(gson.toJson(jsonString)), option);
	
	}
}
