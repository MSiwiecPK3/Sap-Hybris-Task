package pl.project.REST;

import java.util.List;
import pl.project.model.Movie;
import pl.project.model.User;

public interface MovieManagerInterface {
	public List<Movie> getAllMovies();

	public void saveMovie(Movie movie);

	public Movie getMovie(String id);

	public String updateMovie(String id, Movie movie);

	public String deleteMovie(String id);
	
	public List<User> getAllUsers();

	public void saveUser(User user);

	public User getUser(String id);

	public String updateUser(User user);

	public String deleteUser(String id);

}