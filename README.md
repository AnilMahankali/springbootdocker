This is a sample springboot docker example.

prerequisites: Docker Windows needs to be installed and running in your system

Use the below commands from your terminal to build the project and deploy it into docker container.


Step 1: mvn clean install
Step 2: docker build -t springbootdocker .
Step 3: docker run -p 8080:8080 -t springbootdocker

From the browser user http://localhost:8080/demo/getMessage to see the message on your browser.


