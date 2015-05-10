package vb.once;

import lombok.val;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoMain {
    public static void main(String[] args) {
        val ctx = new AnnotationConfigApplicationContext(CtxA.class);
//        ctx.refresh();
        for (String bn : ctx.getBeanDefinitionNames()) {
            System.out.println(bn + " : " +ctx.getBean(bn));
        }
        ctx.close();
    }
}
