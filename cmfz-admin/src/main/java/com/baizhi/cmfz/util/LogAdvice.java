package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志额外功能工具类
 * Created by Administrator on 2018/7/9.
 */
@Aspect
public class LogAdvice {



    @Autowired
    private LogService logService;

    /**
     * 管理员登入方法的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.ManagerServiceImpl.queryByIdandPwd(..))")
    public void loginCell(){}

    /**
     * 添加操作的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.add*(..))")
    public void insertCell(){}

    /**
     * 修改操作的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.modify*(..))")
    public void updateCell(){}

    /**
     * 删除操作的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.remove*(..))")
    public  void deleteCell(){}

    @AfterReturning(value = "loginCell()", argNames = "joinPoint,object", returning = "object")
    public void loginLog(JoinPoint joinPoint, Object object){
        String user;
        Manager manager= (Manager) object;
        if (manager==null){return;}
        //没有参数
        if (joinPoint.getArgs()==null){return;}
        user=manager.getMgrname();//获得管理员名字
        String methodname = joinPoint.getSignature().getName();//获取方法名
        String classname = joinPoint.getSignature().getDeclaringType().getName();//操作类的类名
        String content = optionContent(joinPoint.getArgs(), methodname);
        Log log=new Log();
        log.setUser(user);
        log.setTime(new Date());
        log.setResource(classname);
        log.setAction("管理员登入");
        log.setMessage(content);
        System.out.println("----------------------"+log+"----------------------------");
        Integer integer = logService.insetLogs(log);
        System.out.println("---------------------------------"+integer+"-----------------------------------------");
    }

    public String optionContent(Object[] args, String mName) {
        if (args == null) {
            return null;
        }
        StringBuffer rs = new StringBuffer();
        rs.append(mName);
        String className = null;
        int index = 1;
        // 遍历参数对象
        for (Object info : args) {
            // 获取对象类型
            className = info.getClass().getName();
            className = className.substring(className.lastIndexOf(".") + 1);
            rs.append("[参数" + index + "，类型:" + className + "，值:");
            // 获取对象的所有方法
            Method[] methods = info.getClass().getDeclaredMethods();
            // 遍历方法，判断get方法
            for (Method method : methods) {
                String methodName = method.getName();
                // 判断是不是get方法
                if (methodName.indexOf("get") == -1) {// 不是get方法
                    continue;// 不处理
                }
                Object rsValue = null;
                try {
                    // 调用get方法，获取返回值
                    rsValue = method.invoke(info);
                } catch (Exception e) {
                    continue;
                }
                // 将值加入内容中
                rs.append("(" + methodName + ":" + rsValue + ")");
            }
            rs.append("]");
            index++;
        }
        return rs.toString();
    }

}
