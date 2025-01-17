package bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Bookmyshow {
    TheatreController theatreController;
    MovieController movieController;
    BookingController bookingController;
    public Bookmyshow() {
        theatreController=new TheatreController();
        movieController=new MovieController();
        bookingController=new BookingController();
    }
    public static void main(String[] args) {
        Bookmyshow bookmyshow=new Bookmyshow();
        List<Movie> movies=new ArrayList<>();
        Movie m1=new Movie();
        m1.setId(1);
        m1.setName("RRR");
        m1.setDuration(180);
        movies.add(m1);
        Movie m2=new Movie();
        m2.setId(2);
        m2.setName("Baahubali");
        m2.setDuration(200);
        movies.add(m2);
        for(Movie m:movies)
        {
            bookmyshow.movieController.addMovie(City.HYDERABAD,m);
            bookmyshow.movieController.addMovie(City.CHENNAI,m);
        }
        List<Show> shows=new ArrayList<>();
        Show s=new Show();
        s.setId(1);
        s.setStartTime(100);
        s.setMovie(m1);
        Show s1=new Show();
        s1.setId(2);
        s1.setStartTime(200);
        s1.setMovie(m2);
        shows.add(s);
        shows.add(s1);
        List<Show> shows1=new ArrayList<>();
        Show s12=new Show();
        s12.setId(3);
        s12.setStartTime(300);
        s12.setMovie(m1);
        Show s13=new Show();
        s13.setId(4);
        s13.setStartTime(400);
        s13.setMovie(m2);
        shows1.add(s12);
        shows1.add(s13);
        List<Screen> screens1=new ArrayList<>();
        Screen s11=new Screen();
        s11.setScreenId(1);
        s11.setShows(shows);
        Screen s2=new Screen();
        s2.setScreenId(2);
        s2.setShows(shows1);
        screens1.add(s11);
        screens1.add(s2);
        Theatre t1=new Theatre();
        t1.setTheatreId(1);
        t1.setCity(City.HYDERABAD);
        t1.setAddress("Hyderabad");
        t1.setScreens(screens1);
        t1.setShows(shows);
        Theatre t2=new Theatre();
        t2.setTheatreId(2);
        t2.setCity(City.CHENNAI);
        t2.setAddress("Chennai");
        t2.setScreens(screens1);
        t2.setShows(shows1);

        List<Seat> seats=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Seat seat=new SilverSeat();
            seat.setId(i);
            seat.setBooked(false);
            seats.add(seat);
        }

        List<Seat> seats1=new ArrayList<>();
        for(int i=10;i<20;i++)
        {
            Seat seat=new GoldSeat();
            seat.setId(i);
            seat.setBooked(false);
        }
        List<Seat> seats2=new ArrayList<>();
        for(int i=20;i<30;i++)
        {
            Seat seat=new PlatinumSeat();
            seat.setId(i);
            seat.setBooked(false);
        }

        Booking booking=new Booking(UUID.randomUUID().hashCode(),seats,new Payment(PaymentStatus.Pending),s);
        bookmyshow.bookingController.book(booking);

    }
}
