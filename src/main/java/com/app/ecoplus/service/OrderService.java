package com.app.ecoplus.service;

import com.app.ecoplus.dto.Order.OrderDto;
import com.app.ecoplus.entity.Order.Order;
import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.mapper.OrderMapper;
import com.app.ecoplus.repository.OrderRepository;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

//Create
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);
        Order createdOrder = orderRepository.save(order);
        return orderMapper.toOrderDto(createdOrder);
    }

    public List<?> findAllOrdersByUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("User "+userId+" not found"));
        List<?> orders = this.orderRepository.findByUserRef(user.getId());
        return orders;
    }

//Update
    public OrderDto updateOrder(Long id, OrderDto orderDto){
        Optional<Order> existingOrder = orderRepository.findById(id);
        if(existingOrder.isEmpty()){
            throw new ObjectNotFoundException("Order not found");
        }
        Order order = existingOrder.get();
        order.setTitle(orderDto.getTitle());
        order.setDescription(orderDto.getDescription());
        order.setStatus(orderDto.getStatus());
        Order updatedUser = orderRepository.save(order);
        return orderMapper.toOrderDto(updatedUser);
    }
//Delete
    public void deleteOrder(Long id){
        if(!orderRepository.existsById(id)){
            throw new ObjectNotFoundException("Order not found");
        }
        orderRepository.deleteById(id);
    }
// list
    public List<OrderDto> findALl(){
        List<Order> order = orderRepository.findAll();
        return order.stream().map(orderMapper::toOrderDto).toList();

    }

// list id
    public Optional<OrderDto> findById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            return Optional.empty();
        }
        Order newOrder = order.get();
        return Optional.of(orderMapper.toOrderDto(newOrder));
    }
}