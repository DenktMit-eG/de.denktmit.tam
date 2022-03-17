package de.denktmit.tam.business.service.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UUIDServiceTest {

    final String uuidV4RegexPattern = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Test
    void getNewUUIDmatchesUUIDv4PatternTest() {
        String uuid = UUIDService.getNewUUID().toString();
        assertTrue(uuid.matches(uuidV4RegexPattern));
    }
}
