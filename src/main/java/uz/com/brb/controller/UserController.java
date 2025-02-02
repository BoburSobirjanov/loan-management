package uz.com.brb.controller;

import org.springframework.web.bind.annotation.*;
import uz.com.brb.model.UserEntity;
import uz.com.brb.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService = new UserService();

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public String createUser(@RequestBody UserEntity userEntity) {
        boolean user = userService.createUser(userEntity);
        return user ? "Saved!" : "Wrong during save!";
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? "UserEntity deleted successfully" : "UserEntity not found";
    }

    @GetMapping("/username")
    public UserEntity getByUsername(@RequestParam String username){
        return userService.getByUsername(username);
    }
}