package org.c4marathon.assignment.openMarket.service;

import java.util.List;
import java.util.Optional;
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
        validateDuplicateMember(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(User user) {
        //Exception
        Optional<User> findUser = userRepository.findByAccountId(user.getAccountId());
        if (findUser.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
