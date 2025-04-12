package io.github.lunasaw.onvif.manager;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;

import io.github.lunasaw.onvif.model.constant.DeviceConfigConstant;
import io.github.lunasaw.onvif.model.dto.DevicePasswordConfig;
import io.github.lunasaw.onvif.model.dto.DeviceStreamConfig;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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
    public static List<DeviceStreamConfig.StreamConfig> getCameraStreamConfigs() {
        return parseConfig(DeviceConfigConstant.DEVICE_STREAM_CONFIG, DeviceStreamConfig.StreamConfig.class, Lists::newArrayList);
    }

    /**
     * 获取摄像头密码配置列表
     *
     * @return 摄像头密码配置列表
     */
    public static List<DevicePasswordConfig.PasswordConfig> getCameraPasswordConfigs() {
        return parseConfig(DeviceConfigConstant.DEVICE_USER_PASSWORD_CONFIG, DevicePasswordConfig.PasswordConfig.class, Lists::newArrayList);
    }

    /**
     * 从动态JSON字符串解析摄像头流配置列表
     *
     * @param jsonConfig 动态JSON配置字符串
     * @return 摄像头流配置列表，如果解析失败则返回空列表
     */
    public static List<DeviceStreamConfig.StreamConfig> parseCameraStreamConfigs(String jsonConfig) {
        return parseConfig(jsonConfig, DeviceStreamConfig.StreamConfig.class, JsonConfigManager::getCameraStreamConfigs);
    }

    /**
     * 从动态JSON字符串解析摄像头密码配置列表
     *
     * @param jsonConfig 动态JSON配置字符串
     * @return 摄像头密码配置列表，如果解析失败则返回空列表
     */
    public static List<DevicePasswordConfig.PasswordConfig> parseCameraPasswordConfigs(String jsonConfig) {
        return parseConfig(jsonConfig, DevicePasswordConfig.PasswordConfig.class, JsonConfigManager::getCameraPasswordConfigs);
    }

    /**
     * 通用的JSON配置解析方法
     *
     * @param jsonConfig JSON配置字符串
     * @param clazz      目标类型
     * @param fallback   回退策略
     * @param <T>        泛型类型
     * @return 解析后的配置列表
     */
    private static <T> List<T> parseConfig(String jsonConfig, Class<T> clazz, Supplier<List<T>> fallback) {
        return Optional.ofNullable(jsonConfig)
                .map(config -> JSON.parseArray(config, clazz))
                .orElseGet(fallback);
    }
}