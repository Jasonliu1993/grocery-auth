package com.jwebcoder.groceryauth.common.utils;

import java.util.UUID;

public class TokenUtility {

    public static String newToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
