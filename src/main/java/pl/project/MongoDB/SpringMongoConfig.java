package pl.project.MongoDB;


import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


@Configuration
public class SpringMongoConfig{
	
	MongoClient mongoClient;
	
	public MongoDatabase connect(){
	try{
		MongoClientURI uri = new MongoClientURI("mongodb://Siwiec:password@ds125481.mlab.com:25481/heroku_kb6f38pg");
		mongoClient = new MongoClient(uri);

        MongoDatabase db = mongoClient.getDatabase("heroku_kb6f38pg");
        System.out.println(db.getName());
        return db;       
	}catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        return null;
     }
	
	}
	public void close(){
	    mongoClient.close();
	}
}