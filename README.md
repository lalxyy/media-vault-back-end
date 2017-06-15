# Media Vault (Back end)

A Spring Boot Project (Maven).

## Setup

Create MySQL database 'mediavault' at localhost as below; or the program would fail.

```
jdbc:mysql://localhost/mediavault
Username: mediavault
Password: []mv0
```

## Compiling & Packaging

``` bash
# directly run without external tomcat
mvn spring-boot:run
```

Just use the given .war in the root.

Or create .war manually: `mvn package`.
