package com.nikki.model;

import java.lang.reflect.Array;
import java.util.Date;

public class Device {

	private String device_id;
	
	private String device_name;
	
	private String sensor_name;
	
	private String sensor_type;

	private Array sensor_tags;

	
	private Date sensor_reading_dt;
	
	private Date sensor_created_dt;
	
	private Date sensor_updated_dt;
	
	private String unit;

	private String sensor_readin_value;


	
	public String getDevice_id() {
		return device_id;
	}


	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}


	public String getDevice_name() {
		return device_name;
	}


	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}


	public String getSensor_name() {
		return sensor_name;
	}


	public void setSensor_name(String sensor_name) {
		this.sensor_name = sensor_name;
	}


	public String getSensor_type() {
		return sensor_type;
	}


	public void setSensor_type(String sensor_type) {
		this.sensor_type = sensor_type;
	}


	public Array getSensor_tags() {
		return sensor_tags;
	}


	public void setSensor_tags(Array sensor_tags) {
		this.sensor_tags = sensor_tags;
	}


	public Date getSensor_reading_dt() {
		return sensor_reading_dt;
	}


	public void setSensor_reading_dt(Date sensor_reading_dt) {
		this.sensor_reading_dt = sensor_reading_dt;
	}


	public Date getSensor_created_dt() {
		return sensor_created_dt;
	}


	public void setSensor_created_dt(Date sensor_created_dt) {
		this.sensor_created_dt = sensor_created_dt;
	}


	public Date getSensor_updated_dt() {
		return sensor_updated_dt;
	}


	public void setSensor_updated_dt(Date sensor_updated_dt) {
		this.sensor_updated_dt = sensor_updated_dt;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getSensor_readin_value() {
		return sensor_readin_value;
	}


	public void setSensor_readin_value(String sensor_readin_value) {
		this.sensor_readin_value = sensor_readin_value;
	}


	@Override
	public String toString() {
		return "Device [device_id=" + device_id + ", device_name=" + device_name + ", sensor_name=" + sensor_name
				+ ", sensor_type=" + sensor_type + ", sensor_tags=" + sensor_tags + ", sensor_reading_dt="
				+ sensor_reading_dt + ", sensor_created_dt=" + sensor_created_dt + ", sensor_updated_dt="
				+ sensor_updated_dt + ", unit=" + unit + ", sensor_readin_value=" + sensor_readin_value + "]";
	}


}
