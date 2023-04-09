package acme.oddo.dsfact.config;

import org.testcontainers.containers.OracleContainer;

public class OracleTestContainer extends OracleContainer {

    public static final String DB_CONNECTION_URL = "DB_URL";
    public static final String DB_USERNAME = "DB_USERNAME";
    public static final String DB_PASSWORD = "DB_PASSWORD";
    private static final String IMAGE_VERSION = "gvenzl/oracle-xe:21-slim-faststart";
    private static OracleTestContainer container;
    private OracleTestContainer() {
        super(IMAGE_VERSION);
    }
    public static OracleTestContainer getInstance(String initScriptPath) {
        if (container == null) {
            container = new OracleTestContainer();
            container.withInitScript(initScriptPath);
            container.start();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty(DB_CONNECTION_URL, container.getJdbcUrl());
        System.setProperty(DB_USERNAME, container.getUsername());
        System.setProperty(DB_PASSWORD, container.getPassword());
    }
}
