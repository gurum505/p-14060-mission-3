package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

//역할 : 사용자 입력을 받고 그것이 WiseSayingController 에게 넘거야 하는지 판단해서 맞으면 넘김(넘김의 의미 : 메서드 호출(인자와 함께))
//
//이 단계에서는 스캐너 사용가능
//
//이 단계에서는 출력 사용가능
public class App {
    public void run() {
        Scanner sc = new Scanner(System.in);
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("=== 명언 앱 ===");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Boolean shouldExit = false;
            if (cmd.equals("등록") || cmd.equals("목록") || cmd.startsWith("삭제") || cmd.startsWith("수정") || cmd.equals("빌드")) {
                wiseSayingController.start(cmd);
            }
            else{
                shouldExit = systemController.start(cmd);
            }

            if(shouldExit){
                break;
            }
        }








    }
}
