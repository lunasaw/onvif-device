package io.github.lunasaw.onvif.manager;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.github.lunasaw.onvif.model.bo.DevicePasswordConfigBO;
import io.github.lunasaw.onvif.model.bo.DeviceStreamConfigBO;
import io.github.lunasaw.onvif.model.constant.DeviceConfigConstant;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: JSON配置管理器
 */
@Component
public class JsonConfigManager {

    @Value("${device.support-manufacturers:HIKVISION,xsh,Dahua,ONVIF_WDZ_HK}")
    private String supportManufacturers;

    /**
     * 获取摄像头流配置列表
     *
     * @return 摄像头流配置列表
     */
    public static List<DeviceStreamConfigBO.StreamConfig> getCameraStreamConfigs() {
        return parseConfig(DeviceConfigConstant.DEVICE_STREAM_CONFIG, DeviceStreamConfigBO.StreamConfig.class, Lists::newArrayList);
    }

    /**
     * 获取摄像头密码配置列表
     *
     * @return 摄像头密码配置列表
     */
    public static List<DevicePasswordConfigBO.PasswordConfig> getCameraPasswordConfigs() {
        return parseConfig(DeviceConfigConstant.DEVICE_USER_PASSWORD_CONFIG, DevicePasswordConfigBO.PasswordConfig.class, Lists::newArrayList);
    }

    /**
     * 从动态JSON字符串解析摄像头流配置列表
     *
     * @param jsonConfig 动态JSON配置字符串
     * @return 摄像头流配置列表，如果解析失败则返回空列表
     */
    public static List<DeviceStreamConfigBO.StreamConfig> parseCameraStreamConfigs(String jsonConfig) {
        return parseConfig(jsonConfig, DeviceStreamConfigBO.StreamConfig.class, JsonConfigManager::getCameraStreamConfigs);
    }

    /**
     * 从动态JSON字符串解析摄像头密码配置列表
     *
     * @param jsonConfig 动态JSON配置字符串
     * @return 摄像头密码配置列表，如果解析失败则返回空列表
     */
    public static List<DevicePasswordConfigBO.PasswordConfig> parseCameraPasswordConfigs(String jsonConfig) {
        return parseConfig(jsonConfig, DevicePasswordConfigBO.PasswordConfig.class, JsonConfigManager::getCameraPasswordConfigs);
    }

    /**
     * 获取支持的设备厂商列表
     *
     * @return 支持的设备厂商列表
     */
    public List<String> getSupportManufacturers() {
        return parseManufacturers(supportManufacturers, Lists::newArrayList);
    }

    /**
     * 从动态配置字符串解析支持的设备厂商列表
     *
     * @param manufacturersConfig 动态配置字符串
     * @return 支持的设备厂商列表，如果解析失败则返回空列表
     */
    public List<String> parseSupportManufacturers(String manufacturersConfig) {
        return parseManufacturers(manufacturersConfig, this::getSupportManufacturers);
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

    /**
     * 通用的厂商配置解析方法
     *
     * @param manufacturersConfig 厂商配置字符串
     * @param fallback 回退策略
     * @return 解析后的厂商列表
     */
    private List<String> parseManufacturers(String manufacturersConfig, Supplier<List<String>> fallback) {
        return Optional.ofNullable(manufacturersConfig)
                .filter(StringUtils::isNotBlank)
                .map(config -> Arrays.asList(config.split(",")))
                .orElseGet(fallback);
    }
}