export PROJECT_PATH=.
sudo chmod -R 755 .
#run the projects
nohup java -jar $PROJECT_PATH/config-server/target/config-server-1.0.0.jar &
echo "waiting for 20 second"
sleep 20
nohup java -jar $PROJECT_PATH/servicediscovery/target/servicediscovery-1.0.0.jar &

echo "waiting for 20 second"
sleep 20
nohup java -jar $PROJECT_PATH/apigateway/target/apigateway-1.0.0.jar &


nohup java -jar -Dserver.port=8081 $PROJECT_PATH/subject/target/subject-1.0.0.jar &

nohup java -jar -Dserver.port=8082 $PROJECT_PATH/teacher/target/teacher-1.0.0.jar &

nohup java -jar -Dserver.port=8083 $PROJECT_PATH/student-producer/target/student-producer-1.0.0.jar  &

nohup java -jar -Dserver.port=8084 $PROJECT_PATH/student-consumer/target/student-consumer-1.0.0.jar  &

nohup java -jar -Dserver.port=8085 $PROJECT_PATH/subject/target/subject-1.0.0.jar &

nohup java -jar -Dserver.port=8086 $PROJECT_PATH/teacher/target/teacher-1.0.0.jar &

nohup java -jar -Dserver.port=8087 $PROJECT_PATH/student-producer/target/student-producer-1.0.0.jar &

nohup java -jar -Dserver.port=8088 $PROJECT_PATH/student-consumer/target/student-consumer-1.0.0.jar &

echo "waiting for 30 second"
sleep 30
disown



