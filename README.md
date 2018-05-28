# cnam.nsy209.selServices.restService
CNAM NSY209 project 2018 - REST Server for SEL Services

## Installation
### Pre-requisites
* First install [cnam.nsy209.selServices.server](https://github.com/lavive/cnam.nsy209.selServices.server)
* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed
* [Eclipse Oxygen](http://www.eclipse.org/downloads/eclipse-packages/) for JavaEE developper or more installed
* Maven pluggin installed
* Clone this project
### Process
* Clone this project in zip file and extract
* 'new maven project' in Eclipse
* skip archetype selection
* groupId: ***cnam.nsy209***, artifactId: ***selServices.restService*** and finish
* copy extracted project files in Eclipse project
* Go to 'run Configurations' -> right click on 'Maven Build' -> 'new'
* At the 'Main' tab fill 'Goals' as **exec:exec**
* Click on 'run'
* The server starts
* You can stop it by pressing 'Enter'

