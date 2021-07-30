package com.example.apipokemon.Webservices.Services;

import com.example.apipokemon.Model.User;
import com.example.apipokemon.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Component
public class UserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User getUser(String username, String password)
    {
        return userRepository.getUser(username, getSha1(password).toUpperCase());
    }

    public void addUser(User user)
    {
        user.setUserId(0);
        user.setPassword(getSha1(user.getPassword()).toUpperCase());
        userRepository.save(user);
    }

    public String getSha1(String password) {
        String sha1;

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        digest.reset();
        digest.update(password.getBytes(StandardCharsets.UTF_8));
        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        return sha1;
    }
}
