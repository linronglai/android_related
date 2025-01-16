1.view绘制流程
绘制时机是activity onCreate和onResume之后
performLaunchActivity->activity.attach->activity.onCreate->setContentView
handleResumeActivity ->activity.resume()
->activity.makeVisible->>wm.addView->viewRootImpl.setView()->requestLayout->往主线程handler中发送message,message中的callback促发->performTraversals
performTraversals: 1.measure：可能会进行多次
2.layout
3.onDraw

2.activity创建流程
(1) launch进程通过binder通信到AMS
(2) AMS接收到请求
目标进程若不存活，创建进程，初始化进程，进程运行ActivityThread
创建进程流程： 1.system_service进程向zygote进程发起通信（socket）
2.zygote进程fork出一个子进程
3.子进程进行初始化（执行ActivityThread.main函数)
子进程通过bindApplication，将新启动的应用绑定到ActivityManagerService。同时初始化主线程

(3) AMS通过ApplicationThread与目标进程通信，叫其创建activity
(4) 目标进程接收到信息，handleLaunchActivity启动activity
3.Choreographer
作用:监听vsync信号，启动view的绘制流程（通过handler异步消息）
使用场景：1.监听fps --Choreographer.postFrameCallback()
2.掉帧检测（流畅度检测) ----Choreographer.postFrameCallback()
每次vsync信号到来都会回调FrameCallback.doFrame()
4.handler
ThreadLocal
异步消息，同步屏障
Looper.loop()死循环不anr的原因
4.1 handler的回调顺序
msg.callback > handler.callback > handler.handlerMessage
应用场景：hook mH中的mCallback，就可以监控到mH执行了哪些message
4.2 内存泄露

# 5.Android事件分发机制

### 5.1 事件从Activity->PhoneWindow->DecorView

5.2

5.3 参考

https://blog.csdn.net/w1142203475/article/details/130325999

# 6.后台任务与进程相关

https://gityuan.com/tags/#%E8%BF%9B%E7%A8%8B%E7%B3%BB%E5%88%97
