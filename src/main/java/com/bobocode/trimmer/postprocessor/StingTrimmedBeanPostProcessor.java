package com.bobocode.trimmer.postprocessor;

import com.bobocode.trimmer.annotation.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


public class StingTrimmedBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Trimmed.class)) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass );
            MethodInterceptor methodInterceptor = (obj, method, args, methodProxy) -> {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].getClass().isAssignableFrom(String.class)) {
                        args[i] = ((String) args[i]).trim();
                    }
                }
                Object result = methodProxy.invokeSuper(obj, args);
                if (method.getReturnType().isAssignableFrom(String.class)) {
                    return ((String) result).trim();
                }
                return result;
            };
            enhancer.setCallback(methodInterceptor);
            return enhancer.create();
        }
        return bean;
    }

}
