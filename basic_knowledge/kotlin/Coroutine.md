# 1.启动协程的两种方式

##1.launch

协程启动需要：1.上下文；2.启动模式；3.协程体

上下文：

```
public fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {}
```

2.async

# 2.调度程序Dispatch.Main/IO/Default

# 3.CoroutineScope

1.viewModelScoep

# 4.suspend和resume

什么时候挂起

什么似乎恢复

# 5.协程的取消
