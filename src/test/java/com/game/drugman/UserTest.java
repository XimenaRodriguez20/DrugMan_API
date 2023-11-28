package com.game.drugman;

import com.game.drugman.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void crearUser (){
        User usuario = new User();
        assertEquals(usuario.getClass(),User.class);

    }

}
