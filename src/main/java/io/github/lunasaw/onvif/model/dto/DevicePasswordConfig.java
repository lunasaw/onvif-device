package io.github.lunasaw.onvif.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 摄像头密码配置模型
 */
@Getter
@Setter
public class DevicePasswordConfig {
    private String username;
    private String password;
    private String port;
}