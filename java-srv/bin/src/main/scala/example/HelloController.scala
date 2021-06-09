package example;

import org.springframework.web.bind.annotation.{RestController, RequestParam};
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicLong;

@RestController
class HelloController(val registry: MeterRegistry) {

    val template: String = "Hello, %s!";
    val counter: AtomicLong = new AtomicLong();


    /**
     * The @Timed annotation adds timing support, so we can see how long
     * it takes to execute in Prometheus
     * percentiles
     */
    @Timed(value = "greeting.time", description = "Time taken to return greeting", percentiles = Array(0.5, 0.90))
    def greeting(@RequestParam(value = "name", defaultValue = "World") name: String): String = {
      counter.incrementAndGet();
      return String.format(template, name);
    }

}
