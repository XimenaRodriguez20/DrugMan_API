package com.game.drugman.Controller;

import com.game.drugman.exception.ResourceNotFoundException;
import com.game.drugman.model.User;
import com.game.drugman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("user")
    public List<User> listarUsuarios() throws ResourceNotFoundException {
        return userRepository.findAll();
    }

    @PostMapping("crear")
    public User guardarUser(@RequestParam String name, @RequestParam String email,  @RequestParam String password) throws ResourceNotFoundException{
        return userRepository.save(new User(email, name, password));
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
