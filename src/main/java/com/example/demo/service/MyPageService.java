package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MyPageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MyPageService {
    private final MyPageRepository myPageRepository;

    // 회원 이메일로 회원정보 조회
    public List<MemberDTO> getMemberByEmail(String email) {
        List<Member> memberList = myPageRepository.findByUsername(email); // 파라미터값(?)
        List<MemberDTO> memberDTOS = new ArrayList<>();

        for (Member member : memberList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setEmail(member.getUsername()); // 이메일;
            memberDTO.setMemberName(member.getMemberName()); // 이름
            memberDTO.setNickName(member.getNickname());
            memberDTO.setAddress(member.getAddress()); // 주소
            memberDTO.setImg(member.getImg());
            memberDTO.setBadges(member.getBadges());
            memberDTO.setTotalPrice(member.getTotalPrice());
            memberDTO.setIsDelete(member.getIsDelete());

            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }

    //회원 닉네임 수정
    public boolean updateNickname(String currentNickname, String newNickname) {
        Optional<Member> existingMember = myPageRepository.findByNickname(currentNickname);
        if (existingMember.isPresent()) {
            Member member = existingMember.get();
            Optional<Member> existingMemberWithNewNickname = myPageRepository.findByNickname(newNickname);
            if (!existingMemberWithNewNickname.isPresent()) {
                member.setNickname(newNickname);
                System.out.println(newNickname + "닉 변경");
                myPageRepository.save(member);
                return true;
            }
        }
        return false;
    }
}