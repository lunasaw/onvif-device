package io.github.lunasaw.onvif.model.dto;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * onvif协议响应数据模型
 */
@Getter
@Setter
public class OnvifDeviceInfoDTO extends BaseDeviceInfoDTO {


    public DeviceInfoDTO convert() {
        return convert(this);
    }

    public static OnvifDeviceInfoDTO convert(DeviceInfoDTO deviceInfoDTO) {
        if (deviceInfoDTO == null) {
            return null;
        }

        return JSON.parseObject(deviceInfoDTO.getExtentInfo(), OnvifDeviceInfoDTO.class);
    }

    public static DeviceInfoDTO convert(OnvifDeviceInfoDTO onvifDeviceInfo) {
        DeviceInfoDTO deviceInfoDTO = new DeviceInfoDTO();
        deviceInfoDTO.setCreateTime(new Date());
        deviceInfoDTO.setUpdateTime(new Date());
        deviceInfoDTO.setType(0); // DeviceInfoTypeEnum.CAMERA
        deviceInfoDTO.setDeviceSn(onvifDeviceInfo.getSerialNumber());
        deviceInfoDTO.setIpAddr(onvifDeviceInfo.getIp());
        deviceInfoDTO.setDeviceStatus(1);

        deviceInfoDTO.setBaseDeviceInfoObj(onvifDeviceInfo);
        deviceInfoDTO.setExtentInfo(JSON.toJSONString(onvifDeviceInfo));
        return deviceInfoDTO;
    }

    /**
     * 判断设备是否在线
     * 如果心跳时间超过5分钟则认为离线
     * @return true:在线 false:离线
     */
    public boolean isOnline() {
        Date keepaliveTime = getKeepaliveTime();
        if (keepaliveTime == null) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        long lastKeepAliveTime = keepaliveTime.getTime();

        // 5分钟 = 5 * 60 * 1000 毫秒
        return (currentTime - lastKeepAliveTime) <= 5 * 60 * 1000;
    }
}