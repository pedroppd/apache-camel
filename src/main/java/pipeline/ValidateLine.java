package pipeline;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class ValidateLine implements Processor {

    private List<String> validHeaders = List.of("id", "first_name", "last_name", "email", "gender", "ip_address");

    /**
     * Validate line by line.
     *
     * @param Exchange exchange
     * @return Void
     */
    @Override
    public void process(Exchange exchange) {
        var m = exchange.getIn();
        String header = exchange.getMessage().getBody(String.class);
    }
}
