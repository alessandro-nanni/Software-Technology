package nl.cofano.calculator.app;

import nl.cofano.calculator.integrations.task.CalculatorTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CalculateCommands {

    // Spring JMS is used for connection with the messagequeue
    // More information can be found here: https://spring.io/guides/gs/messaging-jms
    @Autowired private JmsTemplate jmsTemplate;

    // The @value property is getting the value out of the backend/src/resources/application.properties directory.
    // More information about @value can be found here: https://www.baeldung.com/spring-value-annotation
    @Value("${queue.multiply}") private String multiplyQueue;


    // We are using Spring Shell to create a shell to operate the calculator,
    // More information can be found here: https://docs.spring.io/spring-shell/reference/commands/registration/legacyannotation.html
    @ShellMethod("Multiply two numbers")
    public String multiply(
      double a,
      double b
    ) {
        CalculatorTask task = new CalculatorTask();
        task.setNumber1(a);
        task.setNumber2(b);
        jmsTemplate.convertAndSend(multiplyQueue, task);

        return "Requested multiply";
    }
}
