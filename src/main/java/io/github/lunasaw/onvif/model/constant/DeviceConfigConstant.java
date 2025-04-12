package io.github.lunasaw.onvif.model.constant;

/**
 * @author luna
 * @version 1.0
 * @date 2024/1/1
 * @description: 常量类
 */
public class DeviceConfigConstant {
    public static final String SUPPORT_MANUFACTURERS = "HIKVISION,xsh,Dahua,ONVIF_WDZ_HK";

    public static final String DEVICE_STREAM_CONFIG = "[\n" +
            "  {\n" +
            "    \"manufacturer\": \"xsh\",\n" +
            "    \"streamType\": \"main\",\n" +
            "    \"mediaName\": \"D01_CH01_Main\",\n" +
            "    \"urlTemplate\": \"rtsp://{ip}/camera1/main\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"xsh\",\n" +
            "    \"streamType\": \"sub\",\n" +
            "    \"mediaName\": \"D01_CH01_Sub\",\n" +
            "    \"urlTemplate\": \"rtsp://{ip}/camera1/sub\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"HIKVISION\",\n" +
            "    \"streamType\": \"main\",\n" +
            "    \"mediaName\": \"D01_CH01_Main\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/h265/ch1/main/av_stream\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"HIKVISION\",\n" +
            "    \"streamType\": \"sub\",\n" +
            "    \"mediaName\": \"D01_CH01_Sub\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/h265/ch1/sub/av_stream\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"ONVIF_WDZ_HK\",\n" +
            "    \"streamType\": \"main\",\n" +
            "    \"mediaName\": \"D01_CH01_Main\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/h265/ch1/main/av_stream\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"ONVIF_WDZ_HK\",\n" +
            "    \"streamType\": \"sub\",\n" +
            "    \"mediaName\": \"D01_CH01_Sub\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/h265/ch1/sub/av_stream\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"ONVIF_WDZ_HK\",\n" +
            "    \"streamType\": \"main\",\n" +
            "    \"mediaName\": \"D01_CH01_Main\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/h265/ch1/main/av_stream\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"ONVIF_WDZ_HK\",\n" +
            "    \"streamType\": \"sub\",\n" +
            "    \"mediaName\": \"D01_CH01_Sub\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/h265/ch1/sub/av_stream\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"Dahua\",\n" +
            "    \"streamType\": \"main\",\n" +
            "    \"mediaName\": \"D01_CH01_Main\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/cam/realmonitor?channel=1&subtype=0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"manufacturer\": \"Dahua\",\n" +
            "    \"streamType\": \"sub\",\n" +
            "    \"mediaName\": \"D01_CH01_Sub\",\n" +
            "    \"urlTemplate\": \"rtsp://{username}:{password}@{ip}:554/cam/realmonitor?channel=1&subtype=1\"\n" +
            "  }\n" +
            "]";

    public static final String DEVICE_USER_PASSWORD_CONFIG = "[\n" +
            "    {\n" +
            "        \"port\": -1,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"weidian_24h\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"port\": -1,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"admin\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"port\": -1,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"admin123\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"port\": 80,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"admin123\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"port\": 80,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"admin\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"port\": 80,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"weidian_24h\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"port\": 8000,\n" +
            "        \"username\": \"admin\",\n" +
            "        \"password\": \"admin\"\n" +
            "    }\n" +
            "]";
}