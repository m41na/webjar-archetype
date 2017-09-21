#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jarredweb.webjar.web.config.WebjarSpringContext;

@Configuration
@ComponentScan({ "${package}.ctx"})
public class AppCtxConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppCtxConfig.class);

	private static AnnotationConfigApplicationContext ctx;

	public static AnnotationConfigApplicationContext getAnnotationConfigApplicationContext() {
		if (ctx == null) {
			AnnotationConfigApplicationContext parentContext = WebjarSpringContext.getAnnotationConfigApplicationContext();
			
			ctx = new AnnotationConfigApplicationContext(AppCtxConfig.class);
			ctx.setParent(parentContext);
			ctx.setClassLoader(parentContext.getClassLoader());
			ctx.registerShutdownHook();
			LOGGER.info("{} context created", AppCtxConfig.class.getName());
		}
		return ctx;
	}
}
