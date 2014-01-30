#!/bin/sh

# CR2 Please check, why does app deploy and start in case of broken build?
mvn install tomcat7:run-war
