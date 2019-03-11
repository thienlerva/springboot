package com.jpmc.service;

import com.jpmc.repository.PlayerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceMockBeanTest {

    @MockBean
    PlayerDao playerDao;

    @Autowired
    GameService gameService;

    @Test
    public void testPlayerAttack() {
//        when(playerDao.getWeapon()).thenReturn("Sword");
//        assertThat(gameService.attack(), is("Player attack with: Sword"));
    }
}