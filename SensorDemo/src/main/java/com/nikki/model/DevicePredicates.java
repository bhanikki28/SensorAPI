package com.nikki.model;

import java.util.function.Predicate;

public class DevicePredicates {
	
	public static Predicate<Device> getDevByName(String device_name){
		return dev -> dev.getDevice_name().equalsIgnoreCase(device_name);
	
	}
	
	public static Predicate<Device> getDevBySensorName(String sensor_name){
		return dev -> dev.getSensor_name().equalsIgnoreCase(sensor_name);
	}
	
	public static Predicate<Device> getDevBySenType(String sensor_type){
		return dev -> dev.getSensor_type().equalsIgnoreCase(sensor_type);
	}
	
	
	public static Predicate<Device> getDevById(String device_id){
		return dev -> dev.getDevice_id().equalsIgnoreCase(device_id);
	}
	
	public static Predicate<Device> getPredicate(String filterType,String filterValue) {
	    switch (filterType) {
	        case "device_name":
	            return DevicePredicates.getDevByName(filterValue);
	        case "sensor_name":
	        	return DevicePredicates.getDevBySensorName(filterValue);
	        case "device_id":
	            return DevicePredicates.getDevById(filterValue);
	        case "sensor_type":
	        	return DevicePredicates.getDevBySenType(filterValue);
	        default:
	            break;
	    }
	    return null;
	}


}
