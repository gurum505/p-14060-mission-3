package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 역할 : 고객의 명령을 입력받고 적절한 응답을 표현

이 단계에서는 스캐너 사용가능

이 단계에서는 출력 사용가능

역할 : 명언에 관련된 응대*/
public class WiseSayingController {
    WiseSayingService wiseSayingService = new WiseSayingService();
    Scanner sc = new Scanner(System.in);

    public void start(String cmd) {
        if(cmd.equals("등록")) {
            create(cmd);
        }
        else if (cmd.startsWith("수정")) {
            update(cmd);
        }
        else if (cmd.startsWith("삭제")) {
            delete(cmd);
        }
        else if (cmd.equals("목록")) {
            findAll();
        }

    }

    public void create(String cmd) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        int wiseId = wiseSayingService.create(content, author);

        System.out.println(wiseId + "번 명언이 등록되었습니다.");
    }

    public void update(String cmd) {
        int wiseId = getIdFromCmd(cmd);

        WiseSaying w = wiseSayingService.findById(wiseId);
        if(w == null) {
            System.out.println(wiseId + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.print("명언(기존) : ");
        String new_content = sc.nextLine();
        System.out.print("작가(기존) : ");
        String new_author = sc.nextLine();

        wiseSayingService.update(wiseId, new_content, new_author);
    }

    public void delete(String cmd) {
        int wiseId = getIdFromCmd(cmd);

        WiseSaying w = wiseSayingService.findById(wiseId);
        if(w == null) {
            System.out.println(wiseId + "번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingService.delete(wiseId);

    }

    public void findAll() {

        wiseSayingService.findAll();

    }


    private int getIdFromCmd(String cmd) {
        Pattern pattern = Pattern.compile("\\?id=(\\d+)");
        Matcher matcher = pattern.matcher(cmd);
        if(matcher.find()){
            return Integer.parseInt( matcher.group(1));
        }else{
            return -1;
        }

    }
}
