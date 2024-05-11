package org.c4marathon.assignment.openMarket.service;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(User user){
        userRepository.save(user);
        return user.getId();
    }
}
