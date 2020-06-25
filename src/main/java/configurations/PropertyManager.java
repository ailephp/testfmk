package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    static final String PROP_FILE="/src/test/resources/configuration.properties";

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+PROP_FILE;

    private static String browser;
    private static String url;

    private static String osPlatform = System.getProperty("os.name");

    private PropertyManager()  { }

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Get properties from configuration.properties
        url = prop.getProperty("url");
        browser = prop.getProperty("browser");

    }

    public String getURL () { return url; }

    public String getBrowser() {
        return browser;
    }

    public String getOsPlatform() { return osPlatform; }

}
