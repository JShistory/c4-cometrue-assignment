package org.c4marathon.assignment.openMarket.service;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Cart;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    @Transactional
    public Cart CartCreate(){
        Cart cart = Cart.builder()
                .count(0)
                .cartPrice(0L)
                .build();
        cartRepository.save(cart);
        return cart;
    }
}
