package com.example.Users_Details;

import com.example.Users_Details.Entities.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User_Entity, Long> {
//    User_Entity save(User_Entity user_entity);
}
