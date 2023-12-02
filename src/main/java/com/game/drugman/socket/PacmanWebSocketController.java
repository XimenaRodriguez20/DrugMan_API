package com.game.drugman.socket;

import com.game.drugman.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class PacmanWebSocketController {

    HashMap<String, User> ranquinList = new HashMap<String, User>();

    public HashMap<String, User> getRanquinList() {
        return ranquinList;
    }

    @MessageMapping("/move")
    @SendTo("/tema/pacman")
    public User handleMove(User player) {
        ranquinList.put(player.getEmail(), player);
        System.out.println("LISTA " + ranquinList.toString());
        System.out.println("Elemento Enviado: " + player.getName() + ", " + player.getPoints() + ", " + player.toString()) ;
        return player;
    }

    @MessageMapping("/chat")
    @SendTo("/tema/chat")
    public String handleHistoria(String message) {
        return message;
    }
}