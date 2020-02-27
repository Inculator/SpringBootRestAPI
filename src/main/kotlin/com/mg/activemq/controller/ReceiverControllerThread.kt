package com.mg.activemq.controller

import com.mg.activemq.receiver.MessageReceiver
import java.util.concurrent.CountDownLatch
import javax.jms.Connection

class ReceiverControllerThread : Runnable {

    private var messageReceiver: MessageReceiver
    private var connection: Connection
    private var latch: CountDownLatch

    constructor(
        messageReceiver: MessageReceiver,
        connection: Connection,
        latch: CountDownLatch
    ) {
        this.messageReceiver = messageReceiver
        this.connection = connection
        this.latch = latch
    }

    override fun run() {
        messageReceiver.receiveMessage(connection, latch)
    }

}