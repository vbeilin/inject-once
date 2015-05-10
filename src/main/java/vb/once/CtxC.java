package vb.once;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CtxD.class)
public class CtxC {
    @Bean Marker c0() { return new Marker("c0"); }
    @Bean Marker c1() { return new Marker("c1"); }
}
