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
import pl.project.model.User;

@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MovieManagerREST implements MovieManagerInterface{
	
	MongoCRUD mongo;

	@Override
	@GET
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@POST
	public void saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@GET
	public Movie getMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PUT
	public String updateMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DELETE
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@POST
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@GET
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PUT
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DELETE
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
