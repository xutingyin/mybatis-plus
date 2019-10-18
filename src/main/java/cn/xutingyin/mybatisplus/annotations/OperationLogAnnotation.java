package cn.xutingyin.mybatisplus.annotations;


import java.lang.annotation.*;


/** 
* @Description: 操作日志注解
* @Author: xuty 
* @Date: 2019/9/6 16:58
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OperationLogAnnotation {

    String name() default  "";
    boolean intoDb() default false;

}
