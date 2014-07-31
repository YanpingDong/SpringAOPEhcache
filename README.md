Every package demonstrate one simple sample!!

mvn version:3.0.4
eclipse version:kepler

==============================================
com.test.spring.aop.ehcach
integrate ehcach and spring useing spring aop tech

==============================================
com.test.spring.aspectj.aop
this package show how to use Aspectj .JDK must be upper JDK 5.0

==============================================
com.test.spring.aspectj.schema.aop
use xml file to define aspect pointcut 

==============================================
com.test.spring.ltw.aspectj.aop 
Note: can't run. I don't know why. so don't use this sample

==============================================
com.test.ehcache.listener
use spring bean in ehcache listener

==============================================
com.test.ehcache.object
demostrate how to stored non primitive type in ehcache and some notes

==============================================
com.test.spring.aspect.aop.ioc
1.Sometime want to refer other object to extend the advisor.
2.In this sample. PreGreetingAspect advisor refer BeInjectedObject2PreGreetingAspect
to extend greetTo function of NaiveWaiter. 
3.utilize spring ioc for PreGreetingAspect to auto inject BeInjectedObject2PreGreetingAspect

==============================================
com.test.ehcache.aspectj.dynamic.create.cahce
One class can initiate many object. In this situation, it's hard to definitely 
define a specified ehcache in ehcache.xml because each object should have his own cache
and cann't know how many object will be created beforehand.
In order to meet the requirements, need to dynamic create ehcache and in this sample
will use aspectj to implement. 