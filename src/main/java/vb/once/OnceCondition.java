package vb.once;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

public class OnceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String key = "OnceCondition/" + annotatedElementKey(metadata);
        if (context.getRegistry().containsBeanDefinition(key)) {
            return false;
        } else {
            context.getRegistry().registerBeanDefinition(key, new RootBeanDefinition(OnceToken.class));
            return true;
        }
    }

    private String annotatedElementKey(AnnotatedTypeMetadata metadata) {
        if (metadata instanceof AnnotationMetadata) {
            return ((AnnotationMetadata) metadata).getClassName();
        } else if (metadata instanceof MethodMetadata) {
            return ((MethodMetadata) metadata).getDeclaringClassName() + "#" + ((MethodMetadata) metadata).getMethodName();
        } else
            throw new IllegalArgumentException("Unsupported type of metadata: " + metadata);
    }

}
