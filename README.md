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

