package vb.once;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Conditional(OnceCondition.class)
public class CtxD {
    @Bean Marker d() { return new Marker("d"); }
}
