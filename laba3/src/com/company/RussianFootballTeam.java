package com.company;

import java.util.*;

public class RussianFootballTeam extends FootballTeam{
    int amountPlayerNotFromRussia;
    int amountBadKick;
    int amountYellowCard;
    int amountRedCard;
    boolean isVictory = false;

    public RussianFootballTeam(String title, Map<Integer,Player> playersMainContain, Map<Integer, Player> playersReserveContain){
        this.title = title;
        this.playersMainContain = playersMainContain;
        this.playersReserveContain = playersReserveContain;
    }

    public boolean isVictory() {
        return isVictory;
    }
    int RandomInt(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
    public boolean PlayMatch(){
        isVictory = !(RandomInt(0, 3) < 2);
        return isVictory;
    }
    public void GetInformationAboutTeam(){
        System.out.println("Команда " + title);
        System.out.println("Игроки основного состава");
        System.out.println(playersMainContain);

        System.out.println("Игроки запасного состава");
        System.out.println(playersReserveContain);
    }




}
