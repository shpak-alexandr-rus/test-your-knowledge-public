/**
 * ToDo: Добавить коментарий
 */
package com.shpakalexandr.tykapi.services;

import com.shpakalexandr.tykapi.entities.Role;
import com.shpakalexandr.tykapi.entities.User;
import com.shpakalexandr.tykapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Optional<User> findByAccountName(String accountName) {
        return userRepository.findByAccountName(accountName);
    }

    @Override
    @Transactional  // Добавляется для того, чтобы подгружалась коллекция ролей (если не добавлять,
                    // то будет получено исключение LazyInitializationException)
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        User user = findByAccountName(accountName).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден.", accountName)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getAccountName(),
                user.getPassword(),
                mapRolesAndAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesAndAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
    }
}
