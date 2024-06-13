package org.c4marathon.assignment.openMarket.repository;

import org.c4marathon.assignment.openMarket.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
