# Start with a base image containing Java runtime
FROM amazoncorretto:21

# Add Maintainer Info
LABEL maintainer="pires"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9080 available to the world outside this container
EXPOSE 9080

# The application's jar file
ARG JAR_FILE=build/libs/ecommerce-2-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} ecommerce-service.jar

# Once the container starts, run below command - Run the jar file  
CMD ["java","-jar","/ecommerce-service.jar"]
