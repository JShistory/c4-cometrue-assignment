package org.c4marathon.assignment.openMarket.service;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Item;
import org.c4marathon.assignment.openMarket.dto.ItemDTO;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(ItemDTO item, UserDTO user){
        Item saveItem = item.toEntity();
//        saveItem.setUser(user.toEntity());
        itemRepository.save(saveItem);
        return saveItem.getId();
    }
}
