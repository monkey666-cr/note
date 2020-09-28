## 使用虚拟机打造便捷调试环境

### 使用 Kali 初始化配置

更改时区

```bash
dpkg-reconfigure tzdata
```

使用中文

```bash
apt install xfonts-intl-chinese
apt install ttf-wqy-microhei
```

实用小工具

```bash
apt install htop
apt install jnettop
```



## 刷机，Frida-server开发环境搭建



## Python，Frida(-tools)全版本随意切换



## Frida 开发环境搭建



## Frida-server自定义名称，端口和链接

制定frida的端口

```bash
./frida-server -l 0.0.0.0:8888
```

通过frida-ps 查看

```bash
frida-ps -H 192.168.0.101:8888
```

注入脚本

```bash
frida -H 192.168.0.101:8888 -f com.android.settings -l script.js --no-pause
```

