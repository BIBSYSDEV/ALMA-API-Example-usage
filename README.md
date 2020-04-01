# ALMA-API-Example-usage

## Introduction
The Library-system Alma from ExLibris offers some API-endpoint (see 
[Developers Network](https://developers.exlibrisgroup.com/alma/apis/)). 
Unit provides some applications and services that make use of those Alma-APIs.
In order to communicate with those Alma-APIs you need to provide an ```API Key```.
As long as Units applications and services are running on safespring-cloud, 
Vault is used to handle ```API Key```.

This project is meant to give guidelines in form of example implementations to those API-endpoints and example use of 
them. Furthermore the project suggests logging via logback to set a standard logging-protocol for applications and 
services integrating with Alma-API.

## How to build
The project uses gradle. Make sure you have the latest gradle version:
```
    curl -s "https://get.sdkman.io" | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    sdk install gradle
    gradle wrapper
```
If you have [java 11](https://openjdk.java.net/install/) installed run ```gradle build```.
The following plugins will be run automatically: 
* [checkstyle](https://docs.gradle.org/current/userguide/checkstyle_plugin.html) for java file style checks
* [PMD](https://docs.gradle.org/current/userguide/pmd_plugin.html) for java code style checks
* [JaCoCo](https://docs.gradle.org/current/userguide/jacoco_plugin.html) for test coverage

Those plugins generate reports from those checks in ``/build/reports/`` and wont let you build successful.

The project uses Travis CI to check if the code compiles.

## Package structure
| API endpoint | package name | gives access to |
|--------------|--------------|-----------------|
| Acquisitions | no.unit.alma.acquisitions.* | POLines, Vendors |
| Analytics | no.unit.alma.analytics.* | Alma reports |
| Bibliographic Records and Inventory | no.unit.alma.bibs.* | Bibs, Holdings, Items |
| Configuration and Administration | no.unit.alma.configurations.* | Alma configurations |
| Resource Sharing Partners | no.unit.alma.partners.* | Partners |
| Users and Fulfillment | no.unit.alma.users.* | Users |

https://developers.exlibrisgroup.com/console/

## How to build with maven?

#### 1. maven-jaxb2-plugin in pom.xml
(You will need a <execution>`-section for every package you want to generate)
```
            <plugin>
                <groupId>org.jvnet.jaxb2.maven2</groupId>
                <artifactId>maven-jaxb2-plugin</artifactId>
                <version>0.14.0</version>
                <executions>
                    <execution>
                        <id>generate-Alma</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <forceRegenerate>true</forceRegenerate>
                            <schemaLanguage>AUTODETECT</schemaLanguage>
                            <schemas>
                                <schema>
                                    <url>
                                        https://developers.exlibrisgroup.com/wp-content/uploads/alma/xsd/web_service_result.xsd
                                    </url>
                                </schema>
                                <schema>
                                    <url>
                                        https://developers.exlibrisgroup.com/wp-content/uploads/alma/xsd/rest_partners.xsd
                                    </url>
                                </schema>
                            </schemas>
                            <bindingDirectory>src/main/resources</bindingDirectory>
                            <bindingIncludes>
                                <include>*.xjb</include>
                            </bindingIncludes>
                            <generatePackage>no.unit.alma.partners</generatePackage>
                            <accessExternalDTD>https</accessExternalDTD>
                            <disableXmlSecurity>true</disableXmlSecurity>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```
#### 2. add dependencies
```
        <dependency>
            <groupId>org.glassfish.jersey.inject</groupId>
            <artifactId>jersey-hk2</artifactId>
            <version>2.30.1</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-moxy</artifactId>
        <version>2.30.1</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-jaxb</artifactId>
            <version>2.30.1</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-jackson</artifactId>
            <version>2.30.1</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.core</groupId>
            <artifactId>jersey-client</artifactId>
            <version>2.30.1</version>
        </dependency>
        <dependency>
            <groupId>com.typesafe</groupId>
            <artifactId>config</artifactId>
            <version>1.4.0</version>
        </dependency>
        <dependency>
            <groupId>javax.ws.rs</groupId>
            <artifactId>javax.ws.rs-api</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>no.bibsys</groupId>
            <artifactId>vault-client</artifactId>
            <version>1.0.8</version>
        </dependency>
```
#### 3. xjb-binding-file

to make sure the @XmlRootElement annotation is generated as well. (put that file in f.eks. 
`/src/main/resources/` or whereever you references it from your pom-plugin-section). You may need a matching number of 
xjb-files for each package (here I am not sure since we are using `<xjb:globalBindings>` and that can only be used once.)
```
<?xml version="1.0"?>
<jxb:bindings version="1.0" xmlns:jxb="http://java.sun.com/xml/ns/jaxb" xmlns:xjc="http://java.sun.com/xml/ns/jaxb/xjc" jxb:extensionBindingPrefixes="xjc" xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <jxb:bindings schemaLocation="https://developers.exlibrisgroup.com/wp-content/uploads/alma/xsd/rest_partners.xsd" node="/xs:schema">
        <jxb:globalBindings>
            <xjc:simple/>
        </jxb:globalBindings>
    </jxb:bindings>
</jxb:bindings>
```