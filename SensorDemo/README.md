# SensorAPI

Run the application using command : mvn spring-boot:run

API Endpoint to filter by device id

eg : 	http://localhost:8095/get/device/id?device_id=_AHU1_MAIN

API Endpoint to filter by device id and sensor name

eg : 	http://localhost:8095/get/device?device_id=_AHU1_MAIN&sensor_name=FAN_STATUS



#Notes

Ingestion of data from CSV file (data.csv) is done on Spring Boot application startup
DeviceDTO implements InitializingBean will help in achieving this

#TechStack

1. Java8 (Streams,Filters,Predicates)
2. SpringBoot
