package com.mini.rpc.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rpc")
public class RpcProperties {

    /**
     * 服务端口
     */
    private int servicePort;

    /**
     * 注册中心地址
     */
    private String registryAddr;

    /**
     * 注册中心类型
     */
    private String registryType;

}
