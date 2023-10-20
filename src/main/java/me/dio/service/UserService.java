package me.dio.service;

import me.dio.domain.moldel.User;

public interface UserService {
    User findById (Long id);

    User create(User userToCreate);
}
