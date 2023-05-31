package com.example.demo.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author langshixin
 * @date 2023/2/20
 */
@Configuration
//@EnableTransactionManagement
//@MapperScan("com.example.demo.mapper")
@Slf4j
public class MybatisPlusConfig {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedissonClient redissonClient;

    /**
     * 更换默认的idWorker
     */
    @PostConstruct
    public void changeIdWorker(){
        RLock lock = redissonClient.getLock(RedisKeyConstant.TMS_REDIS_LOCK_PREFIX + "id:worker");
        try{
            lock.lock();
            long workId = 0;
            long dataId;
            while(true){
                //redis中取值
                String workIdStr = stringRedisTemplate.opsForValue().get(RedisKeyConstant.TMS_WORK_INCREMENT);
                if(workIdStr != null){
                    workId = Long.parseLong(workIdStr);
                }
                //判断值
                dataId = stringRedisTemplate.opsForValue().increment(RedisKeyConstant.TMS_DATA_INCREMENT, 1);
                if(dataId > 30){
                    stringRedisTemplate.opsForValue().set(RedisKeyConstant.TMS_DATA_INCREMENT, String.valueOf(0L));
                    workId =stringRedisTemplate.opsForValue().increment(RedisKeyConstant.TMS_WORK_INCREMENT, 1);
                    if(workId > 30){
                        stringRedisTemplate.opsForValue().set(RedisKeyConstant.TMS_WORK_INCREMENT, String.valueOf(0));
                    }
                    continue;
                }
                break;
            }
            log.info("changeIdWorker workId:{},dataId:{}",workId,dataId);
            IdWorker.initSequence(workId,dataId);
        }finally{
            lock.unlock();
        }
    }
}
