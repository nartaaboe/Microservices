package com.example.inventoryservice.controller;

import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        return inventoryService.IsInStock(skuCode);
    }
}
