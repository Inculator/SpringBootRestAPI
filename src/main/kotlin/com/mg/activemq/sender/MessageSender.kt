package com.mg.activemq.sender

import java.util.concurrent.CountDownLatch
import javax.jms.*


class MessageSender {
    //URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost

    @Throws(JMSException::class)
//    @JvmStatic
    fun sendMessage(
        connection: Connection,
        latch: CountDownLatch
    ) { // Getting JMS connection from the server and starting it

        for (i in 1..100) {

            val session: Session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE
            )
            //Destination represents here our queue 'JCG_QUEUE' on the JMS server.
//The queue will be created automatically on the server.
            val destination: Queue? = session.createQueue(Companion.subject)
            // MessageProducer is used for sending messages to the queue.
            val producer: MessageProducer = session.createProducer(destination)
            // We will send a small text message saying 'Hello World!!!'
            val message: TextMessage = session
                .createTextMessage("Hello !!! Welcome to the world of ActiveMQ.")
            // Here we are sending our message!
            producer.send(message)
            System.out.println("JCG printing@@ '" + message.getText().toString() + "'")
        }
        latch.countDown()
    }

    companion object {
        // default broker URL is : tcp://localhost:61616"
        private const val subject =
            "JCG_QUEUE" // Queue Name.You can create any/many queue names as per your requirement.
    }
}