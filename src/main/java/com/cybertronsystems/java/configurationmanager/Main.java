/*
 * Purpose     :Testing Configuration manager
 * Date        :27/06/2017
 * Category    :Configurations
 */
package com.cybertronsystems.java.configurationmanager;

/**
 *
 * @author optimus
 */
public class Main {

    public static void main(String[] args) {

        ConfigurationManager.CONFIG_FILE_PATH = "/path/to/config.xml";
        //get the value for the specified key e.g <setting key="appId" value="644e1dd7-2a7f-18fb-b8ed-ed78c3f92c2b"/>
        String value = ConfigurationManager.getValueByKey("appId");
        System.out.println(value);

    }

}
