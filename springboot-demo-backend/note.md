- sse 实现
    - 只能使用get请求实现sse技术

```java

@GetMapping(value = "/listDev")
public SseEmitter list(SelectPostUser selectPostUser) throws IOException {
    SseEmitter emitter = new SseEmitter(0L);
    Page<User> user = userService.selectByUser(selectPostUser);
    emitter.send(user);
    // 完成发送
    emitter.complete();
    return emitter;
}
```
