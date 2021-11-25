package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FootballTeamRussianLeague {
    int teamAmount;
    ArrayList<FootballTeam> teams;
    String generalLang = "ru";
    FootballTeam teamWithTheMostVictoryAmount;
    int amountPlayerNotFromRussia;
    int amountBadKick;
    double averageAmountVictory;
    int amountFine;

    boolean CompareTo(FootballTeam t1, FootballTeam t2) {
        return t1.victoryAmount > t2.victoryAmount;
    }


    private void FindAverageAmountVictory() {
        double s = 0;
        for (int i = 0; i < teams.size(); i++) {
            s += teams.get(i).victoryAmount;
        }
        averageAmountVictory = s / teams.size();
    }

    public ArrayList<FootballTeam> FindTeamVictoryAmountMoreAverage() {
        ArrayList<FootballTeam> tempTeams = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            FootballTeam team = teams.get(i);
            FindAverageAmountVictory();
            if (team.victoryAmount > averageAmountVictory)
                tempTeams.add(team);
        }
        return tempTeams;
    }
    public void Sort(){
        teams.sort(new Comparator<FootballTeam>() {
            @Override
            public int compare(FootballTeam o1, FootballTeam o2) {
                return Integer.compare(o1.victoryAmount, o2.victoryAmount);
            }
        });
    }

    public FootballTeam FindTeamWithTheMostVictoryAmount() {
        teamWithTheMostVictoryAmount = teams.get(0);
        for (int i = 0; i < teams.size(); i++) {
            FootballTeam team = teams.get(i);
            if (CompareTo(team, teamWithTheMostVictoryAmount)) {
                teamWithTheMostVictoryAmount = team;
            }
        }
        return teamWithTheMostVictoryAmount;
    }


}
