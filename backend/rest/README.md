## About
The app runs with Java 25 with a PostgreSQL database.


## Run with Docker

Build & Run:
```
docker compose up --build
```
> **Note:**  The build process may take some time on the first run

Remove containers/volumes if you're having issues:
```
docker compose down -v
```

Build:
```
docker compose bulid
docker compose build --no-cache // use this option to force download and recreation of services
```

Run:
```
docker compose up
```

The server should be live at http://localhost:8080/

Go to http://localhost:8080/greeting. You should see the following:
```
{"id":1,"content":"Hello, World!"}
```

## Run with Maven

Run with maven:
```
./mvnw spring-boot:run
```

The server should be live at http://localhost:8080/

Go to http://localhost:8080/greeting. You should see the following:
```
{"id":1,"content":"Hello, World!"}
```


## References

Used Spring Guide to setup: https://spring.io/guides/gs/rest-service
Docker Setup with Java: https://docs.docker.com/guides/java/
