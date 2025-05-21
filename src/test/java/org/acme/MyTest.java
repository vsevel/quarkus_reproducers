package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kafka.InjectKafkaCompanion;
import io.quarkus.test.kafka.KafkaCompanionResource;
import io.quarkus.test.kafka.ProxiedKafkaCompanionResource;
import io.smallrye.reactive.messaging.kafka.companion.ConsumerTask;
import io.smallrye.reactive.messaging.kafka.companion.KafkaCompanion;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@QuarkusTestResource(KafkaCompanionResource.class)
@Disabled
public class MyTest {

    @InjectKafkaCompanion
    KafkaCompanion companion;

    @Test
    void testProcessor() {

        companion.produceStrings().usingGenerator(i -> new ProducerRecord<>("words", UUID.randomUUID().toString()));

        // Expect that the tested application processes orders from 'orders' topic and write to 'orders-processed' topic

        ConsumerTask<String, String> orders = companion.consumeStrings().fromTopics("words", 10);
            orders.awaitCompletion(); // this should fail, as we expect to go through the toxiproxy
            assertEquals(10, orders.count());
    }

}
