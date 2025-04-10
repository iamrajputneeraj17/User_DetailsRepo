package com.example.Users_Details.Services;


import com.example.Users_Details.Entities.User_Entity;
import com.example.Users_Details.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class User_Service {
    @Autowired
    private UserRepository userRepository;

    public User_Entity newUser(User_Entity user)
    {
        return this.userRepository.save(user);
    }

    public User_Entity findingById(Long id)
    {
        User_Entity foundUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("No User Found!"));
        return foundUser;

//        Optional<User_Entity> foundUser = userRepository.findById(id);
//        if(foundUser.isPresent()){return foundUser};
//        return null;

    }

    public List<User_Entity> getAllUsers()
    {
        List<User_Entity> allUsers = userRepository.findAll().stream().collect(Collectors.toList());
        return allUsers;
    }

    public void deleteUserbyId(Long id)
    {
        Optional<User_Entity> founduser = userRepository.findById(id);
        this.userRepository.deleteById(id);
    }

    public User_Entity updateUser(User_Entity user_entity) {
        User_Entity searchedEmp = userRepository.findById(user_entity.getId())
                .orElseThrow(() -> new RuntimeException("No User Found!"));

        if (user_entity.getName() != null) {
            searchedEmp.setName(user_entity.getName());
        }
        if (user_entity.getEmail() != null) {
            searchedEmp.setEmail(user_entity.getEmail());
        }
        if (user_entity.getCountry() != null) {
            searchedEmp.setCountry(user_entity.getCountry());
        }
        if (user_entity.getAddress() != null) {
            searchedEmp.setAddress(user_entity.getAddress());
        }
        if (user_entity.getGender() != null) {
            searchedEmp.setGender(user_entity.getGender());
        }
        if (user_entity.getMobileNo() != null) {
            searchedEmp.setMobileNo(user_entity.getMobileNo());
        }
        if (user_entity.getRemark() != null) {
            searchedEmp.setRemark(user_entity.getRemark());
        }

        return userRepository.save(searchedEmp);
    }


    public boolean deleteUser(Long id)
    {
        Optional<User_Entity> user = userRepository.findById(id);
        if(user.isPresent())
        {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
