package cn.xutingyin.mybatisplus.aspect;

import cn.xutingyin.mybatisplus.annotations.OperationLogAnnotation;
import groovy.util.logging.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: 操作日志切面
 * @Author: xuty
 * @Date: 2019/9/6 16:43
 * @Aspect 表示该类为一个切面类,它时org.aspectj.lang.annotation 包中定义的内容。
 *
 */

@Aspect
@Component
@Slf4j
public class OperationLogAspect {
    private Logger LOG = LoggerFactory.getLogger(OperationLogAspect.class);

    /**
     * 切点：表明在什么地方执行这个方法
     * execution(* cn.xutingyin.mybatisplus.controller..*.*(..))
     * 第一个 * 表示任意的方法返回类型
     * 第二个 * 表示任意类
     * 第三个 * 表示任意方法
     */
    @Pointcut("execution(* cn.xutingyin.mybatisplus.controller..*.*(..))")
    public void webLog(){};


    @Before("webLog()")
    public void doBefore(){
        LOG.info("Before Test");
    }

    @After("webLog()")
    public void doAfter(){
        LOG.info("After Test");
    }

    /** @Around 等价于 @Before + @After 两者的结合， ProceedingJoinPoint.poceed() 方法前后*/
    @Around("webLog()")
    public Object doAraound(ProceedingJoinPoint jp) throws Throwable {
        Signature sig = jp.getSignature();
        Method currentMethod = null;
        if (sig instanceof MethodSignature) {
            MethodSignature msig = (MethodSignature) sig;
            currentMethod = jp.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());

            Object annotationObj = currentMethod.getAnnotation(OperationLogAnnotation.class);
            if(annotationObj != null) {
                LOG.info("--------:"+currentMethod.getName());
            }
        }
        LOG.info("{} 方法执行前",currentMethod.getName());
        Object returnObj = jp.proceed();
        LOG.info("{} 方法执行后",currentMethod.getName());
        return  returnObj;
    }

}
