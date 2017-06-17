package pl.project.REST;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import pl.project.MongoDB.MongoCRUD;
import pl.project.model.Movie;
import pl.project.model.SetResponse;
import pl.project.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.core.Application;

@Path("/app")
//@ApplicationPath("/rest/*")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MovieManagerREST implements MovieManagerInterface {
	
	
	MongoCRUD mongo;
	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();

	@Override
	@GET
	@Path("/movie")
	public SetResponse<Movie> getAllMovies() {
		mongo.createMoviesCollection();
		List<Movie> list = mongo.getAllMovies();
		SetResponse<Movie> movies = new SetResponse<Movie>(list);
		return movies;
	}

	@Override
	@POST
	@Path("/movie")
	public void saveMovie(Movie movie) {
		mongo.createMoviesCollection();
		mongo.saveMovie(movie);
	}

	@Override
	@GET
	@Path("/movie/{idm}")
	public Movie getMovie(@PathParam("idm") String idm) {
		mongo.createMoviesCollection();
		Movie movie = mongo.getMovie(idm);
		return movie;
	}

	@Override
	@PUT
	@Path("/movie/{idm}")
	public String updateMovie(@PathParam("idm") String idm, Movie movie) {
		mongo.createMoviesCollection();
		String response = mongo.updateMovie(idm, movie);
		return response;
	}

	@Override
	@DELETE
	@Path("/movie/{idm}")
	public String deleteMovie(String idm) {
		mongo.createMoviesCollection();
		String response = mongo.deleteMovie(idm);
		return response;
	}

	@Override
	@GET
	@Path("/user")
	public SetResponse<User> getAllUsers() {
		mongo.createUsersCollection();
		List<User> list = mongo.getAllUsers();
		SetResponse<User> users = new SetResponse<User>(list);
		return users;
	}

	@Override
	@POST
	@Path("/user")
	public void saveUser(User user) {
		mongo.createUsersCollection();
		mongo.saveUser(user);
		
	}

	@Override
	@GET
	@Path("/user/{idu}")
	public User getUser(@PathParam("idu") String idu) {
		mongo.createUsersCollection();
		User user = mongo.getUser(idu);
		return user;
	}

	@Override
	@PUT
	@Path("/user/{idu}")
	public String updateUser(@PathParam("idu") String idu, User user) {
		mongo.createUsersCollection();
		String response = mongo.updateUser(idu, user);
		return response;
	}

	@Override
	@DELETE
	@Path("/user/{idu}")
	public String deleteUser(@PathParam("idu") String idu) {
		mongo.createUsersCollection();
		String response = mongo.deleteUser(idu);
		return response;
	}

}
