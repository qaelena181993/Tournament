package ru.netology.tournament;

import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    protected Collection<Player> players = new ArrayList<>();

    public Collection<Player> findAll() {
        return players;
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public boolean register(Player player) {
        return players.contains(player);
    }

    public int round(String playerName1, String playerName2) {
        int result = 0;
        int player1 = -1;
        int player2 = -1;
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName1)) {
                player1 = player.getStrength();
            }
            if (player.getName().equalsIgnoreCase(playerName2)) {
                player2 = player.getStrength();
            }
        }
        if (player1 == -1 || player2 == -1) {
            throw new NotRegisteredException("Пользователь не зарегестрирован");
        }
        if (player1 > player2) {
            result = 1;
        }
        if (player1 == player2) {
            result = 0;
        }
        if (player1 < player2) {
            result = 2;
        }
        return result;
    }
}
