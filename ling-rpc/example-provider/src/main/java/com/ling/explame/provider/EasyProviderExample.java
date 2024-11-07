package com.ling.explame.provider;


import com.ling.explame.common.service.UserService;
import lingrpccore.RpcApplication;
import lingrpccore.register.LocalRegistry;
import lingrpccore.server.HttpServer;
import lingrpccore.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {

        // 初始化 RPC框架
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
// 读取配置文件中的端口
// httpServer.doStart(9800);
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
