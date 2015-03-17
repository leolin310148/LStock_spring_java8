package me.leolin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leolin
 */
@RestController
public class IndexController {
    @RequestMapping(value = {"/", "/index"},method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
