package uz.com.brb.service;

import org.springframework.stereotype.Service;
import uz.com.brb.model.entity.UserEntity;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity getUserById(int id);

    void saveUser(UserEntity user);

    void deleteUser(int id);
}
