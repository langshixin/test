package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;


public class TestJob
//        extends JavaProcessor
{

//
//  @Override
//  public ProcessResult process(JobContext jobContext) {
//
//
//    System.out.println("hello schedulerx2.0");
//    return new ProcessResult(true);
//  }

    static final String fileName = "{{file_name}}";
    static final String sys_name = "{{sys_name}}";

    public static void main(String[] args) {
//        String str = "{\"info\":\"select count(1) from information_schema.columns where table_name = {{file_name}} and table_schema = {{sys_name}}\"} ";
//
//        str = str.replace(fileName, getReplacement("张三")).replace(sys_name,getReplacement("张三"));
//
//        System.out.println(str);
        Integer c = 87;
        Integer d = 101;
        Integer a =  87 / 2 * 100;
        System.out.println(a);
    }

    private static String getReplacement(String keyWorld) {
        return "'" + keyWorld + "'";
    }

}
