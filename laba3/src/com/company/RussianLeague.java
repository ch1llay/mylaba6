package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class RussianLeague {
    int teamAmount;
    ArrayList<RussianFootballTeam> teams = new ArrayList<>();
    RussianFootballTeam teamWithTheMostVictoryAmount;
    double averageAmountVictory;




    public RussianLeague(int teamAmount){
        this.teamAmount = teamAmount;
    }
    public void AddTeamToLeague(RussianFootballTeam team){
        teams.add(team);
    }

    public void DeleteTeamFromLeague(RussianFootballTeam team){
        teams.remove(team);
    }
    // найти среднее число побед в лиге
    private void FindAverageAmountVictory() {
        double s = 0;
        for (int i = 0; i < teams.size(); i++) {
            s += teams.get(i).victoryAmount;
        }
        averageAmountVictory = s / teams.size();
    }

    // найти команду с количеством побед выше среднего
    public ArrayList<RussianFootballTeam> FindTeamVictoryAmountMoreAverage() {
        ArrayList<RussianFootballTeam> tempTeams = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            RussianFootballTeam team = teams.get(i);
            FindAverageAmountVictory();
            if (team.victoryAmount > averageAmountVictory)
                tempTeams.add(team);
        }
        return tempTeams;
    }
    // сортирует команды по убыванию мест в лиге
    public void Sort(){
        teams.sort(new Comparator<FootballTeam>() {
            @Override
            public int compare(FootballTeam o1, FootballTeam o2) {
                return Integer.compare(o2.placeInLeague, o1.placeInLeague);
            }
        });
    }

    // найти команду с наибольшим количеством побед
    public RussianFootballTeam FindTeamWithTheMostVictoryAmount() {
        teamWithTheMostVictoryAmount = teams.get(0);
        for (int i = 0; i < teams.size(); i++) {
            RussianFootballTeam team = teams.get(i);
            if (team.victoryAmount > teamWithTheMostVictoryAmount.victoryAmount) {
                teamWithTheMostVictoryAmount = team;
            }
        }
        return teamWithTheMostVictoryAmount;
    }
    // найти команду по месту в лиге
    public RussianFootballTeam FindTeamByPlace(int place){
        RussianFootballTeam team = null;
        for (int i = 0; i < teams.size(); i++) {
            team = teams.get(i);
            if(team.placeInLeague == place)
                break;
        }
        return team;
    }
    // найти команду по названию
    public RussianFootballTeam FindTeam(String titleTeam){
        RussianFootballTeam team = null;
        for (int i = 0; i < teams.size(); i++) {
            var tempTeam  = teams.get(i);
            if(tempTeam.title.equals(titleTeam)){
                team = tempTeam;
                break;

            }
        }
        return team;
    }
    // замена игрока в команде, вывод информации о команде
    public boolean changeBudgetTeam(String titleTeam, int budget){
        RussianFootballTeam team = FindTeam(titleTeam);
        if(team != null) {
            team.budgetClub = budget;
            return true;
        }
        return false;

    }
}
