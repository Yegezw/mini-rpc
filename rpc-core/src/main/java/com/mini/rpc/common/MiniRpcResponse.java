package com.mini.rpc.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class MiniRpcResponse implements Serializable {
    /**
     * 请求结果
     */
    private Object data;
    /**
     * 错误信息
     */
    private String message;
}
