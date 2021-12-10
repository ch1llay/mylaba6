package com.company;

import java.util.Map;

public class FootballTeam extends Team {
    String trainer;
    int victoryAmount;
    boolean isPlayMatch;
    Map<Integer, Player> playersMainContain;
    Map<Integer, Player> playersReserveContain;

    void FinishMatch() {
        isPlayMatch = false;
    }

    public void DoReplace(int oldN, int newN) {
        Player oldPlayer = playersMainContain.remove(oldN);
        Player newPlayer = playersReserveContain.remove(newN);
        playersMainContain.put(newN, newPlayer);
        playersReserveContain.put(oldN, oldPlayer);
    }
}
