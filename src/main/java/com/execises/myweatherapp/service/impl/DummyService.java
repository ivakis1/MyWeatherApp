package com.execises.myweatherapp.service.impl;

import com.execises.myweatherapp.service.IDummyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: What is @Service in the context of the Spring Framework
//TODO: Why is there a interface, do we need it?
@Service
public class DummyService implements IDummyService {

    //TODO: why is this static and final?
    private static final List<String> names = new ArrayList<>(Arrays.asList("Pesho", "Gosho", "Misho", "i drugi kaltaci"));

    @Override
    public List<String> getMyFriendsNames() {
        //Currently we do not have a database, so we will use this hard-coded list
        return names;
    }

    @Override
    public String getFriendByName(final String name) {
        //TODO: What is that question mark, how do we call it
        return names.contains(name) ? String.format("%s is one of my friends", name) : "I don't know this guy";
    }
}
