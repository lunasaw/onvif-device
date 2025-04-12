package io.github.lunasaw.onvif.model.dto;

import de.onvif.soap.OnvifDevice;
import lombok.Data;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: Onvif设备模型
 */
@Data
public class OnvifDeviceModel {

    private OnvifDevice onvifDevice;
    private String username;
    private String password;
}