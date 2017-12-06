package pl.michal.olszewski.queue.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.michal.olszewski.queue.rabbit.ValueObject;

@Component
@Slf4j
public class JmsConsumer {

  @JmsListener(destination = "valueObjects", containerFactory = "myFactory")
  public void receiveMessage(ValueObject object) {
    log.info("Received <" + object + ">");
  }

}
