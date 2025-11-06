package com.back.domain.system.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SystemControllerTest {
    SystemController systemController = new SystemController();
    @Test
    @DisplayName("종료")
    void testExit() {
        String cmd = "종료";

        Boolean ShouldExit = systemController.start(cmd);

        assertTrue(ShouldExit);
    }

}