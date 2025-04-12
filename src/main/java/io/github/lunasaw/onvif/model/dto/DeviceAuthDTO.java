package io.github.lunasaw.onvif.model.dto;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 设备搜索基础类
 */
@Data
public class DeviceAuthDTO {

    private String name;
    private String ip;
    private int port;
    private String username;
    private String password;

    private String serialNumber;


    private Map<String, Object> extend = new ConcurrentHashMap<>();


    public DeviceInfoDTO convert() {
        return null;
    }

}
