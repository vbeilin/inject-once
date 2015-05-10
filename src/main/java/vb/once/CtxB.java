package vb.once;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CtxD.class)
public class CtxB {
    @Bean Marker b0() { return new Marker("b0"); }
    @Bean Marker b1() { return new Marker("b1"); }
}
