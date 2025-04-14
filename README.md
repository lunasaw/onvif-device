# onvif-device

[![Maven Central](https://img.shields.io/maven-central/v/io.github.lunasaw/onvif-device)](https://mvnrepository.com/artifact/io.github.lunasaw/onvif-device)
[![GitHub license](https://img.shields.io/badge/MIT_License-blue.svg)](https://raw.githubusercontent.com/lunasaw/onvif-device/master/LICENSE)

## 项目介绍

onvif-device 是一个基于 Java 的 ONVIF 设备操作库，提供了对 ONVIF 兼容设备的发现、配置和控制功能。该项目基于 Spring Boot 框架开发，简化了与 ONVIF 设备的交互过程。

## 主要特性

- 支持 ONVIF 设备发现
- 设备信息获取
- 设备配置管理
- 基于 Spring Boot 的自动配置
- 简单易用的 API 接口

## 系统要求

- JDK 1.8 或更高版本
- Maven 3.6 或更高版本

## 快速开始

### 添加依赖

```xml
<dependency>
    <groupId>io.github.lunasaw</groupId>
    <artifactId>onvif-device</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 基本使用示例

```java
// 设备发现示例
OnvifDeviceDiscovery discovery = new OnvifDeviceDiscovery();
List<Device> devices = discovery.discoverDevices();

// 设备操作示例
OnvifDevice device = new OnvifDevice("192.168.1.100", "admin", "password");
DeviceInfo info = device.getDeviceInfo();
```

## 文档

更多详细的使用说明和 API 文档，请访问 [项目文档](http://lunasaw.github.io/onvif-device)。

## 代码规范

- 后端代码使用 ali-code-style.xml 格式化模板
- 前端代码使用 Beautify 插件格式化，缩进使用 TAB
- 后端代码遵循 P3C 插件规范
- 注释要尽可能完整明晰
- 提交代码前必须进行格式化
- XML 文件使用 TAB 缩进

## 许可证

本项目采用 Apache 2.0 许可证 - 详情请参阅 [LICENSE](LICENSE) 文件

## 联系方式

- 邮箱：iszychen@gmail.com
- 项目主页：[www.isluna.ml](http://lunasaw.github.io)
