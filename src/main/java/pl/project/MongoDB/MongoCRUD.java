package pl.project.MongoDB;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.project.model.User;
import pl.project.model.Movie;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.BasicDBObject;



public class MongoCRUD  {

	SpringMongoConfig config;
	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();
	MongoDatabase db;
	
	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("movies");
		Document sortById = new Document("_id", 1); 
		List<Document> documents = collection.find().sort(sortById).into(new ArrayList<Document>());
		for (Document document : documents) { 
			Movie movie = gson.fromJson(document.toJson(), Movie.class);
			movies.add(movie);
		}
		config.close();
		return movies;
	}

	public void saveMovie(Movie movie) {
		db = config.connect();
		String json = gson.toJson(movie);
		Document doc = Document.parse(json);
		db.getCollection("movies").insertOne(doc);	
		config.close();
	}

	public Movie getMovie(String id) {
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("movies");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", id);
		Document document = collection.find(whereQuery).first();
		Movie movie = gson.fromJson(document.toJson(), Movie.class);
		config.close();
		return movie;
	}

	public String updateMovie(Movie movie) {
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("movies");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", movie.getId());
		UpdateResult result = collection.updateOne(whereQuery, Document.parse(gson.toJson(movie)));
		config.close();
		if (result.wasAcknowledged())
			return "Update Succesful";
		else
			return "Update Unsuccesful";
	}

	public String deleteMovie(String id) {
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("movies");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", id);
		DeleteResult result = collection.deleteOne(whereQuery);
		config.close();
		if (result.wasAcknowledged())
			return "Delete Succesful";
		else
			return "Delete Unsuccesful";
	}

	public void createMoviesCollection() {
		db = config.connect();
		boolean result = true;
		MongoIterable<String> collectionNames = db.listCollectionNames();
		for (final String name : collectionNames) {  
		        if (name.equalsIgnoreCase("movies")) {
		            result = true;
		        }
		}
		if (!result){
			db.createCollection("movies");
		}
		config.close();
	}

	public void dropMoviesCollection() {
		db = config.connect();
		boolean result = true;
		MongoIterable<String> collectionNames = db.listCollectionNames();
		for (final String name : collectionNames) {  
		        if (name.equalsIgnoreCase("movies")) {
		            result = true;
		        }
		}
		if (result){
			db.getCollection("movies").drop();
		}
		config.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("users");
		Document sortById = new Document("_id", 1); 
		List<Document> documents = collection.find().sort(sortById).into(new ArrayList<Document>());
		for (Document document : documents) { 
			User user = gson.fromJson(document.toJson(), User.class);
			users.add(user);
		}
		config.close();
		return users;
	}

	public void saveUser(User user) {
		db = config.connect();
		String json = gson.toJson(user);
		Document doc = Document.parse(json);
		db.getCollection("users").insertOne(doc);	
		config.close();
	}

	public User getUser(String id) {
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("users");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", id);
		Document document = collection.find(whereQuery).first();
		User user = gson.fromJson(document.toJson(), User.class);
		config.close();
		return user;
	}

	public String updateUser(User user) {
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("users");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", user.getId());
		UpdateResult result = collection.updateOne(whereQuery, Document.parse(gson.toJson(user)));
		config.close();
		if (result.wasAcknowledged())
			return "Update Succesful";
		else
			return "Update Unsuccesful";
	}

	public String deleteUser(String id) {
		db = config.connect();
		MongoCollection<Document> collection = db.getCollection("user");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", id);
		DeleteResult result = collection.deleteOne(whereQuery);
		config.close();
		if (result.wasAcknowledged())
			return "Delete Succesful";
		else
			return "Delete Unsuccesful";
	}

	public void createUsersCollection() {
		db = config.connect();
		boolean result = true;
		MongoIterable<String> collectionNames = db.listCollectionNames();
		for (final String name : collectionNames) {  
		        if (name.equalsIgnoreCase("users")) {
		            result = true;
		        }
		}
		if (!result){
			db.createCollection("users");
		}
		config.close();
	}

	public void dropUsersCollection() {
		db = config.connect();
		boolean result = true;
		MongoIterable<String> collectionNames = db.listCollectionNames();
		for (final String name : collectionNames) {  
		        if (name.equalsIgnoreCase("users")) {
		            result = true;
		        }
		}
		if (result){
			db.getCollection("users").drop();
		}
		config.close();
	}
}
