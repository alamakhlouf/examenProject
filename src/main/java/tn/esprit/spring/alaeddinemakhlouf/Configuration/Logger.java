package tn.esprit.spring.alaeddinemakhlouf.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j

public class Logger {

    @AfterReturning("execution(* tn.esprit.spring.alaeddinemakhlouf.Service.*.ajouter*(..))")
    public void logMethodExitReturning(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();
        log.info("The add worked successfully");
    }

    @After("execution(* tn.esprit.spring.alaeddinemakhlouf.Service.ServiceImpl.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Exit method " + name + " : ");
    }

    @AfterThrowing("execution(* tn.esprit.spring.alaeddinemakhlouf.Service.ServiceImpl.*.*(..))")
    public void logMethodExitThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Exit method error " + name + " : ");
    }

    @Before("execution(* tn.esprit.spring.alaeddinemakhlouf.Service.ServiceImpl.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }


    @Around("execution(* tn.esprit.spring.alaeddinemakhlouf.Service.ServiceImpl.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;}

}