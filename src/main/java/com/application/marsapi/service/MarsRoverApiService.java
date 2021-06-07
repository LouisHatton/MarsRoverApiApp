package com.application.marsapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.marsapi.response.MarsRoverApiResponse;


@Service
public class MarsRoverApiService {
	
	private static final String API_KEY = "O9ofFm8K8WxBBhOa1jlCEAyphIlyfyV5HW80rwap";

	
	public MarsRoverApiResponse getRoverData (String roverName, Integer marsSol) {
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/"+roverName+"/photos?sol="+marsSol+"&api_key="+API_KEY, MarsRoverApiResponse.class);
		return response.getBody();
	}
	
}
