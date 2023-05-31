package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.entity.Combination;
import com.example.demo.mapper.CombinationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @author langshixin
 * @date 2022/12/29
 */
@RestController
public class HelloController {

//    public static void main(String[] args) {
//        Double doubleValue = new Double(1.2);
//        System.out.println(doubleValue.compareTo(new Double(1)) == 0);
//        System.out.println(doubleValue.compareTo(new Double(1)));
//
//    }
    @Autowired
    private CombinationMapper combinationMapper;

    @GetMapping("/hello")
    public String helloController(){
        System.out.println("begin----: "+System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
//            new Thread(()-> System.out.println(IdWorker.getIdStr())).start();
            System.out.println(IdWorker.getIdStr());
        }
        System.out.println("end----: "+System.currentTimeMillis());
        return "Hello";
    }
}
