package com.game.drugman;

import com.game.drugman.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    public User nuevoUsuarioVacio ;
    public User nuevoUsuario ;

    @BeforeEach
    public void setUp() {
        nuevoUsuarioVacio = new User();
        nuevoUsuario = new User("jordy@gmail.com",  "Jordy", "123456");
    }

    @Test
    public void crearUser (){
        assertEquals(nuevoUsuarioVacio.getClass(),User.class);
    }


    @Test
    public void getEmailUsuarioContenido (){
        String email = "jordy@gmail.com";
        assertEquals(nuevoUsuario.getEmail(), email);
    }

    @Test
    public void getNameUsuarioContenido (){
        String name = "Jordy";
        assertEquals(nuevoUsuario.getName(), name);
    }

    @Test
    public void getPasswordUsuarioContenido (){
        String password = "123456";
        assertEquals(nuevoUsuario.getPassword(), password);
    }

    @Test
    public void setEmailUsuarioContenido (){
        String email = "santiago@gmail.com";
        nuevoUsuario.setEmail(email);
        assertEquals(nuevoUsuario.getEmail(), email);
    }

    @Test
    public void setNameUsuarioContenido (){
        String name = "Santiago";
        nuevoUsuario.setName(name);
        assertEquals(nuevoUsuario.getName(), name);
    }

    @Test
    public void setPasswordUsuarioContenido (){
        String password = "654321";
        nuevoUsuario.setPassword(password);
        assertEquals(nuevoUsuario.getPassword(), password);
    }

}
