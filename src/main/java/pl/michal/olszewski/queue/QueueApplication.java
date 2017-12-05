package pl.michal.olszewski.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.michal.olszewski.queue.rabbit.RabbitConfig;
import pl.michal.olszewski.queue.rabbit.ValueObject;

@SpringBootApplication
public class QueueApplication implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;

  public QueueApplication(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public static void main(String[] args) {
    SpringApplication.run(QueueApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
   /* System.out.println("Sending message...");
    rabbitTemplate.convertAndSend(RabbitConfig.queueName, "Hello from RabbitMQ!");
    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);*/

    rabbitTemplate.convertAndSend(RabbitConfig.queueName, ValueObject.builder().name("nazwa").build());
  }
}
