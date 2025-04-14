package io.github.lunasaw.onvif.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author luna
 * @date 2024/12/12
 */
@Getter
@Setter
public class DeviceOnLineDTO extends ExtendMapDTO {
    /**
     * 设备状态 1在线 0离线
     */
    private Integer deviceStatus;

    /**
     * 心跳时间
     */
    private Date keepaliveTime;

}
