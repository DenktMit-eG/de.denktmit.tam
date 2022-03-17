package de.denktmit.tam.business.service.impl;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDService {

    public static UUID getNewUUID() {
        return UUID.randomUUID();
    }
}
