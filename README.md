# CVE-2022-39197 patch

### CVE-2022-39197 Cobalt Strike XSS 漏洞的一个临时补丁

通过 hook javax.swing.plaf.basic.BasicHTML的isHTMLString方法来禁用swing的html支持

PS: 部分依赖html的页面无法正常渲染(例如 关于页面)

### 使用方法
将 patch.jar 放入cobaltstrike启动目录下

在cobaltstrike启动参数中加入javaagent 启用补丁
```
-javaagent:patch.jar
```

启动cobaltstrike 输出Successfully Patched. 即为禁用成功
```
====== CVE-2022-39197 patch @burpheart ======
Successfully Patched.
```


------------------
CVE-2022-39197 Cobalt Strike XSS vulnerability patch

Disable html support for swing by hooking the isHTMLString method of javax.swing.plaf.basic.

PS: Some html-dependent pages do not render properly ( Such as About page etc.)
Add javaagent to the cobaltstrike startup parameters to enable patching
```
-javaagent:patch.jar
```

Start cobaltstrike and output Successfully Patched.
```
====== CVE-2022-39197 patch @burpheart ======
Successfully Patched.
```
