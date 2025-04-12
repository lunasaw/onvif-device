package io.github.lunasaw.onvif.config;

import io.github.lunasaw.onvif.model.dto.DevicePasswordConfig;
import io.github.lunasaw.onvif.model.dto.DeviceStreamConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 设备配置类
 */
@Configuration
@EnableConfigurationProperties({DeviceStreamConfig.class, DevicePasswordConfig.class})
public class DeviceConfig {
}