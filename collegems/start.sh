export PROJECT_PATH=.
mvn clean install
#run the projects
nohup java -jar $PROJECT_PATH/servicediscovery/target/servicediscovery-0.0.1-SNAPSHOT.jar &
disown
nohup java -jar $PROJECT_PATH/config-server/target/config-server-0.0.1-SNAPSHOT.jar &
disown


