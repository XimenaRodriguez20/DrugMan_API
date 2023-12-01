package com.game.drugman;

import com.game.drugman.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTest {

    public User nuevoUsuarioVacio ;
    public User nuevoUsuario ;

    public Object prueba;

    @BeforeEach
    public void setUp() {
        nuevoUsuarioVacio = new User();
        nuevoUsuario = new User("jordy@gmail.com",  "Jordy", 123456);
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
        int points = 123456;
        assertEquals(nuevoUsuario.getPoints(), points);
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
        int password = 654321;
        nuevoUsuario.setPoints(password);
        assertEquals(nuevoUsuario.getPoints(), password);
    }

    @Test
    public void  hash(){
        int llave = nuevoUsuario.hashCode();
        assertNotEquals(llave,0);
    }

    @Test
    public void  ToString(){
        String datos = nuevoUsuario.toString();
        assertNotEquals(datos,"Jordy");
    }

    @Test
    public void trueEquals(){
        boolean verificacion = nuevoUsuario.equals(nuevoUsuario);
        assertEquals(verificacion,true);
    }
    @Test
    public void falseEquals(){
        String palabra = "hola";
        boolean diferenteClase = nuevoUsuario.equals(palabra);
        assertEquals(diferenteClase,false);
    }

    @Test
    public void falseNullEquals(){
        boolean valorNulo = nuevoUsuario.equals(null);
        assertEquals(valorNulo,false);
    }

    @Test
    public void Equals(){
        User pruebaUsuario = new User("jordy@gmail.com",  "Jordy", 123456);
        boolean igualDatos = nuevoUsuario.equals(pruebaUsuario);
        assertEquals(igualDatos,true);
    }

    @Test
    public void diferenteEquals(){
        User pruebaUsuario = new User("juan@gmail.com",  "Juan", 987564);
        boolean datosDiferentes = nuevoUsuario.equals(pruebaUsuario);
        assertEquals(datosDiferentes,false);
    }

}
