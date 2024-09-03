package com.app.ecoplus.controller.order;

import com.app.ecoplus.dto.Order.OrderDto;
import com.app.ecoplus.service.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderDto orderDto){
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

    //Tratariva de erro BAD_REQUEST na requisição
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
