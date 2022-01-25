package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyBeanDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MyBeanDemoApplication.class, args);
		ctx.getBean(MyBean.class).doSomething();
		System.out.println(ctx.getBean(MyBean.class).hashCode());

		MyBean myBean = ctx.getBean("newMyBean", MyBean.class);
		System.out.println(myBean.hashCode());

		MyBean myBean1 = (MyBean) ctx.getBean("newMyBean");
		System.out.println(myBean1.hashCode());

		ctx.getBean(MySecondBean.class);
		System.out.println(ctx.getBean(MySecondBean.class).hashCode());

		// this how we normally do it
		MyBean bean1 = new MyBean();
		bean1.doSomething();
		System.out.println(bean1.hashCode());

	}

}
