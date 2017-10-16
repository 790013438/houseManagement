package snippets.jee.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HintAspect {

    @Before("execution(* snippets.jee.aspectj.Ultraman.attack(..))")
    public void beforeAttack() {
        System.out.println("使用必杀技");
    }

}
