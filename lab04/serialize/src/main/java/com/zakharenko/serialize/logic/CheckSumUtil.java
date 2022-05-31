package com.zakharenko.serialize.logic;

import org.apache.commons.codec.digest.DigestUtils;


public class CheckSumUtil {

    public static String findCheckSum(Object obj){
        return DigestUtils.md5Hex(String.valueOf(obj));
    }
}
