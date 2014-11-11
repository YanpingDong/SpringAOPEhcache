package com.test.spring.ehcache.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Run this sample have to change the POM.xml
 */
@Configuration
@EnableCaching
@EnableAutoConfiguration
public class TestClient {

    private static final Logger log = LoggerFactory.getLogger(TestClient.class);

    private static ApplicationContext context;
    
    @Configuration
    static class Runner implements CommandLineRunner {
        @Autowired
        private BookRepository bookRepository;

        @Override
        public void run(String... args) throws Exception {
            log.info(".... Fetching books");
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        }
    }

    @Bean
    public BookRepository bookRepository() {
        return new SimpleBookRepository();
    }

    @Bean
    public CacheManager cacheManager() {
    	/*
    	 * JDK ConcurrentMap-based Cache
    	 */
        return new ConcurrentMapCacheManager("books");
    }

    public static void main(String[] args) {
        /*
         * Java based configuration. use JDK ConcurrentMap-based Cache
         */
    	SpringApplication.run(TestClient.class, args);
    	
    	/*
    	 * XML scheme based configuration, use ehcahe
    	 */
    	String DEFAULT_CONTEXT_FILE = "/InnotationSpringEhcacheContext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);  
        
        /*
         * context.getBean(SimpleBookRepository.class) can't get SimpleBookRepository
         * object, throw NoSuchBeanDefinitionException; because it has change 
         * by Spring AOP mechanism so there use a proxy object to
         * invoke SimpleBookRepository though spring Autowired method to inject
         * a SimpleBookRepository object to SimpleBookRepositoryProxy
         * OR convert bean to Interface
         */
        BookRepository sbrp1 = (BookRepository)context.getBean("simpleBookRepository");
        log.debug(sbrp1.getByIsbn("isbn").toString());
        SimpleBookRepositoryProxy sbrp = context.getBean(SimpleBookRepositoryProxy.class);
        sbrp.invoke();
    }
}
