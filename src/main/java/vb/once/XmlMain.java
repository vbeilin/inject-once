package vb.once;

import lombok.val;

import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlMain {
    public static void main(String[] args) {
        val ctx = new GenericXmlApplicationContext("classpath:vb/once/ctx-a.xml");
//        ctx.refresh();
        for (String bn : ctx.getBeanDefinitionNames()) {
            System.out.println(bn + " : " +ctx.getBean(bn));
        }
        ctx.close();
    }
}
