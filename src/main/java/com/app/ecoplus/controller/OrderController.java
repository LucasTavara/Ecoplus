package com.app.ecoplus.controller;

import com.app.ecoplus.dto.Order.OrderDto;
import com.app.ecoplus.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> findAll(){
        List<OrderDto> orderDto = orderService.findALl();
        return ResponseEntity.ok(orderDto);
    }
//    Create
    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("byuser/{id}")
    public ResponseEntity<List<?>> findByUser(@PathVariable Long id){
        return ResponseEntity.ok(this.orderService.findAllOrdersByUser(id));
    }
//    Update
    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto){
        OrderDto updatedOrder = orderService.updateOrder(id, orderDto);
        return ResponseEntity.ok(updatedOrder);
    }
//    List
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id){
        Optional<OrderDto> orderDto = orderService.findById(id);
        return orderDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
//    Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

//        Optional<OrderDto> existingOrderDto = orderService.findById(id);
//        if(existingOrderDto.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.ok(orderService.deleteOrder(id));
//    }
}
