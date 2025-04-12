package io.github.lunasaw.onvif.manager;

import de.onvif.beans.DeviceInfo;
import de.onvif.soap.OnvifDevice;
import io.github.lunasaw.onvif.model.bo.DevicePasswordConfigBO;
import io.github.lunasaw.onvif.model.dto.OnvifDeviceModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: Onvif设备管理器
 */
@Slf4j
public class OnvifDeviceManager {

    /**
     * 获取Onvif设备（默认实现）
     *
     * @param ip   设备IP
     * @param port 设备端口
     * @return Onvif设备模型
     */
    public OnvifDeviceModel getOnvifDevice(String ip, int port) {
        List<DevicePasswordConfigBO.PasswordConfig> cameraPasswordConfigs = JsonConfigManager.getCameraPasswordConfigs();
        Assert.isTrue(CollectionUtils.isNotEmpty(cameraPasswordConfigs), "单次设备设备发现 [Onvif] getCameraPasswordConfigs is null");
        Map<Integer, List<DevicePasswordConfigBO.PasswordConfig>> portPasswordMap = cameraPasswordConfigs.stream()
                .collect(Collectors.groupingBy(DevicePasswordConfigBO.PasswordConfig::getPort));

        List<DevicePasswordConfigBO.PasswordConfig> cameraPasswordConfigList = portPasswordMap.get(port);
        Assert.isTrue(CollectionUtils.isNotEmpty(cameraPasswordConfigList), "单次设备设备发现 [Onvif] 对应port没有配置设备发现密码");

        return getOnvifDevice(ip, port, cameraPasswordConfigList);
    }

    /**
     * 获取Onvif设备
     *
     * @param ip   设备IP
     * @param port 设备端口
     * @param passwordConfigs 密码配置列表
     * @return Onvif设备模型
     */
    public OnvifDeviceModel getOnvifDevice(String ip, int port, List<DevicePasswordConfigBO.PasswordConfig> passwordConfigs) {
        OnvifDeviceModel device = new OnvifDeviceModel();
        try {
            Assert.isTrue(CollectionUtils.isNotEmpty(passwordConfigs), "单次设备设备发现 [Onvif] passwordConfigs is null");

            OnvifDevice onvifDevice = null;
            String workingPassword = null;
            String workingUser = null;

            for (DevicePasswordConfigBO.PasswordConfig config : passwordConfigs) {
                if (port != config.getPort()) {
                    log.info("单次设备设备发现 端口不匹配跳过 getOnvifDevice::ip = {}, port = {}, configPort = {}, username = {}, password = {}",
                            ip, port, config.getPort(), config.getUsername(), config.getPassword());
                    continue;
                }
                String password = config.getPassword();
                String username = config.getUsername();
                try {
                    log.info("单次设备设备发现 开始尝试密码 getOnvifDevice::ip = {}, port = {}, password = {}", ip, port, password);
                    onvifDevice = new OnvifDevice(ip, username, password);

                    DeviceInfo deviceInfo = onvifDevice.getDeviceInfo();
                    if (StringUtils.isNoneBlank(deviceInfo.getManufacturer())) {
                        log.info("单次设备设备发现成功 getOnvifDevice::ip = {}, port = {}, password = {}, getManufacturer = {}",
                                ip, port, password, deviceInfo.getManufacturer());
                        workingPassword = password;
                        workingUser = username;
                        break;
                    }
                } catch (Throwable e) {
                    log.error("单次设备设备发现 尝试密码失败 Failed to connect with password: {}, e = {}", password, e.getMessage());
                }
            }

            device.setOnvifDevice(onvifDevice);
            device.setPassword(workingPassword);
            device.setUsername(workingUser);
            device.setIp(ip);
            device.setPort(port);
            return device;
        } catch (Throwable e) {
            log.error("单次设备设备发现 获取构建Onvif设备失败 getSoapOnvifDevice::ip = {}, port = {} ", ip, port, e);
        }
        return null;
    }
}