package com.company;

import java.util.*;

public class RussianFootballTeam extends FootballTeam{
    int amountGoodKick;
    int amountBadKick;
    int amountYellowCard;
    int amountRedCard;

    boolean isVictory = false;
    public toString(){
        return "" + title;
    }

    public RussianFootballTeam(String title, String city, String trainer, int placeInLeague, int price, int victoryAmount){
        this.title = title;
        this.city = city;
        this.trainer = trainer;
        this.placeInLeague = placeInLeague;
        this.priceClub = price;
        this.victoryAmount = victoryAmount;
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
        amountBadKick += RandomInt(10, 20);
        amountGoodKick += RandomInt(5, 15);
        amountRedCard += RandomInt(1, 3);
        amountYellowCard += RandomInt(1, 4);
        return isVictory;
    }
    public void GetInformationAboutTeam(){
        System.out.println("Команда " + title);
        System.out.println("");
        System.out.println("Место в лиге " + placeInLeague);

    }




}
