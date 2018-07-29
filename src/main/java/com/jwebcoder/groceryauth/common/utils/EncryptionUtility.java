package com.jwebcoder.groceryauth.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Jason on 17/10/2017.
 */
public class EncryptionUtility {

    public static String encrypt4MD5(String in) {
        return DigestUtils.md5Hex(in);
    }

}
