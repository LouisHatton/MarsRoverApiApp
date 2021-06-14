package com.application.marsapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.marsapi.dto.RootDto;
import com.application.marsapi.response.MarsPhoto;
import com.application.marsapi.response.MarsRoverApiResponse;


@Service
public class MarsRoverApiService {
	
	private static final String API_KEY = "O9ofFm8K8WxBBhOa1jlCEAyphIlyfyV5HW80rwap";
	
	private Map<String, List<String>> validCameras = new HashMap<>();
	  
	public MarsRoverApiService () {
		validCameras.put("opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
		validCameras.put("curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
		validCameras.put("spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
	  }

	
	public MarsRoverApiResponse getRoverData (RootDto dto) {
		RestTemplate rt = new RestTemplate();
		
		String baseUrl = "https://api.nasa.gov/mars-photos/api/v1/rovers/"+dto.getRoverData()+"/photos?sol="+dto.getMarsSol()+"&api_key="+API_KEY;
		List<String> camUrls = getCamUrls(dto, baseUrl);
		List<MarsPhoto> photos = new ArrayList<>();
		
		camUrls.stream()
					.forEach(url -> {
						MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
						photos.addAll(apiResponse.getPhotos());
					});
		
		MarsRoverApiResponse response = new MarsRoverApiResponse();
		response.setPhotos(photos);
		return response;
	}
	
	private List<String> getCamUrls(RootDto dto, String baseUrl) {
		List<String> urls = new ArrayList<>();
		
		try {
			if (dto.getCameraFHAZ()) {
				urls.add(baseUrl + "&camera=FHAZ");
			}
			if (dto.getCameraRHAZ()) {
				urls.add(baseUrl + "&camera=RHAZ");
			}
			if (dto.getCameraMAST() && "curiosity".equalsIgnoreCase(dto.getRoverData())) {
				urls.add(baseUrl + "&camera=MAST");
			}
			if (dto.getCameraCHEMCAM() && "curiosity".equalsIgnoreCase(dto.getRoverData())) {
				urls.add(baseUrl + "&camera=CHEMCAM");
			}
			if (dto.getCameraMAHLI() && "curiosity".equalsIgnoreCase(dto.getRoverData())) {
				urls.add(baseUrl + "&camera=MAHLI");
			}
			if (dto.getCameraMARDI() && "curiosity".equalsIgnoreCase(dto.getRoverData())) {
				urls.add(baseUrl + "&camera=MARDI");
			}
			if (dto.getCameraNAVCAM()) {
				urls.add(baseUrl + "&camera=NAVCAM");
			}
			if (dto.getCameraPANCAM() && !"curiosity".equalsIgnoreCase(dto.getRoverData())) {
				urls.add(baseUrl + "&camera=PANCAM");
			}
			if (dto.getCameraMINITES() && !"curiosity".equalsIgnoreCase(dto.getRoverData())) {
				urls.add(baseUrl + "&camera=MINITES");
			}
		} catch (NullPointerException e) {
			System.out.println("get CamURLs Null Pointer Error");
		}
		
		return urls;
	}


	public Map<String, List<String>> getValidCameras() {
		return validCameras;
	}
	
	
	
	
}
