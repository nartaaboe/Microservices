package com.example.orderservice.service;

import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderItem;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItem> orderItems = orderRequest.getOrderItems()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }
    private OrderItem mapToDto(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setSkuCode(orderItemDto.getSkuCode());
        return orderItem;
    }
}
