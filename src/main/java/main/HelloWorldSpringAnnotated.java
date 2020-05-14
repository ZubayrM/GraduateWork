package main;

import main.HelloWorldConfiguration;
import main.inter.MessageProvider;
import main.inter.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation
        .AnnotationConfigApplicationContext;
public class HelloWorldSpringAnnotated {

    public static void main(String... args){
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
//        mr.render();

        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        mr.setMessageProvider(mp);
        mr.rederer();


        }
}