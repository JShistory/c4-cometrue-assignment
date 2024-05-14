package org.c4marathon.assignment.openMarket.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private int amount;
    private String description;
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Builder
    public Item(Long id, String name, Long price, int amount, String description, String picture, User user) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.picture = picture;
        this.user = user;
    }

    public void setUser(User user){
        this.user = user;
        user.getItems().add(this);
    }
    public Item() {

    }
}
