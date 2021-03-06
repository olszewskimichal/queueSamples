package pl.michal.olszewski.queue.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("rabbit")
public class Consumer implements MessageListener {

  @Override
  public void onMessage(Message message) {
    System.out.println(new String(message.getBody()));
  }
}