export PROJECT_PATH=.
sudo chmod -R 755 .
#run the projects
nohup java -jar $PROJECT_PATH/config-server/target/config-server-1.0.0.jar &
nohup java -jar $PROJECT_PATH/servicediscovery/target/servicediscovery-1.0.0.jar &

disown



