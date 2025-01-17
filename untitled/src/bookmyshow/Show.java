package bookmyshow;

import java.util.List;

public class Show {
    int id;
    Movie movie;
    Screen screen;
    int startTime;
    List<Seat> bookedSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
   public void addBookedSeat(Seat seat) {
       this.bookedSeats.add(seat);
   }
    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
