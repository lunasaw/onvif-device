package io.github.lunasaw.onvif.config;

import io.github.lunasaw.onvif.model.bo.DevicePasswordConfigBO;
import io.github.lunasaw.onvif.model.bo.DeviceStreamConfigBO;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 设备配置类
 */
@Configuration
@EnableConfigurationProperties({DeviceStreamConfigBO.class, DevicePasswordConfigBO.class})
public class DeviceConfig {
}