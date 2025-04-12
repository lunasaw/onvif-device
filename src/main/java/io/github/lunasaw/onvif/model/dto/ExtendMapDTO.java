package io.github.lunasaw.onvif.model.dto;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luna
 * @date 2024/12/12
 */
@Data
public class ExtendMapDTO {
    private Map<String, Object> extend = new ConcurrentHashMap<>();
}
