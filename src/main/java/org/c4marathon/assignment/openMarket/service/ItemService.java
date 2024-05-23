package org.c4marathon.assignment.openMarket.service;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Item;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.dto.ItemDTO;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Transactional
    public Long saveItem(ItemDTO item, Long userId){
        User user = userService.findOne(userId);
        UserDTO userDTO = UserDTO.fromEntity(user);
        Item saveItem = item.toEntity();
        saveItem.setUser(userDTO.toEntity());
        itemRepository.save(saveItem);
        return saveItem.getId();
    }

    public List<ItemDTO> findAll(){
        List<ItemDTO> itemList = itemRepository.findAll().stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());

        return itemList;
    }

    public Item findById(Long id){
        return itemRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 상품은 존재하지 않습니다."));
    }

}
