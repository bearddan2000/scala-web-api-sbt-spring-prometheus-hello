package example

import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Bean;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
@EnableAutoConfiguration
@ComponentScan
class Main
{
	/**
	 * This is required so that we can use the @Timed annotation
	 * on methods that we want to time.
	 * See: https://micrometer.io/docs/concepts#_the_timed_annotation
	 */
	@Bean
	def timedAspect(registry: MeterRegistry): TimedAspect = {
		return new TimedAspect(registry);
	}
}

object Application extends App {
  SpringApplication.run(classOf[Main]);
}
