package com.eventsapp.controllers;

import com.eventsapp.models.Event;
import com.eventsapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/eventRegister", method = RequestMethod.GET)
    public String form() {
        return "event/eventForm";
    }

    @RequestMapping(value = "/eventRegister", method = RequestMethod.POST)
    public String form(Event event) {

        eventRepository.save(event);

        return "redirect:/eventRegister";
    }

    @RequestMapping("/events")
    public ModelAndView eventsList() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Event> events = eventRepository.findAll();
        mv.addObject("events", events);
        return mv;
    }

}
