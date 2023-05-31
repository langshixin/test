package com.example.demo.mapper;

import com.example.demo.entity.CourseStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author langshixin
 * @date 2022/8/31
 */
@Mapper
public interface CourseStorageMapper{


    List<CourseStorage> selectList();

    void updateById(@Param("id") String id, @Param("haveMg")String haveMg, @Param("haveWj")String haveWj, @Param("haveRed")String haveRed);
}
