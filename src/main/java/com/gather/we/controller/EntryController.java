package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.EntryDTO;
import com.gather.we.service.EntryService;



@Controller
public class EntryController {
	@Autowired
    EntryService service;
	
	 @GetMapping("/hobby/entry")
	 public ModelAndView EntryHobby() {
		    ModelAndView mav = new ModelAndView();
		    List<EntryDTO> entryList = service.getAllEntry();
		    mav.addObject("entryList", entryList);
		    mav.setViewName("/hobby/entry");
		    return mav;
		}
}
