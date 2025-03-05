package com.secure.notes.security.services;

import java.util.List;

import com.secure.notes.dto.UserDTO;
import com.secure.notes.models.User;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

	User findByUsername(String username);
}

