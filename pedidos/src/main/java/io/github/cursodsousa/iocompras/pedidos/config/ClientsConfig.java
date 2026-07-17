package io.github.cursodsousa.iocompras.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.github.cursodsousa.iocompras.pedidos.client")
public class ClientsConfig {
}
