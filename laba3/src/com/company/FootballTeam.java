package com.company;

import java.util.Map;

public class FootballTeam extends Team {

    String city;
    int victoryAmount;
    boolean isPlayMatch;
    int placeInLeague;
    int budgetClub;
    String hymn = "Славься отечество наше свободное";


    void songHymn(){
        System.out.println(hymn);
    }
    void startMatch(){
        isPlayMatch = true;
    }
    void finishMatch() {
        isPlayMatch = false;
    }

}
