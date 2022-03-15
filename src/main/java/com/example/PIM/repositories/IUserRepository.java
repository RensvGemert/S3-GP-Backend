package com.example.PIM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PIM.model.User;
public interface IUserRepository extends JpaRepository<User, Integer>
{

}
