package edu.pasudo123.study.demo.transactional.controller;

import edu.pasudo123.study.demo.transactional.service.DoSomethingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DoSomethingController {

    private static final String RETURN_VALUE = "{\"status\" : \"success\"}";
    private final DoSomethingService somethingService;

    @GetMapping("public-do")
    public String publicSomething() {
        somethingService.publicAccessModifierSave();
        return RETURN_VALUE;
    }

    @GetMapping("default-do/{number}")
    public String defaultSomething(@PathVariable(value = "number", required = false) String number) {
        somethingService.publicToDefaultModifierSave(number);
        return RETURN_VALUE;
    }

    @GetMapping("protected-do/{number}")
    public String protectedSomething(@PathVariable(value = "number", required = false) String number) {
        somethingService.publicToProtectedModifierSave(number);
        return RETURN_VALUE;
    }

    @GetMapping("private-do/{number}")
    public String privateSomething(@PathVariable(value = "number", required = false) String number) {
        somethingService.publicToPrivateModifierSave(number);
        return RETURN_VALUE;
    }
}
