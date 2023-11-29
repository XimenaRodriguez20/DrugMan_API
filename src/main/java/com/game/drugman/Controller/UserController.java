package com.game.drugman.Controller;

import com.game.drugman.exception.ResourceNotFoundException;
import com.game.drugman.model.User;
import com.game.drugman.repository.UserRepository;
import com.game.drugman.socket.PacmanWebSocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    PacmanWebSocketController userController;
    private final SimpMessagingTemplate messagingTemplate;

    public UserController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Autowired
    private UserRepository userRepository;
    @GetMapping("user")
    public List<User> listarUsuarios() throws ResourceNotFoundException {
        return userRepository.findAll();
    }

    @PostMapping("user")
    public void listarUsuarios(@RequestBody String datos)  {
        User jugador = new User(datos.split("/")[0], datos.split("/")[1], (int) Double.parseDouble(datos.split("/")[2]));
        System.out.println(jugador.getEmail() + ", " + jugador.getName() + "," + jugador.getPoints());
        userController.handleMove(jugador);
        messagingTemplate.convertAndSend("/tema/pacman", jugador);
    }

    @PostMapping("/crear")
    public User guardarUser(@RequestBody User user) throws ResourceNotFoundException{
        return userRepository.save(user);
    }

    String name ;
    @RequestMapping("/submit")
    public String submit(@RequestBody String user) {
        this.name = name;
        // Procesa la entrada
        return "/success";
    }

    @RequestMapping("/success")
    public String success() {
        // Muestra un mensaje de éxito
        return "El nombre es: " + name;
    }
}
