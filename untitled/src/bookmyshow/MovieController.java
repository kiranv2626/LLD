package bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieController {
    HashMap<City,List<Movie>> movies;
    List<Movie> moviesList;
    MovieController(){
        movies=new HashMap<>();
        moviesList=new ArrayList<>();
    }
    public void addMovie(City city,Movie movie){
        List<Movie> moviesL=movies.getOrDefault(city,new ArrayList<>());
        moviesL.add(movie);
        movies.put(city,moviesL);
        moviesList.add(movie);
    }
    public  List<Movie> getMovie(City city){
        System.out.println(movies.get(city));
        return movies.get(city);

    }

    public Movie getMovie(String name){
        for(Movie movie:moviesList){
            if(movie.getName().equalsIgnoreCase(name)){
                return movie;
            }
        }
        return null;
    }
}
