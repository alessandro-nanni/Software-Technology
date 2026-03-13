package nl.cofano.calculator.app;

import nl.cofano.calculator.integrations.response.CalculatorResponse;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ResultReceiver {

    @Autowired
    private Terminal terminal;

    @JmsListener(destination = "${queue.results}")
    public void receiveMessage(CalculatorResponse calculatorResponse) {
        terminal.writer().println();
        terminal.writer().write(calculatorResponse.getCalculationString());
        terminal.writer().println();
        terminal.writer().flush();
    }
}
