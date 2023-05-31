package com.example.demo.mapper;

/**
 * @author langshixin
 * @date 2022/8/31
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Combination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface CombinationMapper extends BaseMapper<Combination> {


    List<Combination> selectList();

    void updateById(@Param("id") String id, @Param("haveMg")String haveMg, @Param("haveWj")String haveWj, @Param("haveRed")String haveRed);

}
