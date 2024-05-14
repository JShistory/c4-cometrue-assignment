package org.c4marathon.assignment.openMarket.dto;

import lombok.Builder;
import lombok.Data;
import org.c4marathon.assignment.openMarket.domain.Item;

@Data
public class ItemDTO {
    private Long id;
    private String name;
    private Long price;
    private int amount;
    private String description;
    private String picture;
    @Builder
    public ItemDTO(Long id, String name, Long price, int amount, String description, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.picture = picture;
    }

    public Item toEntity(){
        return Item.builder()
                .name(this.name)
                .price(this.price)
                .amount(this.amount)
                .description(this.description)
                .picture(this.picture)
                .build();
    }
}
