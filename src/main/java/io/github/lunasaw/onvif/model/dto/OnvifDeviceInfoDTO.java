package io.github.lunasaw.onvif.model.dto;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * I18H 私有协议响应
 */
@Getter
@Setter
public class OnvifDeviceInfoDTO extends DeviceAuthDTO {


    private String serialNumber;
    private String model;
    private String manufacturer;
    private String hardwareVersion;
    private String softwareVersion;
    private String hardwareId;
    private String brand;
    private boolean ptz;
    /**
     * 设备通道信息
     */
    private List<MediaInfoDTO> meidaList;

    @Override
    public DeviceInfoDTO convert() {
        return convert(this);
    }


    public static DeviceInfoDTO convert(DeviceAuthDTO deviceAuthDTO) {
        OnvifDeviceInfoDTO onvifDeviceInfo = (OnvifDeviceInfoDTO) deviceAuthDTO;
        return convert(onvifDeviceInfo);
    }

    public static DeviceInfoDTO convert(OnvifDeviceInfoDTO onvifDeviceInfo) {
        DeviceInfoDTO deviceInfoDTO = new DeviceInfoDTO();

        deviceInfoDTO.setCreateTime(new Date());
        deviceInfoDTO.setUpdateTime(new Date());
        // DeviceInfoTypeEnum.CAMERA
        deviceInfoDTO.setType(0);
        deviceInfoDTO.setDeviceSn(onvifDeviceInfo.getSerialNumber());
        deviceInfoDTO.setIpAddr(onvifDeviceInfo.getIp());
        deviceInfoDTO.setDeviceStatus(1);

        DeviceInfoDTO.ExtendInfo extendInfo = new DeviceInfoDTO.ExtendInfo();

        // 这个与onvif结果最匹配
        extendInfo.setFirmwareVersion(onvifDeviceInfo.getHardwareVersion());
        extendInfo.setHardwareId(onvifDeviceInfo.getSoftwareVersion());
        extendInfo.setHardwareId(onvifDeviceInfo.getHardwareId());
        extendInfo.setManufacturer(onvifDeviceInfo.getManufacturer());
        extendInfo.setModel(onvifDeviceInfo.getModel());
        extendInfo.setKeepaliveTime(new Date());
        extendInfo.setUserName(onvifDeviceInfo.getUsername());
        extendInfo.setPassword(onvifDeviceInfo.getPassword());
        extendInfo.setOnvifProtocol(true);
        extendInfo.setPtzProtocol(onvifDeviceInfo.isPtz());
        extendInfo.setMediaList(onvifDeviceInfo.getMeidaList());
        deviceInfoDTO.setExtendInfoObj(extendInfo);
        deviceInfoDTO.setExtentInfo(JSON.toJSONString(extendInfo));
        return deviceInfoDTO;
    }
}
