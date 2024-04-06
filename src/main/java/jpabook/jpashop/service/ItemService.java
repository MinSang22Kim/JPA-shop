package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 변경감지 방법으로 준영속 엔티티 수정
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) { // 피라미터로 넘어온 준영속 상태의 엔티티
        Item findItem = itemRepository.findOne(itemId); // 같은 엔티티를 조회
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity); // 엔티티 수정
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}

