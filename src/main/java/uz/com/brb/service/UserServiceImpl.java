package uz.com.brb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.com.brb.exception.DataHasAlreadyExistsException;
import uz.com.brb.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final ArrayList<UserEntity> userList = new ArrayList<>();
    private Integer idCounter = 1;

    public List<UserEntity> getAllUsers() {
        return userList;
    }

    public UserEntity getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void saveUser(UserEntity user) {
        for(UserEntity userEntity : userList){
            if(userEntity.getUsername().equals(user.getUsername())){
                throw new DataHasAlreadyExistsException("Added user same this username before!");
            }
        }
        if (user.getId() == 0) {
            user.setId(idCounter++);
            userList.add(user);
        } else {
            UserEntity existingUser = getUserById(user.getId());
            if (existingUser != null) {
                existingUser.setFullName(user.getFullName());
                existingUser.setUsername(user.getUsername());
                existingUser.setPassword(user.getPassword());
            }
        }
    }

    public void deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
