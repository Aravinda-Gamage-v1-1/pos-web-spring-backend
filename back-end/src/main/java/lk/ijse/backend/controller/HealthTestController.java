package lk.ijse.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/healthtest")
public class HealthTestController {

    static Logger logger = LoggerFactory.getLogger(HealthTestController.class);

    @GetMapping
    public String healthTest() {
        logger.info("Health Test");
        return "Health Test";
    }
}
