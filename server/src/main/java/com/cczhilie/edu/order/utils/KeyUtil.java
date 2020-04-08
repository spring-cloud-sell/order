package com.cczhilie.edu.order.utils;

import java.util.Random;

/**
 * @author: GZC
 * @create: 2020-04-07 19:43
 * @description:
 **/
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
