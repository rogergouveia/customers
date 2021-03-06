package com.rngouveia.customer.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.webflux.ui.SwaggerConfig;
import org.springdoc.webflux.ui.SwaggerWelcomeWebFlux;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.http.server.reactive.HttpHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class NettyWebServerConfiguration extends NettyReactiveWebServerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyWebServerConfiguration.class);
    private final String contextPath;

    public NettyWebServerConfiguration(@Value("${SERVER_CONTEXT_PATH:/}") final String contextPath) {
        this.contextPath = contextPath;
    }

    @Override
    public WebServer getWebServer(HttpHandler httpHandler) {
        LOGGER.info("Configuring context path to {}", contextPath);
        Map<String, HttpHandler> handlerMap = new HashMap<>();
        handlerMap.put(this.contextPath, httpHandler);
        return super.getWebServer(new ContextPathCompositeHandler(handlerMap));
    }
}
