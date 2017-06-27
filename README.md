# ConfigurationManager
Read external xml-based settings file using java SAX Parser package

## Main Purpose
Maintaining an external xml file with configuration settings for a java application. Thus constant strings and application specific values such as appId, passwords, default texts e.t.c are defined in the file & recompiling a java project for such trivial changes becomes unnecessary. 

### Usage
Inside the calling class
```java
//set the path to the external xml file.
ConfigurationManager.CONFIG_FILE_PATH = "/path/to/config.xml";
//get the value for the specified configuration using its associated key e.g <setting key="appId" value="644e1dd7"/>
String value = ConfigurationManager.getValueByKey("appId");
//use the returned value
if(value!=null)
{
  //do anything fancy with the result
  System.out.println(value);
}
```
### Sample xml configuration file
The xml file defines set of key value "settings" pair which the ConfigurationManager class searches using the key attribute to return the value for that configuration.
Below is the format of such a file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
Purpose     :Project configuration settings
Date        :27/06/2017
Category    :Configuration
-->
<config>
    <setting key="appId" value="644e1dd7-2a7f-18fb-b8ed-ed78c3f92c2b"/>
    <setting key="email" value="yourmail@mail.com"/>
    <setting key="dbUser" value="root"/>
    <setting key="ftpIp" value="127.0.0.1"/>
    <setting key="serviceEndpoint" value="http://127.0.0.1/api/v1/"/>
    <setting key="password" value="password"/>
    <setting key="emailPort" value="25"/>    
</config>
```
