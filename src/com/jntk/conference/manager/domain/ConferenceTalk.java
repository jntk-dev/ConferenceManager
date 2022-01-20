package com.jntk.conference.manager.domain;

public class ConferenceTalk {
	private String title;
	private int duration;
	private int trackNumber;
	
	public ConferenceTalk() {
		super();
	}
	
	public ConferenceTalk(String title, int duration, int trackNumber) {
		super();
		this.title = title;
		this.duration = duration;
		this.trackNumber = trackNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}
}
