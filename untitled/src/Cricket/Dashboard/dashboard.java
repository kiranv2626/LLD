package Cricket.Dashboard;
import Cricket.Team.team;

public class dashboard {

    public static void displayDashboard(team team){
        System.out.println("Team Name : "+team.getTeamName());
        System.out.println("player"+ "    |    "+ "Runs"+ "          |    "+ "Fours"+ "         |    "+ "Sixes"+ "         |    "+ "Balls Faced");
        for(int i=0;i<team.getPlayers().size();i++)
        {
            System.out.println(team.getPlayers().get(i).getName()+"         |        "+team.getPlayers().get(i).getNoOfRuns()+"         |        "+team.getPlayers().get(i).getNoOfFours()+"         |        "+team.getPlayers().get(i).getNoOfSixes()+"         |        "+team.getPlayers().get(i).getNoOfBalls());
        }
        System.out.println("Total Runs : "+team.getTotalRuns());
        System.out.println("Total Wickets Fallen: "+team.getTotalWicketsFallen());
    }
}
