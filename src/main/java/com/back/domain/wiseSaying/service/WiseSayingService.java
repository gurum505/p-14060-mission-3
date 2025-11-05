package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

/*역할 : 순수 비지니스 로직

        스캐너 사용금지, 출력 금지*/
public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public int create(String content, String author) {
        int wiseId = 0;
        wiseSayingRepository.create(content,author);

        return wiseId;
    }

    public void update(int wiseId, String new_content, String new_author) {
        wiseSayingRepository.update(wiseId,new_content,new_author);

    }

    public void delete(int wiseId) {
        wiseSayingRepository.delete(wiseId);

    }

    public void findAll() {
        wiseSayingRepository.findAll();

    }

    public WiseSaying findById(int wiseId) {
        return wiseSayingRepository.findById(wiseId);
    }

}
