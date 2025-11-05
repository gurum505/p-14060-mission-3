package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

/*
* 역할 : 데이터의 조회/수정/삭제/생성을 담당

스캐너 사용금지, 출력 금지*/
public class WiseSayingRepository {
    String dbPath = "wiseSaying.db";

    public void create(String content, String author) {
    }
    public void update(int wiseId, String new_content, String new_author) {
    }
    public void delete(int wiseId) {
    }
    public void findAll() {
    }
    public WiseSaying findById(int wiseId) {
        return null;
    }

}
