export PROJECT_PATH=.
#run the projects
nohup java -jar $PROJECT_PATH/config-server/target/config-server-0.0.1-SNAPSHOT.jar &
nohup java -jar $PROJECT_PATH/servicediscovery/target/servicediscovery-0.0.1-SNAPSHOT.jar &

disown



