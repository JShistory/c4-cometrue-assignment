package org.c4marathon.assignment.openMarket.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.domain.UserRole;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public Long join(UserDTO user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.ROLE_ADMIN);
        User saveUser = user.createToEntity();
        validateDuplicateMember(saveUser);
        userRepository.save(saveUser);
        return saveUser.getId();
    }

    //readOnly
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public UserDTO findOne(Long id){
        Optional<User> userOne = userRepository.findById(id);
        if(userOne.isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return new UserDTO().fromEntity(userOne.get());
    }
    private void validateDuplicateMember(User user) {
        //Exception
        Optional<User> findUser = userRepository.findByAccountId(user.getAccountId());
        if (findUser.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
