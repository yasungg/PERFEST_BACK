package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter@Setter
public class CommunityDTO {
    private Long communityId;
    private Long memberId;
    private String communityTitle;
    private String communityCategory;
    private String communityDesc;
    private String communityImgLink;
    private int likeCount;
    private LocalDateTime writtenTime;
    private String nickname;

}
