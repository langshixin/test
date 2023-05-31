package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
@Slf4j
@Configuration
public class MyRedissonConfig {

    /**
     * 配置redisson集群
     * @return
     */
/*
    @Bean(destroyMethod = "shutdown")
    public RedissonClient getRedissonClient() {
        List<String> clusterNodes = redisConfigProperties.getCluster().getNodeAddresses();
        log.info("【Redisson 配置】：{}", redisConfigProperties);

        Config config = new Config();
        //对象编码选择纯字符串编码
        config.setCodec(StringCodec.INSTANCE);
        ClusterServersConfig clusterServersConfig = config.useClusterServers()
                .addNodeAddress(clusterNodes.toArray(new String[clusterNodes.size()]));
        //设置密码
        clusterServersConfig.setPassword(redisConfigProperties.getPassword());
        //redis连接心跳检测，防止一段时间过后，与redis的连接断开
        clusterServersConfig.setPingConnectionInterval(32000);
        return Redisson.create(config);
    }
*/

    /**
     * 单机配置
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown")
    RedissonClient singleRedisson() throws IOException {
        // 创建配置
        Config config = new Config();
        config.setCodec(StringCodec.INSTANCE);
        config.setTransportMode(TransportMode.NIO);
        SingleServerConfig singleServerConfig = config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setDatabase(0);

        return Redisson.create(config);
    }
}
