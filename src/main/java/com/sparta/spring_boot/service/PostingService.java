package com.sparta.spring_boot.service;

import com.sparta.spring_boot.domain.Posting;
import com.sparta.spring_boot.domain.PostingRepository;
import com.sparta.spring_boot.domain.PostingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final 즉, 필수적으로 생성되어야 할 멤버 변수를 자동으로 생성하는 annotation
@Service // 클래스에게 service임을 알려주는 annotation
public class PostingService {

    // final: 서비스에게 꼭 필요하다는 것을 명시
    private final PostingRepository postingRepository;


    @Transactional
    public Long update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        posting.update(requestDto);
        return posting.getId();
    }
}