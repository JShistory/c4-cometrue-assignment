package org.c4marathon.assignment.openMarket.repository;

import org.c4marathon.assignment.openMarket.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
