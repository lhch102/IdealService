package com.ideal.rest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator on 2017/10/30.
 */
public class DateTest {

    @Test
    public void test1(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //输入毫秒数，转化为日期，用simpleDateFormat  +  Date 方法；
        /**
         * 直接用SimpleDateFormat格式化 Date对象，即可得到相应格式的日期 字符串。
         */

        Date date2 = new Date();
        date2.setTime(1509357965000L);
        System.out.println(simpleDateFormat.format(date2));
    }
}
