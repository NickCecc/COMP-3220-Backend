## Running the JAVA Backend

The JAVA backend requires Maven to be installed as the JAVA package manager. [Click this link for instructions to install Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

In the root directory, enter the command

```bash
mvn package
```

This should create a target directory containing our compiled main jar.

To run this jar file, enter the command

```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```
