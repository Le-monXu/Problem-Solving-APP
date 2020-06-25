# 描述

- 一个 Cordova APP 的后端代码，实现问题协作。

# API说明

### /addAnswer GET 添加答案
- 输入：uid、qid、answer
- 成功输出：aid
- 失败输出：failed
- 错误输出：error:xxx

### /addGrading GET 添加评分
- 输入：uid、aid、score、isSupport（1或者0）
- 成功输出：success
- 失败输出：failed
- 错误输出：error:xxx

### /checkIsGrading GET 检查是否评价过这个回答
- 输入：uid、aid
- 已经评价过的输出：Grading{uid,aid,score,isSupport}
- 没有评价过的输出：false
- 错误输出：error:xxx

### /getAllAnswer GET 得到回答列表
- 输入：method、id（method表示按qid查询还是按uid查询）
- 输出：SortedSet\<Answer\> {Answer{uid,qid,aid,answer,location,score,support}}
- 错误输出：error:method未指定！  error:xxx

### /uploadFile POST 上传图片文件
- 输入：文件、method、id
- 成功输出：success
- 失败输出：failed
- 错误输出：error:xxx

### /downloadFile POST 下载图片文件
- 输入：fileName
- 成功输出：success、文件
- 失败输出：failed

### /LoginCheck POST 登陆验证
- 输入：uid、password
- 成功输出：uid
- 失败输出：failed
- 错误输出：error:xxx

### /signIn POST 注册
- 输入：age、major、password、name、sex
- 成功输出：uid
- 失败输出：failed
- 错误输出：error:xxx

### /getQuestionsByUid GET 通过uid获取问题
- 输入：uid
- 成功输出：HashSet\<Question\>{Question{qid,uid,content,category,describe,state,location,bestAnswer}}
- 失败输出：failed
- 错误输出：error:xxx

### /getAllQuestion GET 获取所有问题
- 输入：null
- 成功输出：HashSet\<Question\>{Question{qid,uid,content,category,describe,state,location,bestAnswer}}
- 失败输出：failed
- 错误输出：error:xxx

### /addQuestion GET 添加问题
- 输入：uid、content、category、describe
- 成功输出：qid
- 失败输出：failed
- 错误输出：error:xxx

### /getAQuestion GET 获取一个问题的内容
- 输入：qid
- 成功输出：Question{qid,uid,content,category,describe,state,location,bestAnswer}
- 失败输出：failed
- 错误输出：error:xxx

### /getAUser GET 获取一个用户的信息
- 输入：uid
- 成功输出：User{uid,name,password=null,sex,age,major}
- 失败输出：failed
- 错误输出：error:xxx