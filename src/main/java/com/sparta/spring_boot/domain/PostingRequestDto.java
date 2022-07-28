package com.sparta.spring_boot.domain;

import lombok.Getter;
import lombok.Setter;

//@Data @getter,@setter 대신 쓸 수 있음
@Setter
@Getter // 데이터를 조회할 때 필요한 getter 생성자 자동 생성
public class PostingRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;
    private int result;
}