package pipeline;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ValidateLine implements Processor {
    @Override
    public void process(Exchange exchange) {
        Object line = exchange.getMessage().getBody();
        System.out.println(line.toString());
    }
}
