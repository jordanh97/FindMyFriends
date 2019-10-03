package com.findmyfriends.alpha.generator;

import java.util.UUID;

public class IDGenerator {

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

}
