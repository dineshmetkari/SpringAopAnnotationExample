# SpringAopAnnotationExample
Using Annotation

<hr>
<ul>
<li>@Before – Run before the method execution</li>
<li>@After – Run after the method returned a result</li>
<li>@AfterReturning – Run after the method returned a result, intercept the returned result as well.</li>
<li>@AfterThrowing – Run after the method throws an exception</li>
<li>@Around – Run around the method execution, combine all three advices above.</li>
</ul>
<b>Enable AspectJ :</b><br>
In Spring configuration file, put ``<aop:aspectj-autoproxy />``, and define your Aspect (interceptor) and normal bean.

<b>Declaring an aspect:</b><br>
```java
package org.xyz;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectModule {

}
```
<b>Declaring a pointcut:</b><br>
```java
import org.aspectj.lang.annotation.Pointcut;

@Pointcut("execution(* com.xyz.myapp.service.*.*(..))") // expression 
private void businessService() {}  // signature
```
<b>Declaring advices:</b><br>
```java
@Before("businessService()")
public void doBeforeTask(){
 ...
}

@After("businessService()")
public void doAfterTask(){
 ...
}

@AfterReturning(pointcut = "businessService()", returning="retVal")
public void doAfterReturnningTask(Object retVal){
  // you can intercept retVal here.
  ...
}

@AfterThrowing(pointcut = "businessService()", throwing="ex")
public void doAfterThrowingTask(Exception ex){
  // you can intercept thrown exception here.
  ...
}

@Around("businessService()")
public void doAroundTask(){
 ...
}
```
