package bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    HashMap<City,List<Theatre>> theatresMap;
    List<Theatre> theatres ;
    TheatreController(){
        theatresMap=new HashMap<>();
        theatres=new ArrayList<>();
    }
    public void addTheatre(City city,Theatre theatre){
        List<Theatre> theatresL=theatresMap.get(city);
        theatresL.add(theatre);
        theatresMap.put(city,theatresL);
        theatres.add(theatre);
    }
    public List<Theatre> getTheatre(City city){
        System.out.println(theatresMap.get(city));
        return theatresMap.get(city);
    }
    public HashMap<Theatre,List<Show>> getAllShows(City city, Movie movie)
    {
         HashMap<Theatre,List<Show>> showsMap=new HashMap<>();
        List<Theatre> theatresL=theatresMap.get(city);
        for(Theatre theatre:theatresL)
        {
            List<Show> shows=theatre.getShows();
            List<Show> movieShows=new ArrayList<>();
            for(Show show:shows)
            {
                if(show.getMovie().getName().equals(movie.getName()))
                {
                    movieShows.add(show);
                }
            }
            if(movieShows.size()>0)
            showsMap.put(theatre,movieShows);
        }
        return showsMap;
    }
}
