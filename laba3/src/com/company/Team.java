package com.company;

public class Team {
    int amountMembers;
    String title;
    boolean isTraining = false;
    String slogan;
    String trainer;





    // прокричать девиз
    void CrySlogan() {

        System.out.println(slogan);
    }

    //начать тренировку
    void StartTraining() {

        isTraining = true;
    }

    // расчитайсь
    boolean Count() {
        int i = 0;
        while (i < amountMembers) {
            i++;
        }
        return i == amountMembers;
    }
}
