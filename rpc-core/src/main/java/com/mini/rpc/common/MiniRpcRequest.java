package com.mini.rpc.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class MiniRpcRequest implements Serializable {
    /**
     * 服务版本
     */
    private String serviceVersion;

    /**
     * 类名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数值
     */
    private Object[] params;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;
}
