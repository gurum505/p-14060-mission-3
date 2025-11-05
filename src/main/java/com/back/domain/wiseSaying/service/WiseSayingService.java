package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.repository.WiseSayingRepository;

/*역할 : 순수 비지니스 로직

        스캐너 사용금지, 출력 금지*/
public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public void create() {
        wiseSayingRepository.create();
    }

    public void update() {
        wiseSayingRepository.update();

    }

    public void delete() {
        wiseSayingRepository.delete();

    }

    public void findAll() {
        wiseSayingRepository.findAll();

    }

}
