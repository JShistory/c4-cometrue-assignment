package org.c4marathon.assignment.openMarket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Item;

@Data
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private Long price;
    private int amount;
    private String description;
    private String picture;
    private Long userId; // 사용자 ID 또는 다른 식별자

    public ItemDTO(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.amount = item.getAmount();
        this.description = item.getDescription();
        this.picture = item.getPicture();
        this.userId = item.getUser().getId(); // 사용자 ID 또는 다른 식별자 할당
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

    public static ItemDTO fromEntity(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setAmount(item.getAmount());
        dto.setDescription(item.getDescription());
        dto.setPicture(item.getPicture());
        // 사용자 ID 또는 다른 식별자는 필요에 따라 설정
         dto.setUserId(item.getUser().getId());
        return dto;
    }
}
