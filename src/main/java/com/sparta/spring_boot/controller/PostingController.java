package com.sparta.spring_boot.controller;

import com.sparta.spring_boot.domain.Posting;
import com.sparta.spring_boot.domain.PostingRepository;
import com.sparta.spring_boot.domain.PostingRequestDto;
import com.sparta.spring_boot.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor// final 즉, 필수적으로 생성되어야 할 멤버 변수를 자동으로 생성하는 annotation
@RestController//Json 형태(딕셔너리하고 리스트가 조금 합쳐진 형태)로 객체 데이터를 반환
public class PostingController {

    private final PostingRepository postingRepository;
    private final PostingService postingService;

    // 게시글 생성 api
    @PostMapping("/api/postings")
    public Posting createPosting(@RequestBody PostingRequestDto requestDto) {
        // Posting 클래스의 새로운 객체 생성
        Posting posting = new Posting(requestDto);
        return postingRepository.save(posting);
    }

    // 게시글 전체 조회 api
    @GetMapping("/api/postings")
    public List<Posting> getPostings() {
        return postingRepository.findAllByOrderByCreatedAtDesc();
    }

    //    게시글 상세 조회 api
    @GetMapping("/api/postings/{id}")
    public Posting getDetailPosting(@PathVariable Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return posting;
    }

    // 게시글 삭제 api
    @DeleteMapping("/api/postings/{id}")
    public Long deletePosting(@PathVariable Long id) {
        postingRepository.deleteById(id);
        return id;
    }

    // 게시글 변경 api
    @PutMapping("/api/postings/{id}")
    public Long updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        postingService.update(id, requestDto);
        return id;
    }
+
}