package com.example.inventoryservice.service;

import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean IsInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
