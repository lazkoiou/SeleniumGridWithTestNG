# SeleniumGridWithTestNG
A sample test that simply opens the browser and navigates to "gmail.com" is run in both Chrome and Firefox in parallel with Selenium Grid.

This project has been made using docker for the hubs and nodes of Selenium Grid

# Stack: 
Java 8, Maven, Selenium Grid, TestNG, Docker

# Steps to setup the project

1. Run docker and pull the images from docker.hub: <br/>
  <b><i> docker pull selenium/hub </b></i> <br/>
  <b><i> docker pull selenium/node-firefox </b></i> <br/>
  <b><i> docker pull selenium/node-chrome </b></i> <br/>
  <b><i> docker pull selenium/node-firefox-debug </b></i> <br/>
  <b><i> docker pull selenium/node-chrome-debug </b></i> <br/>
  
   Check that you successfully pulled the images: <br/>
  <b><i> docker images </b></i> <br/>
  
2. Run the images: <br/>
  <b><i> docker run -d -p 4444:4444 --name selenium-hub selenium/hub </b></i> <br/>
  <b><i> docker run -d --link selenium-hub:hub selenium/node-chrome </b></i> <br/>
  <b><i> docker run -d --link selenium-hub:hub selenium/node-firefox </b></i> <br/>
  <b><i> docker run -d -p 32771:5900 --link selenium-hub:hub selenium/node-chrome-debug </b></i> <br/>
  <b><i> docker run -d -p 32772:5900 --link selenium-hub:hub selenium/node-firefox-debug </b></i> <br/>
 
   Verify that the containers started running with: <br/>
  <b><i> docker ps -a </b></i> <br/>
  
   Verify that the Selenium Hub has started successfully at localhost:4444/grid/console <br/>

3. Download VNC viewer from their official site: https://www.realvnc.com/en/connect/download/viewer/ <br/>
   Run it <br/>
   Type the hub URL and the port number of each debug mode and click on the connect button <br/> 
   (for Chrome browser: localhost:32771, default password: secret) <br/>
   (for Firefox browser: localhost:32772, default password: secret) <br/>
 
4. Run tests with the command <br/>
  <b><i> mvn clean test </b></i>
 
