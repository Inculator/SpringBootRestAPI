package com.mg.activemq.controller

import com.mg.activemq.receiver.MessageReceiver
import com.mg.activemq.sender.MessageSender
import org.apache.activemq.ActiveMQConnection
import org.apache.activemq.ActiveMQConnectionFactory
import java.util.concurrent.CountDownLatch
import javax.jms.Connection
import javax.jms.ConnectionFactory


var messageSender = MessageSender()
var messageReceiver = MessageReceiver()

private val url: String = ActiveMQConnection.DEFAULT_BROKER_URL
private lateinit var connection: Connection

var latch = CountDownLatch(2)


class ControllSenderReceiver() {

    init {
        val connectionFactory: ConnectionFactory = ActiveMQConnectionFactory(url)
        connection = connectionFactory.createConnection()
        connection.start()
    }
}

fun main() {
    try {
        ControllSenderReceiver()
        var t1 = Thread(SenderControllerThread(messageSender, connection, latch))
        var t2 = Thread(ReceiverControllerThread(messageReceiver, connection, latch))

        t1.start()
        t2.start()

        latch.await()
    } catch (e: Exception) {
        connection.close()
    } finally {
        connection.close()
    }
}