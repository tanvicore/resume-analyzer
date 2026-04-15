# Use official OpenJDK image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy all project files into container
COPY . .

# Give permission to Maven wrapper
RUN chmod +x mvnw

# Build the project (skip tests for faster deploy)
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot application
CMD ["sh", "-c", "java -jar target/*.jar"]