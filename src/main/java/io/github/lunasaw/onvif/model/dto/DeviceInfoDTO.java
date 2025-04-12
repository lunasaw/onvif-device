package io.github.lunasaw.onvif.model.dto;

import com.alibaba.fastjson2.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
public class DeviceInfoDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 设备类型（取值详见 #{@link DeviceInfoTypeEnum}）
     */
    private Integer type;

    /**
     * 设备序列号
     */
    private String deviceSn;

    /**
     * IP 地址
     */
    private String ipAddr;

    /**
     * 设备状态
     */
    private Integer deviceStatus;

    /**
     * 扩展信息（格式为 json，需根据实际业务解析）
     */
    private String extentInfo;

    private ExtendInfo extendInfoObj;


    public static ExtendInfo getExtendObj(String extentInfo) {
        if (StringUtils.isBlank(extentInfo)) {
            return new ExtendInfo();
        }
        String extend = Optional.of(extentInfo).orElse(StringUtils.EMPTY);
        return JSON.parseObject(extend, ExtendInfo.class);
    }

    @Data
    public static class ExtendInfo {
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
         * 心跳时间
         */
        private Date keepaliveTime;
        /**
         * 用户名
         */
        private String userName;
        /**
         * 密码
         */
        private String password;

        /**
         * 通道信息
         */
        private List<MediaInfoDTO> mediaList;

        /**
         * 是否 ONVIF 协议
         */
        private boolean onvifProtocol;

        /**
         * 是否 PTZ 协议
         */
        private boolean ptzProtocol;

        /**
         * 是否已认证。
         * 0: 待认证，1：已认证，2：认证失败
         */
        private Integer authedStatus = 0;

        private Map<String, Object> extendMap;
    }
}
