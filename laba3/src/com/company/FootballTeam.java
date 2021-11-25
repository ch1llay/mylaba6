package com.company;

import java.util.List;
import java.util.Map;

public class FootballTeam extends Team {
    String trainer;
    int countGol;
    int CountGolLoss;
    int countVictory;
    boolean isPlayMatch;
    Map<Integer, Player> players;
    Map<Integer, Player> reservePlayers;
    //количество голов забитых кол-во пропущенных суммарный фонд зарплаты трененр количество тренеров капитан командыд запасной капитан команды

    int CountK(){
        return countGol + countVictory - CountGolLoss;
    }
    void StartMatch() {
        isPlayMatch = true;
    }

    void FinishMatch() {
        isPlayMatch = false;
    }

    void DoReplace(int oldN, int newN) {
        Player oldPlayer = players.remove(oldN);
        Player newPlayer = reservePlayers.remove(newN);
        players.put(newN, newPlayer);
        reservePlayers.put(oldN, oldPlayer);
    }
}
