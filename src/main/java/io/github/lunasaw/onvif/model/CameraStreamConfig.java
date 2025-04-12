package io.github.lunasaw.onvif.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 摄像头流配置模型
 */
@Getter
@Setter
public class CameraStreamConfig {
    private String mediaName;
    private String manufacturer;
    private String streamType;
    private String urlTemplate;
}