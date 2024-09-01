package com.app.ecoplus.entity.Order;


import com.app.ecoplus.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Orders")
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


    @JoinColumn(name = "userRef",nullable = true)
    private Long userRef;

}
