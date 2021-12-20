package com.company;

import java.util.*;

public class RussianFootballTeam extends FootballTeam{
    String stadium;
    String president;
    int foundation;
    String capitan;
    boolean isVictory = false;

    @Override
    public String toString(){
        return  "\nНазвание      : " + title + "\n" +
                "Город         : " + city + "\n" +
                "Главный тренер: " + trainer + "\n" +
                "Капитан       : " + capitan + "\n" +
                "Бюджет        : " + budgetClub + " млн р.\n" +
                "Число побед   : " + victoryAmount + "\n" +
                "Место в лиге  : " + placeInLeague + "\n";
    }

    public RussianFootballTeam(String title, String city, String trainer, int placeInLeague, int budged, int victoryAmount, String capitan, String stadium, String president, int foundation){
        this.title = title;
        this.city = city;
        this.trainer = trainer;
        this.capitan = capitan;
        this.placeInLeague = placeInLeague;
        this.budgetClub = budged;
        this.victoryAmount = victoryAmount;
        this.stadium = stadium;
        this.president = president;
        this.foundation = foundation;
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
        if(isVictory) victoryAmount++;
        return isVictory;
    }
    public void drinkChampagne(){
        System.out.println("ггггг");
    }




}
