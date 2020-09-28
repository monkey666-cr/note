## objection与Frida版本匹配安装

- Frida == 12.8
- Frida-tools == 5.3.0
- Objection == 1.8.4

## objection连接非标准端口

```bash
objection -N -h 192.168.0.101 -p 8888 -g com.android.settings explore
```

### 获取基本信息

#### frida

```bash
com.android.settings on (google: 8.1.0) [net] # frida 
```

--------------------  -----------
Frida Version         12.8.0
Process Architecture  arm64
Process Platform      linux
Debugger Attached     False
Script Runtime        DUK
Script Filename       /script1.js
Frida Heap Size       18.4 MiB

#### env

```bash
com.android.settings on (google: 8.1.0) [net] # env
```

Name                    Path
----------------------  -----------------------------------------------------------
cacheDirectory          /data/user_de/0/com.android.settings/cache
codeCacheDirectory      /data/user_de/0/com.android.settings/code_cache
externalCacheDirectory  /storage/emulated/0/Android/data/com.android.settings/cache
filesDirectory          /data/user_de/0/com.android.settings/files
obbDir                  /storage/emulated/0/Android/obb/com.android.settings
packageCodePath         /system/priv-app/SettingsGoogle/SettingsGoogle.apk

### 提取内存信息

#### memory list modules

查看内存中的加载信息

```bash
com.android.settings on (google: 8.1.0) [net] # memory list modules   
```

Name                                             Base          Size                  Path
-----------------------------------------------  ------------  --------------------  ------------------------------------------------------------------------------
app_process64                                    0x5905d92000  32768 (32.0 KiB)      /system/bin/app_process64

#### memory list exports libqdMetaData.so 

查看库的导出函数

```bash
com.android.settings on (google: 8.1.0) [net] # memory list exports libqdMetaData.so 
```

Type      Name          Address
--------  ------------  ------------
function  getMetaData   0x77fb3d6a5c
function  setMetaData   0x77fb3d67a0
function  copyMetaData  0x77fb3d6bc8

#### activity

启动activity

```bash
com.android.settings on (google: 8.1.0) [net] # android intent launch_activity com.android.settings.DisplaySettings  
```



## objection内存漫游，hook， trace



## objection 插件体系：Wallbreaker



## objection + DexDump 脱壳



