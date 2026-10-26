package org.queryforge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueryForgeTest {

    @Test
    @DisplayName("Engine metadata should be properly initialized")
    void testEngineInitializationAndMetadata() {
        QueryForge engine = new QueryForge();

        assertTrue(engine.isInitialized(), "Engine should be marked as initialized upon construction");
        assertEquals("QueryForge", engine.getName(), "Engine name should match 'QueryForge'");
        assertEquals("0.1.0-SNAPSHOT", engine.getVersion(), "Engine version should match '0.1.0-SNAPSHOT'");
    }
}
