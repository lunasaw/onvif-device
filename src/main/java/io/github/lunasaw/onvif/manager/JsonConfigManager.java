package io.github.lunasaw.onvif.manager;

import com.alibaba.fastjson2.JSON;
import io.github.lunasaw.onvif.model.CameraPasswordConfig;
import io.github.lunasaw.onvif.model.CameraStreamConfig;
import io.github.lunasaw.onvif.model.constant.Constant;

import java.util.List;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: JSON配置管理器
 */
public class JsonConfigManager {

    /**
     * 获取摄像头流配置列表
     *
     * @return 摄像头流配置列表
     */
    public static List<CameraStreamConfig> getCameraStreamConfigs() {
        return JSON.parseArray(Constant.CAMERA_STREAM_CONFIG, CameraStreamConfig.class);
    }

    /**
     * 获取摄像头密码配置列表
     *
     * @return 摄像头密码配置列表
     */
    public static List<CameraPasswordConfig> getCameraPasswordConfigs() {
        return JSON.parseArray(Constant.CAMERA_USER_PASSWORD_CONFIG, CameraPasswordConfig.class);
    }
}