package az.edu.ada.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut("execution (* az.edu.ada.controller..*(..)) || execution (* az.edu.ada.service..*(..))")
    public void applicationLayer() {}

    @Before("applicationLayer()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering: {}.{}()",
            joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }
    @AfterReturning(pointcut = "applicationLayer()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

    }

    @AfterThrowing(pointcut = "applicationLayer()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("Exception: {}.{}() - {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ex.getMessage());
    }
    @Around("execution(* az.edu.ada.service.impl.StudentServiceImpl.create(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - start;

        log.info("Execution time of {}: {} ms",
                joinPoint.getSignature().getName(),
                timeTaken);
        return result;
    }
}
