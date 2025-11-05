package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.domain.wiseSaying.service.WiseSayingService;

/*
* 역할 : 고객의 명령을 입력받고 적절한 응답을 표현

이 단계에서는 스캐너 사용가능

이 단계에서는 출력 사용가능

역할 : 명언에 관련된 응대*/
public class WiseSayingController {
    WiseSayingService wiseSayingService = new WiseSayingService();
    public void start() {
        System.out.println("== 명언 앱 ==");
        if(true){
            create();
        }
    }
    public void create() {
        System.out.println("명언을 등록합니다.");
        wiseSayingService.create();

    }
    public void update() {
        System.out.println("명언을 등록합니다.");
        wiseSayingService.update();

    }
    public void delete() {
        System.out.println("명언을 등록합니다.");
        wiseSayingService.delete();

    }
    public void findAll() {
        System.out.println("명언을 등록합니다.");
        wiseSayingService.findAll();

    }
}
