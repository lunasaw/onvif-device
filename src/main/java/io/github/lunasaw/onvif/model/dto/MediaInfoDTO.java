package io.github.lunasaw.onvif.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 媒体信息DTO
 */
@Getter
@Setter
public class MediaInfoDTO extends ExtendMapDTO {
    /**
     * 媒体名称
     */
    private String mediaName;

    /**
     * 流类型
     */
    private String streamType;

    /**
     * URL模板
     */
    private String urlTemplate;
}