package org.acme;

import eu.rekawek.toxiproxy.model.ToxicDirection;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kafka.InjectKafkaCompanion;
import io.quarkus.test.kafka.InjectKafkaProxy;
import io.quarkus.test.kafka.ProxiedKafkaCompanionResource;
import io.smallrye.reactive.messaging.kafka.companion.ConsumerTask;
import io.smallrye.reactive.messaging.kafka.companion.KafkaCompanion;
import io.smallrye.reactive.messaging.kafka.companion.test.KafkaProxy;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@QuarkusTestResource(ProxiedKafkaCompanionResource.class)
public class MyToxiProxyTest {

    Logger logger = LoggerFactory.getLogger(MyToxiProxyTest.class);

    @InjectKafkaProxy
    KafkaProxy proxy;

    @InjectKafkaCompanion
    KafkaCompanion companion;

    @Test
    void testProcessor() throws IOException {

        proxy.toxi.toxics().bandwidth("CUT_CONNECTION_UPSTREAM", ToxicDirection.UPSTREAM, 0L);
        proxy.toxi.toxics().bandwidth("CUT_CONNECTION_DOWNSTREAM", ToxicDirection.DOWNSTREAM, 0L);

        // companion = new KafkaCompanion(proxy.getProxyBootstrapServers());

        logger.info("toxics: {}", proxy.toxi.toxics().getAll());

        // the following is expected to fail because of cut connection

        companion.produceStrings().usingGenerator(i -> new ProducerRecord<>("words", UUID.randomUUID().toString()));

        // Expect that the tested application processes orders from 'orders' topic and write to 'orders-processed' topic

        ConsumerTask<String, String> orders = companion.consumeStrings().fromTopics("words", 10);
        boolean success;
        try {
            orders.awaitCompletion(); // this should fail, as we expect to go through the toxiproxy
            assertEquals(10, orders.count());
            success = false;
            logger.error("messages have been received, which is wrong");
        } catch (AssertionError e) {
            success = true;
            logger.info("messages did not get received, which is correct");
        }
        Assertions.assertTrue(success);
    }
}
