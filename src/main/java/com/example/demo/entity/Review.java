package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @Column(name = "review_title", nullable = false)
    private String reviewTitle;

    @Column(name = "review_written_time", nullable = false)
    private LocalDateTime reviewWrittenTime;

    @Column(name = "review_img")
    private String reviewImg;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;
}
