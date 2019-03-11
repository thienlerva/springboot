package com.jpmc.service;

import com.jpmc.repository.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    PlayerDao playerDao;

    List<String> opponents;

    public GameService(PlayerDao playerDao, List<String> opponents) {
        this.playerDao = playerDao;
        this.opponents = opponents;
    }

//    String attack() {
//        return "Player attack with: " + playerDao.getWeapon();
//    }

    int numberOfEnemies() {
        return opponents.size();
    }
}
