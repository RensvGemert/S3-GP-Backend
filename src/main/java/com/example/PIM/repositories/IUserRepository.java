package com.example.PIM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PIM.model.User;
import org.springframework.data.jpa.repository.Query;

import static org.hibernate.loader.Loader.SELECT;

public interface IUserRepository extends JpaRepository<User, Integer>
{
    @Query(value = "SELECT `id` FROM `user` WHERE `email` = ?1 AND `password` = ?2", nativeQuery = true)
    int login(String email, String password);

}
