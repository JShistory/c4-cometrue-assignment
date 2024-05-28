package org.c4marathon.assignment.openMarket.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;
    private Long cartPrice;
    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private User user;
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    public Cart() {

    }

    public Long getPrice(){
        return items.stream()
                .mapToLong(Item::getPrice)
                .sum();
    }
    @Builder
    public Cart(Long id, int count, Long cartPrice, User user, List<Item> items) {
        this.id = id;
        this.count = count;
        this.cartPrice = cartPrice;
        this.user = user;
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
        System.out.println(this.items);
    }

    public void addUser(User user){
        this.user = user;
        user.initCart(this);
    }


}
