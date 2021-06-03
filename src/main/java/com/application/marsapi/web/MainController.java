package com.application.marsapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.marsapi.response.MarsRoverApiResponse;
import com.application.marsapi.service.MarsRoverApiService;

@Controller
public class MainController {

	@Autowired
	private MarsRoverApiService roverService;
	
	@GetMapping("/")
	public String getRoot (ModelMap model) {
		MarsRoverApiResponse roverData = roverService.getRoverData();
		model.put("roverData", roverData);
		return "index";
	}
	
}
