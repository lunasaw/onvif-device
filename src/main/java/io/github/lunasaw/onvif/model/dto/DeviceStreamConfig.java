package io.github.lunasaw.onvif.model.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 设备流配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "device")
public class DeviceStreamConfig {
    private List<StreamConfig> streamConfigs;

    @Data
    public static class StreamConfig {
        private String manufacturer;
        private String streamType;
        private String mediaName;
        private String urlTemplate;
    }
}