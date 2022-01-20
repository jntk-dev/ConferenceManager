package com.jntk.conference.manager.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jntk.conference.manager.domain.ConferenceTalk;
import com.jntk.conference.manager.util.AppUtils;

public class ConferenceTalkService {

	public static List<ConferenceTalk> getConferenceTalks(){
		List<ConferenceTalk> talks = new ArrayList<>();
		
		int durCount = 0;
		
		List<String> confData = FileImportService.importConferenceData();
		if(confData != null && !confData.isEmpty()) {
			for(String line : confData) {
				String title = AppUtils.extractTitle(line);
				int duration = AppUtils.extractDuration(line);
				//Track
				int track = 1;
				durCount += duration;
				if(durCount >= AppUtils.MAX_TRACK_TIME_AVAILABLE) {
					track = 2;
				}
				talks.add(new ConferenceTalk(title, duration, track));
			}
		}
		return talks;
	}
	
	public static void displayTrack(List<ConferenceTalk> talks, int trackNumber) {
		Calendar cal = Calendar.getInstance();
				 cal.set(Calendar.HOUR_OF_DAY, 9);
				 cal.set(Calendar.MINUTE, 0);
		
		StringBuilder track = new StringBuilder("Track ").append(trackNumber).append("\n");
	   
		for(ConferenceTalk talk : talks) {
			if(talk.getTrackNumber() == trackNumber) {
				
				track.append(AppUtils.formatTime(cal)).append(" ");
				
				if(cal.get(Calendar.HOUR_OF_DAY) == 12){
					track.append("Lunch");
					cal.add(Calendar.HOUR_OF_DAY, 1);
					
				}else {
					track.append(talk.getTitle()).append(" ");
					if(talk.getDuration() > 5) {
						track.append(talk.getDuration()).append(AppUtils.CONST_DURATION_MINS);
					}else {
						track.append(AppUtils.CONST_LIGHTNING);
					}
					cal.add(Calendar.MINUTE, talk.getDuration());
				}
				track.append("\n");
			}
		}
		cal.set(Calendar.HOUR_OF_DAY, 17);
		cal.set(Calendar.MINUTE, 0);
		track.append(AppUtils.formatTime(cal)).append(" Networking Event");
		
		System.out.println(track.toString());
	}
	
	public static void displayTalks() {
		List<ConferenceTalk> talks = getConferenceTalks();
		displayTrack(talks, 1);
		displayTrack(talks, 2);
	}
}
