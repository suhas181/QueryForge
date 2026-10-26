package org.queryforge;

/**
 * Entry point and metadata for the QueryForge database engine.
 */
public class QueryForge {

    private static final String ENGINE_NAME = "QueryForge";
    private static final String ENGINE_VERSION = "0.1.0-SNAPSHOT";

    private final boolean initialized;

    public QueryForge() {
        this.initialized = true;
    }

    public String getName() {
        return ENGINE_NAME;
    }

    public String getVersion() {
        return ENGINE_VERSION;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public static void main(String[] args) {
        QueryForge engine = new QueryForge();
        System.out.println("Starting " + engine.getName() + " v" + engine.getVersion() + "...");
        System.out.println("Engine initialized successfully.");
    }
}
