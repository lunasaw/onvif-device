package io.github.lunasaw.onvif.model.bo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 设备密码配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "device")
public class DevicePasswordConfigBO {
    private List<PasswordConfig> passwordConfigs;

    @Data
    public static class PasswordConfig {
        private int port;
        private String username;
        private String password;
    }
}