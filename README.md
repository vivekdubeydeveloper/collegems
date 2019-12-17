# collegems
Prerequisite for project
1)JDK 1.8
2)Maven
3)Mysql 
4)Zookeeper(Should be running)
5)Kafka(Should be running)
6)Docker
7)GIT
8)Postman/Curl(One mandatory)
9)Internet Connection

Install Open JDK8 on Ubuntu
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install openjdk-8-jdk
if multiple jdk then run the below command 
sudo update-alternatives --config java
select no:<No>

Install Maven on ubuntu
sudo apt install maven
mvn -version


Install mysql server

sudo apt-get update
sudo apt-get install mysql-server
sudo ufw enable
sudo ufw allow mysql
sudo systemctl start mysql
sudo mysql

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'very_strong_password';
FLUSH PRIVILEGES;

I have tested this code on Ubuntu.

Steps:
1)Clone the project
git clone https://github.com/vivekdubeydeveloper/collegems.git
2)Run the database script college.sql
3)Run zookeeper and kafka
4)Go to collegems/collegems directory
5)run mvn clean install
6)Give permisson to start.sh,dockerimagebuilder.sh,dockerimagerunner.sh
chmod -R 755.
7)Run start.sh it will start all the microservices.
8)Use postman collection to test the microservices.
9)Kill all the java process of microservices
killall -9 java
10)Now run the dockerimagebuilder.sh,it will create docker image of all the microservices.
11)Run dockerimagerunner.sh,it will run all the docker images
12)Again test all the api using postman collection.




