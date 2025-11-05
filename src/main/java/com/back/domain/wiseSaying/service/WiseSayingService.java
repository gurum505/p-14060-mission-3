package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;

/*역할 : 순수 비지니스 로직

        스캐너 사용금지, 출력 금지*/
public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

    public int create(String content, String author) {
        int lastId = wiseSayingRepository.getLastId();
        int newId = lastId + 1;

        WiseSaying w = new WiseSaying(newId,content, author);
        wiseSayingRepository.create(w);

        WiseSaying.setLastId(newId);
        wiseSayingRepository.setLastId(newId);

        return newId;
    }

    public WiseSaying update(int wiseId, String new_content, String new_author) {
        int lastId = wiseSayingRepository.getLastId();
        WiseSaying w = findById(wiseId);
        if (wiseId > lastId || w == null) {
            return null;
        }
        WiseSaying new_w = new WiseSaying(wiseId,new_content, new_author);
        wiseSayingRepository.update(new_w);
        return new_w;
    }

    public WiseSaying delete(int wiseId) {
        int lastId = wiseSayingRepository.getLastId();
        WiseSaying w = findById(wiseId);
        if (wiseId > lastId || w == null) {
            return null;
        }
        wiseSayingRepository.delete(wiseId);
        return w;
    }

    public ArrayList<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int wiseId) {
        WiseSaying w = null;
        w = wiseSayingRepository.findById(wiseId);
        return w;
    }

}
