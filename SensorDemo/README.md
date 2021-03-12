# SensorAPI

API Endpoint to filter by device id

eg : 	http://localhost:8095/get/device?device_id=Lighting Section 2

API Endpoint to filter by device id and sensor name

eg : 	http://localhost:8095/get/device?device_id=Lighting Section 2

http://localhost:8095/get/device/id?device_id=Lighting Section&sensor_name=ReactivePower


#Notes

Ingestion of data from CSV file (data.csv) is done on Spring Boot application startup
DeviceDTO implements InitializingBean will help in achieving this

#Controller
SensorReadController exposes below endpoints for the consumer to filter devices

1. /get/device/id?device_id=<>
2. /get/device?device_id=Lighting Section&sensor_name=ReactivePower