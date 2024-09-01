package com.app.ecoplus.mapper;

import com.app.ecoplus.dto.Order.OrderDto;
import com.app.ecoplus.entity.Order.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderDto orderDto){
        if(orderDto == null){
            return null;
        }
        Order order = new Order();
        order.setTitle(orderDto.getTitle());
        order.setDescription(orderDto.getDescription());
        order.setStatus(orderDto.getStatus());
        return order;
    }

    public OrderDto toOrderDto(Order order){
        if(order == null){
            return null;
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setTitle(order.getTitle());
        orderDto.setDescription(order.getDescription());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }
}
