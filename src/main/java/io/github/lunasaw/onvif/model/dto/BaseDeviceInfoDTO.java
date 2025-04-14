package io.github.lunasaw.onvif.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 设备信息基础类
 */
@Getter
@Setter
public class BaseDeviceInfoDTO extends DeviceOnLineDTO {
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备IP
     */
    private String ip;
    /**
     * 设备端口
     */
    private int port;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

     /**
     * 设备序列号
     */
    private String serialNumber;
    /**
     * 软件版本
     */
    private String softwareVersion;
    /**
     * 品牌
     */
    private String brand;

    /**
     * 设备制造商
     */
    private String manufacturer;
    /**
     * 设备型号
     */
    private String model;
    /**
     * 固件版本
     */
    private String firmwareVersion;
    /**
     * 硬件 ID
     */
    private String hardwareId;

    /**
     * 通道信息
     */
    private List<MediaInfoDTO> mediaList;

    /**
     * 协议方式 onvif
     */
    private String protocol = "onvif";

    /**
     * 是否支持云台
     */
    private boolean supportPtz = false;

    /**
     * 是否已认证。
     * 0: 待认证，1：已认证，2：认证失败
     */
    private Integer authedStatus = 0;
}