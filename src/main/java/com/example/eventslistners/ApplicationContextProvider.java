package com.example.eventslistners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ApplicationContextProvider {

    private static ApplicationContext context;

    public ApplicationContextProvider(ApplicationContext context){
        ApplicationContextProvider.context = context;
    }

    public static ApplicationContext getContext() {
        if (Objects.isNull(ApplicationContextProvider.context)) {
            throw new IllegalStateException("Context isn't available!");
        }
        return ApplicationContextProvider.context;
    }

    public static <E> E getBean(Class<E> bean){
        return getContext().getBean(bean);
    }
}

