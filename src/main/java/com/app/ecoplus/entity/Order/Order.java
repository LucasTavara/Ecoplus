package com.app.ecoplus.entity.Order;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="Order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private Status Status;


    @Column(name = "provaider_id")
    private Long provaider_id;

}
