/*
 * Purpose     :Handle xml based configuration files 
 * Date        :27/06/2017
 * Category    :Configurations 
 */
package com.cybertronsystems.java.configurationmanager;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author optimus
 */
public class ConfigurationManager {

    //setting file path, to be set from the class calling this Manager
    public static String CONFIG_FILE_PATH = null;
    //maintains the value to be returned to the calling class
    private static String VALUE = null;
    //<setting/>
    private static final String SETTING_ELEMENT = "setting";
    //<setting key=""/>
    private static final String KEY_ATTRIBUTE = "key";
    //<setting value=""/>
    private static final String VALUE_ATTRIBUTE = "value";

    /**
     * Get the value for the key specified in the settings
     *
     * @param key
     * @return
     */
    public static String getValueByKey(String key) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler;
            handler = new DefaultHandler() {

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equals(SETTING_ELEMENT)) {
                        if (attributes.getValue(KEY_ATTRIBUTE).equals(key)) {
                            VALUE = attributes.getValue(VALUE_ATTRIBUTE);

                        }

                    }

                }

                public void endElement(String uri, String localName, String qName) throws SAXException {

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                }

            };
            if (CONFIG_FILE_PATH == null) {
                return null;

            } else {
                File configFile = new File(CONFIG_FILE_PATH);
                if (configFile.exists()) {
                    saxParser.parse(CONFIG_FILE_PATH, handler);
                    return VALUE;

                } else {
                    return null;

                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
