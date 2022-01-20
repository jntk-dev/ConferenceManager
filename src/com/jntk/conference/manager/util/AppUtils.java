package com.jntk.conference.manager.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jntk.conference.manager.domain.ConferenceTalk;

public class AppUtils {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
	
	public static final int MAX_TRACK_TIME_AVAILABLE = 6*60;// 360 mins (6 hours)
	
	public static final String CONST_LIGHTNING	   = "lightning";// = 5min
	public static final String CONST_DURATION_MINS = "min";  
	
	
	public static List<ConferenceTalk> sortConferenceTalksByTrack(List<ConferenceTalk> talks) {
		Collections.sort(talks, new Comparator<ConferenceTalk>() {
			@Override
			public int compare(ConferenceTalk talk1, ConferenceTalk talk2) {
				if(talk1.getTrackNumber() < talk2.getTrackNumber()) {
					return -1;
				} else if(talk1.getTrackNumber() > talk2.getTrackNumber()) {
			    	return 1;
			    }else {
			    	return 0;
			    }
			}
	    });
		
		return talks;
	}
	
	public static String formatTime(Calendar cal) {
	    return sdf.format(cal.getTime()).toUpperCase();
	}
	
	//Return trimmed string or null
	public static String getValidatedString(String val) {
		return val != null && !val.trim().isEmpty() ? val.trim() : null;
	}
	
	public static Long getAsLong(String val) {
		Long result = null;
		
		try {
			result = Long.parseLong(getValidatedString(val));
		}catch(Exception e) {
			return null;
		}
		
		return result;
	}
	
	public static String extractTitle(String line) {
		String title = getValidatedString(line);
		
		if(title != null) {
			try {
				title = title.substring(0, title.lastIndexOf(" ")).trim();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
			
		return title;
	}
	
	/* Return duration in mins
	 * 03:00PM Ruby on Rails Legacy App Maintenance 60min
		04:00PM Rails for Python Developers lightning
	 * */
	public static int extractDuration(String line) {
		int duration = 0;
		
		String strDur = getValidatedString(line);
		if(strDur != null) {
			strDur = strDur.substring(strDur.lastIndexOf(" ")).trim();
			
			if(strDur.equalsIgnoreCase(CONST_LIGHTNING)) {
				duration = 5;
			}else {
				strDur = strDur.substring(0, strDur.indexOf(CONST_DURATION_MINS));
				duration = getAsLong(strDur).intValue();
			}
			
		}
		
		return duration;
	}
	
}
