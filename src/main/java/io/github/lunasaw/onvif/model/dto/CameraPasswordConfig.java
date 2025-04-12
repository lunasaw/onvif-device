package io.github.lunasaw.onvif.model.dto;

import lombok.Data;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 摄像头密码配置
 */
@Data
public class CameraPasswordConfig {

    private String port;
    private String username;
    private String password;
}