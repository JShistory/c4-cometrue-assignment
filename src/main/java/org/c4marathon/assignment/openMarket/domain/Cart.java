package org.c4marathon.assignment.openMarket.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public Long getPrice(){
        return items.stream()
                .mapToLong(Item::getPrice)
                .sum();
    }
}
