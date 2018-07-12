package com.baizhi.cmfz.util;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;;
import java.lang.reflect.Method;
import java.util.Date;
/**
 * 额外功能
 */

/**
 * 要获得 session 可以使用 com.opensymphony.xwork2.ActionContext
 * 也可以使用ThreadLocal
 * 也可以使用下面的方法
 */


//标记这是一个 额外功能类
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;
    /**
     * 声明切入点表达式(只记录 增删改 的 操作日志)
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..))||execution(* com.baizhi.cmfz.service.impl.*.modify*(..))")
    public void pc(){}
    /**
     * 管理员登入方法的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.ManagerServiceImpl.queryById(..))")
    public void loginCell(){}
    /**
     * 环绕通知
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        //得到原始方法的参数
        Object[] args = pjp.getArgs();
        String  param = args[0].toString();

        //得到方法的签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        String methodString = method.toString();
        if(methodString.contains("Log")){
            Object proceed = pjp.proceed();
            return proceed;
        }


        String resource = "";
        if(methodString.contains("Guru")){
            resource="Guru";
        }else if (methodString.contains("Article")){
            resource="Article";
        }else if(methodString.contains("Manager")) {
            resource = "Manager";
        }else if(methodString.contains("Menu")) {
            resource = "Menu";
        }else if(methodString.contains("Picture")) {
            resource = "Picture";
        }else if(methodString.contains("User")) {
            resource = "User";
        }else{
            resource="";
        }
        String methodName = method.getName();
        String name = "";
        if(methodName.contains("modify")){
            name="修改";
        }else if (methodName.contains("add")){
            name="添加";
        }else if (methodName.contains("query")){
            name="登录";
        }else{
            name="删除";
        }
        //调用传递，object:原始方法的返回值
        Object proceed = pjp.proceed();
        boolean object = (boolean) proceed;
        String result ="";
        if(object==true){
            result="success";
        }else{
            result = "fail";
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        //填充数据
        Log log = new Log();
        log.setTime(new Date());
        log.setAction(name);
        log.setMessage(param);
        log.setResult(result);
        log.setResource(resource);
        log.setUser(manager.getMgrname());
        logService.insetLogs(log);
        return proceed;
    }

    @AfterReturning(value = "loginCell()", argNames = "joinPoint,object", returning = "object")
    public void loginLog(JoinPoint joinPoint, Object object){
        Manager manager= (Manager) object;
        String user;
        if (manager==null){return;}
        //没有参数
        if (joinPoint.getArgs()==null){return;}
        user=manager.getMgrname();//获得管理员名字
        String methodname = joinPoint.getSignature().getName();//获取方法名
//        String classname = joinPoint.getSignature().getDeclaringType().getName();//操作类的类名
        String content = optionContent(joinPoint.getArgs(), methodname);
        Log log=new Log();
        log.setUser(user);
        log.setTime(new Date());
        log.setResource("Manager");
        log.setAction("管理员登入");
        log.setMessage(content);
        log.setResult("success");
        logService.insetLogs(log);
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
                rs.append("(" + methodName + ":" + rsValue.toString() + ")");
            }
            rs.append("]");
            index++;
        }
        return rs.toString();
    }
}
