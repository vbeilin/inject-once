package vb.once;

import lombok.val;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class OnceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("import", new ImportDefinitionParser());
    }

    private static class ImportDefinitionParser implements BeanDefinitionParser {

        @Override
        public BeanDefinition parse(Element element, ParserContext parserContext) {
            XmlReaderContext rctx = parserContext.getReaderContext();
            String location = element.getAttribute("resource");
            if (!StringUtils.hasText(location)) {
                rctx.error("Resource location must not be empty", element);
                return null;
            }

            location = rctx.getEnvironment().resolveRequiredPlaceholders(location);
            String key = "import-once/"+location;
            if (!parserContext.getRegistry().containsBeanDefinition(key)) {
                int n = rctx.getReader().loadBeanDefinitions(location);
                System.out.println(n + " beans loaded from " + location);
                val bd = new RootBeanDefinition(OnceToken.class);
                parserContext.getRegistry().registerBeanDefinition(key, bd);
            }
            return null;
        }

    }

}
