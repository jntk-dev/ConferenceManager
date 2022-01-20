package com.jntk.conference.manager.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileImportService {
	private static final String DATA_FILE_PATH = "c:/conference_talks.txt";
	
	public static List<String> importConferenceData(){
		List<String> lines = new ArrayList<>();
		
		try{
			 lines = Files.readAllLines(Paths.get(DATA_FILE_PATH), StandardCharsets.UTF_8);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lines;
	}
		
	

	


	
	
	
	
	
	
	
}
