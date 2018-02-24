package com.product.controller;

import com.product.models.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class ControllerSpring {

    private List<Message> storage = new ArrayList<> ();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Message> getString() {
        return storage;
    }

    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public void addMessage(@RequestBody Message message) {
        storage.add (message);
    }
}
