package net.golovach.eshop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleProfiler {
    //ProceedingJoinPoint - аналог вызова любого метода? (как reflection?)
    public Object profile(ProceedingJoinPoint call, int id) throws Throwable {
        long t1 = System.nanoTime();
        try{
            return call.proceed();
        } finally {
            long t2 = System.nanoTime();
            System.out.println("ASPECT.PROFILER: " + call.toShortString() + " dT: " + (t2-t1) + " ns");
        }

    }
}
