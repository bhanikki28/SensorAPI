package com.nikki.model;

import java.util.function.Predicate;

public class DevicePredicates {
	
	public static Predicate<Device> getDevById(String device_id){
		return dev -> dev.getDevice_name().equalsIgnoreCase(device_id);
	
	}
	
	public static Predicate<Device> getDevBySensorName(String sensor_name){
		return dev -> dev.getSensor_name().equalsIgnoreCase(sensor_name);
	}

}
