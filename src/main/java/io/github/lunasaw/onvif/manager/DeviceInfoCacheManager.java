package io.github.lunasaw.onvif.manager;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.github.lunasaw.onvif.model.dto.DeviceInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 设备信息缓存管理器
 * 使用Guava缓存维护线程安全的设备信息Map
 *
 * @author luna
 * @date 2024/1/1
 */
@Slf4j
@Component
public class DeviceInfoCacheManager {

    /**
     * 设备信息缓存
     * key: 设备序列号
     * value: 设备信息
     */
    private final Cache<String, DeviceInfoDTO> deviceInfoCache;

    public DeviceInfoCacheManager() {
        // 初始化缓存，设置最大容量为20，过期时间为8小时
        this.deviceInfoCache = CacheBuilder.newBuilder()
                .maximumSize(20)
                .expireAfterWrite(8, TimeUnit.HOURS)
                .build();
    }

    /**
     * 添加或更新设备信息
     *
     * @param deviceInfo 设备信息
     */
    public void putDeviceInfo(DeviceInfoDTO deviceInfo) {
        if (deviceInfo != null && deviceInfo.getDeviceSn() != null) {
            deviceInfoCache.put(deviceInfo.getDeviceSn(), deviceInfo);
            log.debug("设备信息已更新到缓存: {}", deviceInfo.getDeviceSn());
        }
    }

    /**
     * 获取设备信息
     *
     * @param serialNumber 设备序列号
     * @return 设备信息
     */
    public DeviceInfoDTO getDeviceInfo(String serialNumber) {
        return deviceInfoCache.getIfPresent(serialNumber);
    }

    /**
     * 移除设备信息
     *
     * @param serialNumber 设备序列号
     */
    public void removeDeviceInfo(String serialNumber) {
        deviceInfoCache.invalidate(serialNumber);
        log.debug("设备信息已从缓存中移除: {}", serialNumber);
    }

    /**
     * 清空所有设备信息
     */
    public void clearAll() {
        deviceInfoCache.invalidateAll();
        log.debug("所有设备信息已从缓存中清除");
    }
}