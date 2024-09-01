package com.app.ecoplus.dto.Order;

import com.app.ecoplus.entity.Order.Order;
import com.app.ecoplus.entity.Order.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto  implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Status status;

    private Long provaider_id;



    public OrderDto(Order order) {
        this.id = order.getId();
        this.title = order.getTitle();
        this.description = order.getDescription();
        this.status = order.getStatus();
        this.provaider_id = order.getProvaider_id();

    }
}
