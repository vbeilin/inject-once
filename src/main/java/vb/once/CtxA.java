package vb.once;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CtxB.class, CtxC.class})
public class CtxA {
    @Bean Marker a0() { return new Marker("a0"); }
    @Bean Marker a1() { return new Marker("a1"); }
    @Bean Marker a() { return new Marker("a"); }
}
