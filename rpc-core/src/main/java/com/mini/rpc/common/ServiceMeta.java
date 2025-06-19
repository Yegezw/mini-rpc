package com.mini.rpc.common;

import lombok.Data;

@Data
public class ServiceMeta {

    /**
     * 服务名
     */
    private String serviceName;

    /**
     * 版本
     */
    private String serviceVersion;

    /**
     * 地址
     */
    private String serviceAddr;

    /**
     * 端口
     */
    private int servicePort;

}
