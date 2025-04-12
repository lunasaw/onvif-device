package io.github.lunasaw.onvif.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 摄像头流配置模型类
 * 用于存储和管理 ONVIF 摄像头的流媒体配置信息
 *
 * @see io.github.lunasaw.onvif.DeviceConfigConstant.CameraConfigConstant
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 */
@Getter
@Setter
public class DeviceStreamConfig {
    /**
     * 媒体名称，用于标识不同的媒体流
     */
    private String mediaName;

    /**
     * 设备制造商信息
     */
    private String manufacturer;

    /**
     * 流类型，如 main,sub 等
     */
    private String streamType;

    /**
     * 流媒体 URL 模板，用于构建完整的流媒体访问地址
     */
    private String urlTemplate;
}