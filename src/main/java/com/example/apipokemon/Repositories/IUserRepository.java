package com.example.apipokemon.Repositories;

import com.example.apipokemon.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM [pokemon].[dbo].[users] WHERE username=:username AND password=:password", nativeQuery = true)
    User getUser(@Param("username") String username, @Param("password") String password);
}
