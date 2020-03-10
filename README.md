# ALMA-API-Example-usage

## Introduction
The Library-system Alma from ExLibris offers some API-endpoint (see 
[Developers Network](https://developers.exlibrisgroup.com/alma/apis/)). 
Unit provides some applications and services that make use of those Alma-APIs.
In order to communicate with those Alma-APIs you need to provide an ```API Key```.
As long as Units applications and services are running on safespring-cloud, 
we will use Vault to handle those ```API Key``` 
(see vault-client project on [gitLab.bibsys.no](https://git.bibsys.no/infrastruktur/vault-client) for details).

This project is meant to give guidelines in form of example implementations to those API-endpoints and example use of 
them. Furthermore the project suggests logging via logback to set a standard logging-protocol for applications and 
services integrating with Alma-API.

## 