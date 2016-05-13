# ehcache-jsr107-spring


Building the application:
-This application can be built using maven 3.2 or above.  Make sure you are in the project root directory "ehcache3-jsr107-spring", or if you renamed it then it's the directory with the pom.xml file.  Now from the command line type:
mvn clean install

Running the application:
-Once again use maven to run this application, and you must be in the project root directory. From the command line type:
mvn spring-boot:run

What is the application url?
-The url template is http://localhost:8080/person/{ssn} where {ssn} should be replaced by an actual number, like the following:
http://localhost:8080/person/987654321


