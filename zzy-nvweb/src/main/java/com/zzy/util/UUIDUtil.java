package com.zzy.util;

import java.util.UUID;

/**
 * Created by stt on 2018/4/30.
 */
public class UUIDUtil {

    /**
     * 无'-'的uuid
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
