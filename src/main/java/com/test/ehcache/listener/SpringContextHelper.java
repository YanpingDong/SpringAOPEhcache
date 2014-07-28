package com.test.ehcache.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHelper implements ApplicationContextAware {
    
	private static final Log logger = LogFactory.getLog(SpringContextHelper.class);
	
	private static ApplicationContext context;
	
	//提供一个接口，获取容器中的Bean实例，根据名称获取
    public static Object getBean(String beanName)
    {
    	if(context != null)
    	{
            return context.getBean(beanName);
    	}
    	else
    	{
    		logger.error("context must be initialized");;
    		return null;
    	}
    }

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context = arg0;
	}

}
