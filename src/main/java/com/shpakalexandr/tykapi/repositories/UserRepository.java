package com.shpakalexandr.tykapi.repositories;

import com.shpakalexandr.tykapi.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountName(String accountName);
}
