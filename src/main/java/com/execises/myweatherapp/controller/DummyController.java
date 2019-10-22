package com.execises.myweatherapp.controller;

import com.execises.myweatherapp.service.IDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Check what is the difference between @RestController and @Controller
@Controller
@RequestMapping("/dummy")
public class DummyController {

    //TODO: What is @Autowired? Where should it stands and why
    @Autowired
    private IDummyService dummyService;

    //TODO: What is @ResponseBody
    @RequestMapping(
            path = "/getAll",
            method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllMyFriendsNames() {
        //TODO: Add logger.

        List<String> myFriendsNames = dummyService.getMyFriendsNames();

        return myFriendsNames;
    }

    //TODO: What is the difference between @RequestMapping on action and @GetMapping?
    //TODO: How @RequestMapping is working when placed on @Controller
    @GetMapping(path = "/getFriendByName/{name}")
    @ResponseBody
    public String getFriendByHisName(@PathVariable String name) {
        //TODO: Add logger.

       final String result = dummyService.getFriendByName(name);

        return result;
    }


    //TODO: This one and the previous action return the same results but work differently. How so?
    //TODO: What is @RequestParam
    //TODO: https://www.baeldung.com/spring-request-param
    @GetMapping(path = "/getFriendByNameAdvanced")
    @ResponseBody
    public String getFriendByHisNameAdvanced(@RequestParam String name) {
        //TODO: Add logger.

        final String result = dummyService.getFriendByName(name);

        return result;
    }
}
