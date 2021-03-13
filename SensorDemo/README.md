# SensorAPI

Run the application using command : mvn spring-boot:run


## Test

API Endpoint to filter by device id

         eg : 	http://localhost:8095/get/device/id?device_id=_AHU1_MAIN

API Endpoint to filter by device id and sensor name

         eg : 	http://localhost:8095/get/device?device_id=_AHU1_MAIN&sensor_name=FAN_STATUS


Querying based on one or more filter through POST API Call

URL :http://localhost:8095/device/list

Method : POST

	Sample Payload_1:
	{
	    "sensor_type":"NUMBER"
	}

	Sample Payload_2:
	
	{
	    "sensor_name":"FAN_STATUS",
	    "sensor_type":"BOOLEAN"
	}

	Sample Payload_3:
	
	{
	    "device_name":"_AHU1_MAIN",
	    "sensor_name":"FAN_STATUS",
	    "sensor_type":"BOOLEAN"
	}



#Notes

Ingestion of data from CSV file (data.csv) is done on Spring Boot application startup
DeviceDTO implements InitializingBean will help in achieving this


#TechStack

1. Java8 (Streams,Filters,Predicates)
2. SpringBoot
