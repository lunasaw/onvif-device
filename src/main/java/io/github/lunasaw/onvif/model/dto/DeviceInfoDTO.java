package io.github.lunasaw.onvif.model.dto;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
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
     * 设备状态 1在线 0离线
     */
    private Integer deviceStatus;

    /**
     * 扩展信息（格式为 json，需根据实际业务解析）
     */
    private String extentInfo;

    private BaseDeviceInfoDTO baseDeviceInfoObj;


    public static BaseDeviceInfoDTO getExtendObj(String extentInfo) {
        if (StringUtils.isBlank(extentInfo)) {
            return new BaseDeviceInfoDTO();
        }
        String extend = Optional.of(extentInfo).orElse(StringUtils.EMPTY);
        return JSON.parseObject(extend, BaseDeviceInfoDTO.class);
    }
}
