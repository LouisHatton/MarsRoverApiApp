package com.application.marsapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.marsapi.response.MarsRoverApiResponse;
import com.application.marsapi.service.MarsRoverApiService;
import org.springframework.util.ObjectUtils;

@Controller
public class MainController {

	@Autowired
	private MarsRoverApiService roverService;
	
	@GetMapping("/")
	public String getRoot (ModelMap model, @RequestParam(required=false) String roverData,
			@RequestParam(required=false) Integer marsSol) {
		
		
		if (ObjectUtils.isEmpty(roverData)) {
			roverData = "curiosity";
		} else {
			roverData = roverData.toLowerCase();
		}
		if (marsSol == null) {
			marsSol = 1;
		}
		MarsRoverApiResponse apiResponse = roverService.getRoverData(roverData, marsSol);
		model.put("roverData", apiResponse);
		return "index";
	}
	
}
