package com.application.marsapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.marsapi.dto.RootDto;
import com.application.marsapi.response.MarsRoverApiResponse;
import com.application.marsapi.service.MarsRoverApiService;
import org.springframework.util.ObjectUtils;

@Controller
public class MainController {

	@Autowired
	private MarsRoverApiService roverService;
	
	@GetMapping("/")
	public String getRoot (ModelMap model, RootDto dto) {
		
		if (ObjectUtils.isEmpty(dto.getRoverData())) {
			dto.setRoverData("curiosity");
		} else {
			dto.setRoverData(dto.getRoverData().toLowerCase());
		}
		if (dto.getMarsSol() == null) {
			dto.setMarsSol(1);
		}
		MarsRoverApiResponse apiResponse = roverService.getRoverData(dto);
		model.put("roverData", apiResponse);
		model.put("RootDto", dto);
		model.put("validCameras", roverService.getValidCameras());
		return "index";
	}
	
}
