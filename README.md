# myplatform-bot-dm

#### 项目结构
    - main  
        - core
            - client
            - common 
            - conditions
            - executor
            - interfaces
            - middleware
            - pojo
        - controller
        - service
        - db
    - test
    - resources

#### TODO
1. 读取本地配置初始化 保险 机器人
    - json映射pojo(完成)
    - 反射初始化Excutor,
    - Transition初始化
    - 反射初始化Condition,params设计
2. 保险流程设计
3. http API调用，沿用保险一期
    - eureka特性加入
    - client端实现
4. 流程打通
    - domain识别（写死，完成）
    - entity识别
        - 输入输出规范
        - api调用
    - intent识别
        - 输入输出规范
        - api调用
    - condition判断机制实现
    - executor执行实现
5. bot等配置对象的全局cache以及降级
    - google cache包使用
    - cache miss后的降级实现 
6. session的redis缓存
    - Context存储结构设计(完成)
    - 

