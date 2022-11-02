package com.dangphan.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dangphan.springboot.dto.NewDTO;
import com.dangphan.springboot.service.INewService;

@Controller
public class TestController {

	@Autowired
	INewService newService;

	@GetMapping("/homepage")
	public String homepage(Model model) {
		List<NewDTO> newsList = new ArrayList<>();
		newsList = newService.findAll();
		model.addAttribute("newsList", newsList);
		return "homepage";
	}

    @GetMapping("/user")
    public String userEndpoint() {
        return "user";
    }

    @GetMapping("/all")
    public String allRolesEndpoint() {
        return "all";
    }
    
    @DeleteMapping("/delete")
    public String deleteEndpoint(@RequestBody String s) {
        return "I am deleting " + s;
    }
}
