package com.nikki.controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ws.rs.QueryParam;

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
		List<Device> filteredDevList = devDTO.getDeviceList().stream().filter(DevicePredicates.getDevById(device_id))
				.collect(Collectors.toList());
		return filteredDevList;

	}

	// http://localhost:8095/get/device/id?device_id=Lighting Section
	// 2&sensor_name=ReactivePower
	@RequestMapping("/get/device")
	public List<Device> getDeviceListByNameAndSensor(@QueryParam("id") String device_id,
			@QueryParam("id") String sensor_name) {
		logger.info("Getting Device by Id and SensorName");

		List<Device> filteredDevList = devDTO.getDeviceList().stream()
				.filter(DevicePredicates.getDevById(device_id).and(DevicePredicates.getDevBySensorName(sensor_name)))
				.collect(Collectors.toList());
		return filteredDevList;

	}

	@PostMapping(value = "/showDevice", consumes = "application/json", produces = "application/json")
	public void showDevice(@RequestBody Device device) {
		System.out.println(device);
	}

}
