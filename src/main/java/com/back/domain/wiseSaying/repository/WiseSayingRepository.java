package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
* 역할 : 데이터의 조회/수정/삭제/생성을 담당

스캐너 사용금지, 출력 금지*/
public class WiseSayingRepository {
    String dbPath = "db/wiseSaying/";
    //file 여닫는거 통일 시키거나 따로 빼기

    public void create(WiseSaying w) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbPath + w.getId() + ".json"))){
            String formattedString = String.format(
                    "{\n" +
                            "\"id\" : %s,\n" +
                            "\"content\" : \"%s\",\n" +
                            "\"author\" : \"%s\"\n"  +
                    "}"
                    ,w.getId(),w.getContent(),w.getAuthor());
            bw.write(formattedString);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void update(WiseSaying w) {
    }
    public void delete(int wiseId) {
    }
    public ArrayList<WiseSaying> findAll() {
        //Wisesaying 리스트 반환
        //sort by id desc
        return null;
    }
    public WiseSaying findById(int wiseId) {
        //id로 명언 찾기
        //없는 id면 null 반환
        return null;
    }

}
