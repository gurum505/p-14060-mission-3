package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WiseSayingControllerTest {

    public class TestUtil {
        public static Scanner genScanner(String input) {
            return new Scanner(new ByteArrayInputStream(input.getBytes()));
        }
    }

    //가짜 서비스 클래스
    private class WiseSayingServiceStub extends WiseSayingService {
        String content ="나에게 불가능이란 없다.";
        String author = "나폴레옹";
        int id = 1;

        @Override
        public int create(String content, String author) {
            return 1;
        }

        @Override
        public WiseSaying findById(int wiseId) {
            return new WiseSaying(wiseId,content, author);
        }

        @Override
        public WiseSaying update(int wiseId, String new_content, String new_author) {
            return new WiseSaying(wiseId,new_content, new_author);
        }

        @Override
        public WiseSaying delete(int wiseId) {
            return new WiseSaying(wiseId,content, author);
        }

        @Override
        public ArrayList<WiseSaying> findAll() {
            ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
            wiseSayings.add(new WiseSaying(id,content, author));
            return wiseSayings;
        }

        @Override
        public void build() {
            return;
        }

    }

    //출력 가로채기 설정
    private final ByteArrayOutputStream outputStreamCapture = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStreamCapture));
        outputStreamCapture.reset();
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(standardOut);
    }


    @Test
    @DisplayName("등록")
    void testCreate() {
        String input =
                """
                나에게 불가능이란 없다.
                나폴레옹
                """;

        String output =
                "명언 : 작가 : 1번 명언이 등록되었습니다.";

        WiseSayingServiceStub wiseSayingServiceStub= new WiseSayingServiceStub();

        Scanner scanner = TestUtil.genScanner(input);

        WiseSayingController wiseSayingController = new WiseSayingController(scanner,wiseSayingServiceStub);

        wiseSayingController.create();

        String result = outputStreamCapture.toString().replace("\r", "").trim();

        assertEquals(output, result);

    }

    @Test
    @DisplayName("수정")
    void testUpdate() {
        String input =
                """
                나에게 불가능이란 없다.
                나폴레옹
                """;

        String output =
                """
                        명언(기존) : 나에게 불가능이란 없다.
                        명언 : 작가(기존) : 나폴레옹
                        작가 : """;

        WiseSayingServiceStub wiseSayingServiceStub= new WiseSayingServiceStub();

        Scanner scanner = TestUtil.genScanner(input);

        WiseSayingController wiseSayingController = new WiseSayingController(scanner,wiseSayingServiceStub);

        wiseSayingController.update("수정?id=1");

        String result = outputStreamCapture.toString().replace("\r", "").trim();

        assertEquals(output, result);

    }

    @Test
    @DisplayName("삭제")
    void testDelete() {
        String input =
                """
                나에게 불가능이란 없다.
                나폴레옹
                """;

        String output =
                "1번 명언이 삭제되었습니다.";

        WiseSayingServiceStub wiseSayingServiceStub= new WiseSayingServiceStub();

        Scanner scanner = TestUtil.genScanner(input);

        WiseSayingController wiseSayingController = new WiseSayingController(scanner,wiseSayingServiceStub);

        wiseSayingController.delete("삭제?id=1");

        String result = outputStreamCapture.toString().replace("\r", "").trim();

        assertEquals(output, result);

    }

    @Test
    @DisplayName("목록")
    void testFindAll() {
        String input =
                """
                나에게 불가능이란 없다.
                나폴레옹
                """;

        String output =
                "번호 / 작가 / 명언\n" +
                 "----------------------\n" +
                 "1 / 나에게 불가능이란 없다. / 나폴레옹";

        WiseSayingServiceStub wiseSayingServiceStub= new WiseSayingServiceStub();

        Scanner scanner = TestUtil.genScanner(input);

        WiseSayingController wiseSayingController = new WiseSayingController(scanner,wiseSayingServiceStub);

        wiseSayingController.findAll();

        String result = outputStreamCapture.toString().replace("\r", "").trim();

        assertEquals(output, result);

    }

    @Test
    @DisplayName("빌드")
    void testBuild() {
        String input ="빌드";

        String output = "data.json 파일의 내용이 갱신되었습니다.";

        WiseSayingServiceStub wiseSayingServiceStub= new WiseSayingServiceStub();

        Scanner scanner = TestUtil.genScanner(input);

        WiseSayingController wiseSayingController = new WiseSayingController(scanner,wiseSayingServiceStub);

        wiseSayingController.build();

        String result = outputStreamCapture.toString().replace("\r", "").trim();

        assertEquals(output, result);

    }





}