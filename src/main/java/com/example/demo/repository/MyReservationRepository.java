package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.entity.MyReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyReservationRepository extends JpaRepository<MyReservation, Long> {
    List<MyReservation> findByMemberId(Long memberId);
}