package com.andisan86.e2etest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class handles properties file. A property can be obtained by its <b>key</b>.
 *
 * @author Andi Santoso
 */
public class PropertyFactory {
    private final Properties properties;
    protected final String PROP_FILE_LOC = "config.properties";

    /**
     * Constructor.
     */
    public PropertyFactory() {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE_LOC);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for properties file.
     *
     * @param key Property key.
     * @return Property value in String.
     */
    public String getValueString(String key) {
        return properties.getProperty(key);
    }

    /**
     * Getter for properties file.
     *
     * @param key Property key.
     * @return Property value in Boolean.
     */
    public Boolean getValueBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    /**
     * Getter for properties file.
     *
     * @param key Property key.
     * @return Property value in Integer.
     */
    public int getValueInteger(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}

