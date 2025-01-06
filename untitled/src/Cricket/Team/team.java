package Cricket.Team;
import Cricket.Player.player;
import java.util.ArrayList;
import java.util.List;

public class team {
    String teamName;
    List<player> players = new ArrayList<>();
    int totalRuns=0;
    int totalWicketsFallen=0;
    int totalWicketsTaken=0;
    int avilablePlayers=0;
    player onStrike;
    player offStrike;
    int extras;

    public List<player> getPlayers(List<String> players) {
        List<player> playerList=new ArrayList<>();
        for(int i=0;i<players.size();i++)
        {
            player p1=new player(players.get(i));
            playerList.add(p1);
        }
        return playerList;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public team (String teamname, List<String> players)
    {
        this.teamName=teamname;
        this.totalRuns=0;
        this.totalWicketsFallen=0;
        this.totalWicketsTaken=0;
        this.avilablePlayers=players.size();
        this.players=getPlayers(players);
        this.onStrike=null;
        this.offStrike=null;
        this.extras=0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<player> getPlayers() {
        return players;
    }

    public void setPlayers(List<player> players) {
        this.players = players;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public void setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = totalWicketsTaken;
    }

    public int getTotalWicketsFallen() {
        return totalWicketsFallen;
    }

    public void setTotalWicketsFallen(int totalWicketsFallen) {
        this.totalWicketsFallen = totalWicketsFallen;
    }

    public int getAvilablePlayers() {
        return avilablePlayers;
    }

    public void setAvilablePlayers(int avilablePlayers) {
        this.avilablePlayers = avilablePlayers;
    }

    public player getOnStrike() {
        return onStrike;
    }

    public void setOnStrike(player onStrike) {
        this.onStrike = onStrike;
    }

    public player getOffStrike() {
        return offStrike;
    }

    public void setOffStrike(player offStrike) {
        this.offStrike = offStrike;
    }
}
