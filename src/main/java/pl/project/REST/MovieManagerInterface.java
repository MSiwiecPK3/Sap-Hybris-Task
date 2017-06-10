package pl.project.REST;

import pl.project.model.Movie;
import pl.project.model.SetResponse;
import pl.project.model.User;

public interface MovieManagerInterface {
	public SetResponse<Movie> getAllMovies();

	public void saveMovie(Movie movie);

	public Movie getMovie(String id);

	public String updateMovie(String id, Movie movie);

	public String deleteMovie(String id);
	
	public SetResponse<User> getAllUsers();

	public void saveUser(User user);

	public User getUser(String id);

	public String updateUser(String id, User user);

	public String deleteUser(String id);

}