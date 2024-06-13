package org.c4marathon.assignment.openMarket.repository;

import java.util.Optional;
import org.c4marathon.assignment.openMarket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccountId(String accountId);
}
