package uz.com.brb.service;

import uz.com.brb.model.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<UserEntity> users = new ArrayList<>();
    private int idCounter = 1;

    public List<UserEntity> getAllUsers() {
        return users;
    }

    public UserEntity getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean createUser(UserEntity userEntity) {
        for (UserEntity user: users) {
            if (user.getUsername().equals(userEntity.getUsername())){
                return false;
            }
        }
        userEntity.setRole(userEntity.getRole().toUpperCase());
        userEntity.setId(idCounter++);
        users.add(userEntity);
        return true;
    }

    public UserEntity updateUser(int id, UserEntity userEntity) {
        Optional<UserEntity> optionalUser = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setRole(userEntity.getRole());
            return user;
        }

        return null;
    }

    public boolean deleteUser(int id) {
       return users.removeIf(user -> user.getId() == id);
    }

    public UserEntity getByUsername(String username){
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }
}
