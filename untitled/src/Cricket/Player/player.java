package Cricket.Player;

public class player {
    String name;
    int noOfRuns;
    int noOfWickets;
    int NoOfFours;
    int NoOfSixes;
    int NoOfBalls;
    public player(String name) {
        this.name = name;
        this.noOfRuns = 0;
        this.noOfWickets = 0;
        this.NoOfFours = 0;
        this.NoOfSixes = 0;
        this.NoOfBalls = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfRuns() {
        return noOfRuns;
    }

    public void setNoOfRuns(int noOfRuns) {
        this.noOfRuns = noOfRuns;
    }

    public int getNoOfWickets() {
        return noOfWickets;
    }

    public void setNoOfWickets(int noOfWickets) {
        this.noOfWickets = noOfWickets;
    }

    public int getNoOfFours() {
        return NoOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        NoOfFours = noOfFours;
    }

    public int getNoOfSixes() {
        return NoOfSixes;
    }

    public void setNoOfSixes(int noOfSixes) {
        NoOfSixes = noOfSixes;
    }

    public int getNoOfBalls() {
        return NoOfBalls;
    }

    public void setNoOfBalls(int noOfBalls) {
        NoOfBalls = noOfBalls;
    }
}
