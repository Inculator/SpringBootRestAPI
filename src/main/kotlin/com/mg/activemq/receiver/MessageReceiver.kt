package com.mg.activemq.receiver

import org.apache.activemq.ActiveMQConnection
import java.util.concurrent.CountDownLatch
import javax.jms.*

class MessageReceiver {
    // URL of the JMS server
// default broker URL is : tcp://localhost:61616"

    @Throws(JMSException::class)
//    @JvmStatic
    fun receiveMessage(connection: Connection, latch: CountDownLatch) { // Getting JMS connection from the server
        // Creating session for seding messages
        val session: Session = connection.createSession(
            false,
            Session.AUTO_ACKNOWLEDGE
        )
        // Getting the queue 'JCG_QUEUE'
        val destination: Destination = session.createQueue(Companion.subject)
        // MessageConsumer is used for receiving (consuming) messages
        val consumer: MessageConsumer = session.createConsumer(destination)
        // Here we receive the message.
        var counter = 1;
        while (counter <= 100) {
            val message: Message = consumer.receive()
            // We will be using TestMessage in our example. MessageProducer sent us a TextMessage
// so we must cast to it to get access to its .getText() method.
            if (message is TextMessage)
                println(" ****** Received message '" + message.text + "'")
            counter++
        }

        latch.countDown()
    }

    companion object {
        // default broker URL is : tcp://localhost:61616"
        // Name of the queue we will receive messages from
        private const val subject = "JCG_QUEUE"
        private const val url = ActiveMQConnection.DEFAULT_BROKER_URL
    }
}