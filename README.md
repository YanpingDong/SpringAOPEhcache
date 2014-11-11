Every package demonstrate one simple sample!! <br>

mvn version:3.0.4  <br>
eclipse version:kepler  <br>

============================================== <br>
com.test.spring.aop.ehcach <br>
integrate ehcach and spring useing spring aop tech <br>

============================================== <br>
com.test.spring.aspectj.aop <br>
this package show how to use Aspectj .JDK must be upper JDK 5.0 <br>

============================================== <br>
com.test.spring.aspectj.schema.aop <br>
use xml file to define aspect pointcut  <br>

============================================== <br>
com.test.spring.ltw.aspectj.aop  <br>
Note: can't run. I don't know why. so don't use this sample <br>

============================================== <br>
com.test.ehcache.listener <br>
use spring bean in ehcache listener <br>

============================================== <br>
com.test.ehcache.object <br>
demostrate how to stored non primitive type in ehcache and some notes <br>

============================================== <br>
com.test.spring.aspect.aop.ioc <br>
1.Sometime want to refer other object to extend the advisor. <br>
2.In this sample. PreGreetingAspect advisor refer BeInjectedObject2PreGreetingAspect <br>
to extend greetTo function of NaiveWaiter.  <br>
3.utilize spring ioc for PreGreetingAspect to auto inject BeInjectedObject2PreGreetingAspect <br>

============================================== <br>
com.test.ehcache.aspectj.dynamic.create.cahce <br>
One class can initiate many object. In this situation, it's hard to definitely  <br>
define a specified ehcache in ehcache.xml because each object should have his own cache <br>
and cann't know how many object will be created beforehand. <br>
In order to meet the requirements, need to dynamic create ehcache and in this sample <br>
will use aspectj to implement.  <br>