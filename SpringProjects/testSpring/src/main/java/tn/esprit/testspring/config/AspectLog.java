package tn.esprit.testspring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectLog {

    @After("execution( * tn.esprit.testspring.services.*.*.get*(..))")
    public void getStatic() {
        log.info("Bon courage!");
    }
}
