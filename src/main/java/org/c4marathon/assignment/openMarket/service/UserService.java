package org.c4marathon.assignment.openMarket.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Cart;
import org.c4marathon.assignment.openMarket.domain.Item;
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
    public Long join(UserDTO user, Cart cart){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.ROLE_ADMIN);
        User saveUser = user.createToEntity();
        validateDuplicateMember(saveUser);

        userRepository.save(saveUser);
        cart.addUser(saveUser);
        return saveUser.getId();
    }
    @Transactional
    public void buyItem(User user, Item item){
        boolean hashMatchingItem = user.getItems().stream()
                        .anyMatch(items -> items.getId() == item.getId());
        if(hashMatchingItem){
            throw new IllegalStateException("자신이 등록한 상품은 구매할 수 없습니다.");
        }

        user.buyItem(item.getPrice());
    }

    //readOnly
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User findOne(Long id){
        Optional<User> userOne = userRepository.findById(id);
        if(userOne.isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return userOne.get();
    }
    private void validateDuplicateMember(User user) {
        //Exception
        Optional<User> findUser = userRepository.findByAccountId(user.getAccountId());
        if (findUser.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public User findByAccountId(String accountId){
        Optional<User> user = userRepository.findByAccountId(accountId);
        return user.orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
    }
}
