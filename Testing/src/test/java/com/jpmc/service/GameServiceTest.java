package com.jpmc.service;

import com.jpmc.repository.PlayerDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    PlayerDao playerDao;

    @Spy
    List<String> enemies = new ArrayList<>();

    @InjectMocks
    GameService gameService;

    @Test
    public void attackWithSword() throws Exception {
//        when(playerDao.getWeapon()).thenReturn("Sword");
//        log.info("Smalles number: {}", Integer.MIN_VALUE);
//
//        enemies.add("Dragon");
//        enemies.add("Orc");
//
//
//        assertThat(gameService.numberOfEnemies(), is(2));
//
//        assertThat(gameService.attack(), is("Player attack with: Sword"));
        //assertEquals("Player attack with: Sword", gameService.attack());

    }

}