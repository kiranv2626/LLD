package Cricket.Match;
import Cricket.Dashboard.dashboard;
import Cricket.Enum.matchstatus;
import Cricket.Enum.matchresult;
import Cricket.Player.player;
import Cricket.Team.team;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class match {
    String matchName;
    team team1;
    team team2;
    int overs;
    matchstatus matchstatus;
    public match(String matchName,team team1,team team2,int overs){
        this.matchName=matchName;
        this.team1=team1;
        this.team2=team2;
        this.overs=overs;
        this.matchstatus=matchstatus.notstarted;
    }
    public void startSecondTeambatting(match match) {
        System.out.println("Lets start the first team batting");
        team team2=match.team2;
        List<player> players=team2.getPlayers();
        int nextBattingPlayer=0;
        team2.setOnStrike(players.get(nextBattingPlayer));
        team2.setOffStrike(players.get(nextBattingPlayer+1));
        team2.setAvilablePlayers(team2.getAvilablePlayers()-2);
        nextBattingPlayer=1;
        int noOfOvers=match.overs;
        while(noOfOvers>0 && nextBattingPlayer<players.size() && team2.getTotalRuns()<= team1.getTotalRuns()) {
            for(int i=0;i<6;i++){
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the the outcome of the ball");
                String outcome=sc.nextLine();
                if(outcome.equalsIgnoreCase("w"))
                {
                    team2.getOnStrike().setNoOfBalls(team2.getOnStrike().getNoOfBalls()+1);
                    nextBattingPlayer++;
                    if(nextBattingPlayer>=players.size())
                        break;
                    team2.setOnStrike(players.get(nextBattingPlayer));
                    team2.setAvilablePlayers(team2.getAvilablePlayers()-1);
                    team2.setTotalWicketsFallen(team2.getTotalWicketsFallen()+1);
                }
                else if (outcome.equalsIgnoreCase("wb") || outcome.equalsIgnoreCase("nb")) {
                    team2.setTotalRuns(team2.getTotalRuns()+1);
                    team2.setExtras(team2.getExtras()+1);
                    i=i-1;
                }
                else if(outcome.equalsIgnoreCase("4")){
                    team2.setTotalRuns(team2.getTotalRuns()+4);
                    team2.getOnStrike().setNoOfFours(team2.getOnStrike().getNoOfFours()+1);
                    team2.getOnStrike().setNoOfRuns(team2.getOnStrike().getNoOfRuns()+4);
                    team2.getOnStrike().setNoOfBalls(team2.getOnStrike().getNoOfBalls()+1);
                }
                else if(outcome.equalsIgnoreCase("6")){
                    team2.setTotalRuns(team2.getTotalRuns()+6);
                    team2.getOnStrike().setNoOfFours(team2.getOnStrike().getNoOfSixes()+1);
                    team2.getOnStrike().setNoOfRuns(team2.getOnStrike().getNoOfRuns()+6);
                    team2.getOnStrike().setNoOfBalls(team2.getOnStrike().getNoOfBalls()+1);
                }
                else if(Integer.parseInt(outcome)>=0 && Integer.parseInt(outcome)<=6){
                    int runs=Integer.parseInt(outcome);
                    team2.setTotalRuns(team2.getTotalRuns()+runs);
                    team2.getOnStrike().setNoOfRuns(team2.getOnStrike().getNoOfRuns()+runs);
                    team2.getOnStrike().setNoOfBalls(team2.getOnStrike().getNoOfBalls()+1);
                    if(runs%2!=0)
                    {
                        player temp=team2.getOnStrike();
                        team2.setOnStrike(team2.getOffStrike());
                        team2.setOffStrike(temp);
                    }
                }

            }
            dashboard.displayDashboard(team2);
            noOfOvers--;
            player temp=team2.getOnStrike();
            team2.setOnStrike(team2.getOffStrike());
            team2.setOffStrike(temp);
        }
    }
    public void startFirstTeambatting(match match) {
        System.out.println("Lets start the first team batting");
        team team1=match.team1;
        List<player> players=team1.getPlayers();
        int nextBattingPlayer=0;
        team1.setOnStrike(players.get(nextBattingPlayer));
        team1.setOffStrike(players.get(nextBattingPlayer+1));
        team1.setAvilablePlayers(team1.getAvilablePlayers()-2);
        nextBattingPlayer=1;
        int noOfOvers=match.overs;
        while(noOfOvers>0 && nextBattingPlayer<players.size()) {
            for(int i=0;i<6;i++){
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the the outcome of the ball");
                String outcome=sc.nextLine();
                if(outcome.equalsIgnoreCase("w"))
                {
                    team1.getOnStrike().setNoOfBalls(team1.getOnStrike().getNoOfBalls()+1);
                    nextBattingPlayer++;
                    if(nextBattingPlayer>=players.size())
                        break;
                    team1.setOnStrike(players.get(nextBattingPlayer));
                    team1.setAvilablePlayers(team1.getAvilablePlayers()-1);
                    team1.setTotalWicketsFallen(team1.getTotalWicketsFallen()+1);
                }
                else if (outcome.equalsIgnoreCase("wb") || outcome.equalsIgnoreCase("nb")) {
                    team1.setTotalRuns(team1.getTotalRuns()+1);
                    team1.setExtras(team1.getExtras()+1);
                    i=i-1;
                }
                else if(outcome.equalsIgnoreCase("4")){
                    team1.setTotalRuns(team1.getTotalRuns()+4);
                    team1.getOnStrike().setNoOfFours(team1.getOnStrike().getNoOfFours()+1);
                    team1.getOnStrike().setNoOfRuns(team1.getOnStrike().getNoOfRuns()+4);
                    team1.getOnStrike().setNoOfBalls(team1.getOnStrike().getNoOfBalls()+1);
                }
                else if(outcome.equalsIgnoreCase("6")){
                    team1.setTotalRuns(team1.getTotalRuns()+6);
                    team1.getOnStrike().setNoOfFours(team1.getOnStrike().getNoOfSixes()+1);
                    team1.getOnStrike().setNoOfRuns(team1.getOnStrike().getNoOfRuns()+6);
                    team1.getOnStrike().setNoOfBalls(team1.getOnStrike().getNoOfBalls()+1);
                }
                else if(Integer.parseInt(outcome)>=0 && Integer.parseInt(outcome)<=6){
                    int runs=Integer.parseInt(outcome);
                    team1.setTotalRuns(team1.getTotalRuns()+runs);
                    team1.getOnStrike().setNoOfRuns(team1.getOnStrike().getNoOfRuns()+runs);
                    team1.getOnStrike().setNoOfBalls(team1.getOnStrike().getNoOfBalls()+1);
                    if(runs%2!=0)
                    {
                        player temp=team1.getOnStrike();
                        team1.setOnStrike(team1.getOffStrike());
                        team1.setOffStrike(temp);
                    }
                }

            }
            dashboard.displayDashboard(match.team1);
            noOfOvers--;
            player temp=team1.getOnStrike();
            team1.setOnStrike(team1.getOffStrike());
            team1.setOffStrike(temp);
        }


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the match name");
        String matchName=sc.nextLine();
        System.out.println("Enter number of players");
        int noOfPlayers=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the team1 name");
        String team1Name=sc.nextLine();
        System.out.println("Enter the players");
        List<String> players1= new ArrayList<>();
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter the name of player of team1 "+(i+1));
            players1.add(sc.nextLine());
        }
        System.out.println("Enter the team2 name");
        String team2Name=sc.nextLine();
        List<String> players2= new ArrayList<>();
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter the name of player of team2 "+(i+1));
            players2.add(sc.next());
        }
        System.out.println("Enter the overs");
        int overs=sc.nextInt();
        team team1=new team(team1Name,players1);
        team team2=new team(team2Name,players2);
        match match=new match(matchName,team1,team2,overs);
        dashboard.displayDashboard(match.team1);
        System.out.println("Lets start the match");
        match.matchstatus= Cricket.Enum.matchstatus.inprogress;
        System.out.println("Match status is "+match.matchstatus);
        match.startFirstTeambatting(match);
        match.startSecondTeambatting(match);
        match.matchstatus= Cricket.Enum.matchstatus.completed;
        System.out.println("Match status is "+match.matchstatus);
        if(match.team1.getTotalRuns()>match.team2.getTotalRuns())
        {
            System.out.println(match.team1.getTeamName()+" won the match");
        }
        else if(match.team2.getTotalRuns()>match.team1.getTotalRuns())
        {
            System.out.println(match.team2.getTeamName()+" won the match");
        }
        else
        {
            System.out.println("Match Drawn");
        }

    }
}
