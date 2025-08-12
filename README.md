# Quarkus

## MEAP - Manning Early Access Program
A book can take a year or more to write, so how do you learn that hot new
technology today? The answer is MEAP, the Manning Early Access Program. In
MEAP, you read a book chapter-by-chapter while it's being written and get the final eBook as soon as it's finished.

---
### Generating Quarkus application
1. Generating Quarkus application using command line and maven plugin
```bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
  -DprojectGroupId=org.rest.number.ms \
  -DprojectArtifactId=number-ms \
  -DclassName="org.rest.number.ms.NumberResource" \
  -Dpath="/v1/numbers" \
  -Dextensions="resteasy-jsonb,smallrype-openapi"
```
2. Generating Quarkus application using Quarkus CLI

Quarkus CLI provides similar approaches for both maven and gradle
```bash
$ quarkus create app org.acme:quarkus-in-action -P 3.5.0
➥ --extension resteasy-reactive
```
3. Generating Quarkus application using code.quarkus.io

GUI where you can create quarkus applications

---
### Dependencies with usages

| Dependency                       | Usage                                                                                                              |
|----------------------------------|--------------------------------------------------------------------------------------------------------------------|
| quarkus-arc                      | Implicitly added for providing dependency injection                                                                |
| quarkus-config-yaml              | Support for yaml based configurational files                                                                       |
| quarkus-smallrye-openapi         | API documentation                                                                                                  |
| quarkus-smallrye-falut-tolerance | Fault tolerance and fallback for external calls                                                                    |
| quarkus-smallrye-graphql-client  | Consuming from a graphql service                                                                                   |
| quarkus-rest-client              | Registering external REST clients                                                                                  |
| quarkus-rest-client-jsonb        | Processing and converting response data into JSON format (Serialization/Deserialization)                           |
| quarkus-freemarker               | Provides freemarker templates for email body                                                                       |
| quarkus-mailer                   | Provides emailing capabalities                                                                                     
| quarkus-rest                     | Building HTTP REST APIs with reactive performance                                                                  |
| quarkus-rest-jsonb               | Processing and converting both request and response data into JSON format (Serialization/Deserialization) reactive |
| quarkus-resteasy                 | Building HTTP REST APIs                                                                                            |
| quarkus-resteasy-jsonb           | Processing and converting both request and response data into JSON format (Serialization/Deserialization)          |
| quarkus-agroal                   | Hikari Configurations                                                                                              |
| quarkus-hibernate-orm-panache    | Entity Configurations                                                                                              |
| quarkus-jdbc-mysql               | mySQL Driver                                                                                                       |
| quarkus-jdbc-postgres            | postgres Driver                                                                                                    |
| quarkus-jdbc-h2                  | H2 Driver                                                                                                          |
| wiremock                         | Stubs for testing external calls                                                                                   |
| quarkus-junit5                   | Writing unit test using Junit5                                                                                     |
| quarkus-junit5-mockito           | Writing unit test using Junit5 and Mockito                                                                         |
| rest-assured                     | Writing IT test                                                                                                    |

---

### Quarkus BOM (Bill of Materials)

The BOM is always versioned per a specific Quarkus platform
version and contains all platform extensions together with other useful artifacts (e.g., for
testing) with the correct versions. Using the BOM also ensures that all utilized extensions
are guaranteed to work together.



---
### Packaging and Structures

Quarkus using small footprints while generating JAR files when below command is executed
```bash
mvn clean install
``` 
- Executable jar will be placed in /quarkus-app folder where the dependencies and other resources are separated and the jar contents can be viewed with below command
```bash
jar tf quarkus-run.jar
```
- The standard maven jar output will be ommitted on to target folder which is no executable. However you can build a uber jar if needed using below command
```bash
mvn clean install -Dquarkus-package-type=uber-jar
```
The above configuration can also be specified on the properties file
```bash
quarkus.package.type=uber-jar
```
---
### Running a Quarkus application

1. Using command line
```bash
./mvnw quarkus:dev
```
Execute the below command to re-generate and load maven wrapper files.
```bash
mvn -N io.takari:maven:wrapper
```
2. Using Quarkus CLI
```bash
quarkus dev
```
---
### Building a Native Executable

Native binary images that are platform dependent however leaves lesser footprints and takes some time for getting created using below command

We use GraalVM for creating such native binaries

```bash
./mvnw package -Pnative
```
### Plugins with usages

|Plugins|Usage|
|-------|-----|
|quarkus-maven-plugin|Build, Launch Dev Mode, Create New Project, List add and remove extensions|
|quarkus-compiler-plugin|Compilation purposes|
|maven-surefile-plugin|Running and Reporting Unit Tests|
|maven-failsafe-plugin|Executing IT tests during build phase|
