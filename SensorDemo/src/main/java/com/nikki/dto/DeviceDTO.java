package com.nikki.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.nikki.model.Device;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Component
public class DeviceDTO implements InitializingBean {
	final static Logger logger = Logger.getLogger(DeviceDTO.class.getName());

	
	private List<Device> deviceList;
	
	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}


	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public List<Device> getDevices() throws FileNotFoundException, IOException, ParseException {
		logger.info("Ingestion of CSV Data starts here...");
		ClassLoader classLoader = getClass().getClassLoader();

		File file = new File(classLoader.getResource("data.csv").getFile());

		FileReader fileReader = new FileReader(file);
		CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
		List<String[]> allData = csvReader.readAll();
		deviceList = new ArrayList<Device>();

		for (String[] row : allData) {

			Device record = new Device();

			record.setDevice_id(row[0]);
			record.setDevice_name(row[1]);
			record.setSensor_name(row[2]);
			record.setSensor_type(row[3]);
			//record.setSensor_tags(new Array());
			//record.setSensor_created_dt(new Date(row[5]));

			deviceList.add(record);
		}
		logger.info("Ingestion of CSV Data completed and available for APIs to consume");

		return deviceList;
		
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Populating the Device List");
		deviceList = getDevices();
	}

}
