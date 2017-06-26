# 教务处 API

## 基本

http://202.118.31.241:8080/api/v1  
除登录都要传入token，token登录时获得

## 登录

    /login
GET  
参数：  

- userName 学号
- passwd 密码的**md5**

返回值举例：

    {
        "success":"0",
        "errCode":"",
        "errMsg":"",
        "data":
        {
            "token":"201602262030060860007162412",
            "userName":"20155134",
            "realName":"李昂",
            "isTeacher":"0"
        }
    }
    
## 分数 GET

    /score/学期（15/16）
    
