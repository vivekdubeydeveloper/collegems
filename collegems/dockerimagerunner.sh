docker run -d -p 8888:8888 config-server
echo "waiting for 20 second"
sleep 20
docker run -d -p 8761:8761 servicediscovery
echo "waiting for 20 second"
sleep 20
docker run -d -p 8080:8080 apigateway
docker run -d -p 8084:8084 student-consumer
docker run -d -p 8083:8083 student-producer
docker run -d -p 8081:8081 subject
docker run -d -p 8082:8082 teacher