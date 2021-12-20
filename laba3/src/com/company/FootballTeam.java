package com.company;

import java.util.Map;

public class FootballTeam extends Team {

    String city;
    int victoryAmount;
    boolean isPlayMatch;
    int placeInLeague;
    int priceClub;
    String hymn = "Славься отество наше сводное";


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
