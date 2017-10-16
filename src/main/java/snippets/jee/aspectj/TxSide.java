package snippets.jee.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxSide {

    @Around("execution(* snippets.jee.mock.dao.*.*(..))")
    public Object doTransaction (ProceedingJoinPoint jp) throws Throwable {

        Object retVal = null;
        try {
            System.out.println("开启交易");
            retVal = jp.proceed(jp.getArgs());
            System.out.println("提交交易");
        } catch (Exception e) {
            System.out.println("交易失败，恢复meeting前的状态");
            throw e;
        } finally {
            System.out.println("关闭交易");
        }
        return retVal;
    }
}
