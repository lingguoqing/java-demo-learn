package com.ling.explame.provider;

import cn.hutool.core.net.NetUtil;
import com.ling.explame.common.service.UserService;
import com.ling.lingrpccore.RpcApplication;
import com.ling.lingrpccore.config.RegistryConfig;
import com.ling.lingrpccore.config.RpcConfig;
import com.ling.lingrpccore.model.ServiceMetaInfo;
import com.ling.lingrpccore.register.LocalRegistry;
import com.ling.lingrpccore.register.Registry;
import com.ling.lingrpccore.register.RegistryFactory;
import com.ling.lingrpccore.server.HttpServer;
import com.ling.lingrpccore.server.VertxHttpServer;


/**
 * 服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
