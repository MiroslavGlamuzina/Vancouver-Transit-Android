package com.example.mapview;

import com.google.android.gms.maps.model.LatLng;

public class Bus {
	String stopNo;
	String name;
	String bayNo;
	String city;
	LatLng latlng;
	String dir;
	String busno;
	String busname;

	public Bus(String busno, String busname, LatLng latlng) {
		setBusname(busname);
		setBusno(busno);
		setLatLng(latlng);
	}

	
	public LatLng getLatlng() {
		return latlng;
	}

	public void setLatlng(LatLng latlng) {
		this.latlng = latlng;
	}

	public String getBusno() {
		return busno;
	}

	public void setBusno(String busno) {
		this.busno = busno;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}
	
	
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setStopNo(String stopNo) {
		this.stopNo = stopNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBayNo(String bayNo) {
		this.bayNo = bayNo;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLatLng(LatLng latlng) {
		this.latlng = latlng;
	}

	public String getStopNo() {
		return stopNo;
	}

	public String getName() {
		return name;
	}

	public String getBayNo() {
		return bayNo;
	}

	public String getCity() {
		return city;
	}

	public LatLng getLatLng() {
		return latlng;
	}
}
