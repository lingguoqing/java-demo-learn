package com.ling.explame.provider;


import com.ling.explame.common.service.UserService;
import com.ling.lingrpc.register.LocalRegistry;
import com.ling.lingrpc.server.HttpServer;
import com.ling.lingrpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(9800);
    }
}
