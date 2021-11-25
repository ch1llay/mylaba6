package com.company;

import java.util.List;

public class FootballTeamRussianLeague {
   int teamAmount;
   List<FootballTeam> teams;
   String generalLang = "ru";
   FootballTeam theBestTeam;
   int amountPlayerNotFromRussia;
   int amountBadKick;
   int amountFine;

   boolean CompaerTo(FootballTeam t1, FootballTeam t2){
      return t1.CountK() > t2.CountK();
   }
   FootballTeam FindTheBestTeam(){
      theBestTeam = teams.get(0);
      for(int i = 0; i < teams.size();i++){
         FootballTeam team = teams.get(i);
         if(CompaerTo(team, theBestTeam)){
            theBestTeam = team;
      }
   }



}
