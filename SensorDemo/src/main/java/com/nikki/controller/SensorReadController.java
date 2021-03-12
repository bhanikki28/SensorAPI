package com.nikki.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ws.rs.QueryParam;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikki.dto.DeviceDTO;
import com.nikki.model.Device;
import com.nikki.model.DevicePredicates;

@RestController
public class SensorReadController {

	final static Logger logger = Logger.getLogger(SensorReadController.class.getName());

	@Autowired
	private DeviceDTO devDTO;

	// http://localhost:8095/get/device?device_id=Lighting Section 2
	@RequestMapping("/get/device/id")
	public List<Device> getDeviceListByName(@QueryParam("id") String device_id) {
		logger.info("Getting Device by Id");
		List<Device> filteredDevList = devDTO.getDeviceList().stream()
				.filter(DevicePredicates.getPredicate("device_id", device_id)).collect(Collectors.toList());

		return filteredDevList;

	}

	// http://localhost:8095/get/device/id?device_id=Lighting Section
	// 2&sensor_name=ReactivePower
	@RequestMapping("/get/device")
	public List<Device> getDeviceListByNameAndSensor(@QueryParam("id") String device_id,
			@QueryParam("id") String sensor_name) {
		logger.info("Getting Device by Id and SensorName");

		List<Device> filteredDevList = devDTO.getDeviceList().stream()
				.filter(DevicePredicates.getDevByName(device_id).and(DevicePredicates.getDevBySensorName(sensor_name)))
				.collect(Collectors.toList());
		return filteredDevList;

	}

	/*
	 * @RequestMapping("/get/devices") public List<Device> getDeviceList() {
	 * logger.info("Getting Device by Id and SensorName"); Map<String,String>
	 * filterMap = new HashMap<>(); filterMap.put("device_id","_AHU1_MAIN");
	 * filterMap.put("sensor_name","FAN_STATUS"); ArrayList<String> keyList = new
	 * ArrayList<>(filterMap.keySet()); List<Device> tempList
	 * =devDTO.getDeviceList();
	 * logger.info("Device List ModelSize"+tempList.size());
	 * 
	 * for(String filterKey:keyList) {
	 * logger.info("Querying the filterlist based on key:"+filterKey);
	 * logger.info("Querying the filterlist based on value:"+filterMap.get(filterKey
	 * ));
	 * 
	 * tempList = tempList.stream()
	 * .filter(getPredicate(filterKey,filterMap.get(filterKey).toString()))
	 * .collect(Collectors.toList());
	 * logger.info("Temp List Size after applying filter{},size{}"+filterKey+":"+
	 * tempList.size());
	 * 
	 * } logger.info("Return List Size:"+tempList.size()); return tempList;
	 * 
	 * }
	 */

	@PostMapping(value = "/device/list", consumes = "application/json", produces = "application/json")
	public List<Device> showDevice(@RequestBody String filterString) {
		final JSONObject obj = new JSONObject(filterString);
		Map<String, String> filterMap = new HashMap<>();
		ArrayList<String> filterList = new ArrayList<>(obj.keySet());
		for (String key : filterList) {
			filterMap.put(key, obj.get(key).toString());
		}
		ArrayList<String> keyList = new ArrayList<>(filterMap.keySet());
		List<Device> deviceList = devDTO.getDeviceList();
		logger.info("Device List ModelSize" + deviceList.size());

		for (String filterKey : keyList) {
			logger.info("Querying the filterlist based on key:" + filterKey);
			logger.info("Querying the filterlist based on value:" + filterMap.get(filterKey));

			deviceList = deviceList.stream()
					.filter(DevicePredicates.getPredicate(filterKey, filterMap.get(filterKey).toString()))
					.collect(Collectors.toList());
			logger.info("Temp List Size after applying filter{},size{}" + filterKey + ":" + deviceList.size());
		}
		return deviceList;

	}

}
