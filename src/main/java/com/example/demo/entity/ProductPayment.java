package com.example.demo.entity;

import com.example.demo.constant.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "product_payment")
public class ProductPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_payment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int amount;

    @Column(name = "reservation_payment_time", nullable = false)
    private LocalDateTime pPayTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_cancelled")
    private PaymentStatus paymentStatus;

    @Column(name = "cancel_date")
    private LocalDateTime pCancelDate;
}
