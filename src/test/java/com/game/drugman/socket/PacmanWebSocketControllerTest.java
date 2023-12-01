package com.game.drugman.socket;

import com.game.drugman.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacmanWebSocketControllerTest {

    PacmanWebSocketController pacmanWebSocketControllerprueba = new PacmanWebSocketController();

    @Test
    void handleMove() {
        User usuario = new User("ximena@gmail.com",  "ximena", 5471);
        User validacion = pacmanWebSocketControllerprueba.handleMove(usuario);
        assertEquals(usuario,validacion);
    }


}