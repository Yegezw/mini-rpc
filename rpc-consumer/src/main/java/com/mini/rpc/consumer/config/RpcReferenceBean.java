package com.mini.rpc.consumer.config;

import com.mini.rpc.consumer.core.RpcInvokerProxy;
import com.mini.rpc.provider.registry.RegistryFactory;
import com.mini.rpc.provider.registry.RegistryService;
import com.mini.rpc.provider.registry.RegistryType;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class RpcReferenceBean implements FactoryBean<Object> {

    /**
     * 服务类型
     */
    @Setter
    private Class<?> interfaceClass;

    /**
     * 服务版本
     */
    @Setter
    private String serviceVersion;

    /**
     * 注册中心类型
     */
    @Setter
    private String registryType;

    /**
     * 注册中心地址
     */
    @Setter
    private String registryAddr;

    /**
     * 超时时间
     */
    @Setter
    private long timeout;

    /**
     * 代理对象
     */
    private Object object;

    @Override
    public Object getObject() throws Exception {
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    /**
     * 由 Spring 调用
     */
    public void init() throws Exception {
        RegistryService registryService = RegistryFactory.getInstance(this.registryAddr, RegistryType.valueOf(this.registryType));
        this.object = Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new RpcInvokerProxy(serviceVersion, timeout, registryService)
        );
    }
}
