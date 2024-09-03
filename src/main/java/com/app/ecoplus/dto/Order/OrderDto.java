package com.app.ecoplus.dto.Order;

import com.app.ecoplus.entity.Order.Order;
import com.app.ecoplus.entity.Order.Status;

import com.app.ecoplus.entity.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto  implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    @Valid
    @NotNull(message = "Email obrigatório")
    private String title;

    @NotNull(message = "Descrição Obrigatória ")
    private String description;

    @NotNull(message = "Status do Produto")
    private Status status;

    private Long userRef;



    public OrderDto(Order order) {
        this.title = order.getTitle();
        this.description = order.getDescription();
        this.status = order.getStatus();
    }
}
