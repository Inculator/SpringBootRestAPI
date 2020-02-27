package com.mg.activemq.controller

import com.mg.activemq.sender.MessageSender
import java.util.concurrent.CountDownLatch
import javax.jms.Connection

class SenderControllerThread : Runnable {

    private var messageSender: MessageSender
    private var connection: Connection
    private var latch: CountDownLatch

    constructor(
        messageSender: MessageSender,
        connection: Connection,
        latch: CountDownLatch
    ) {
        this.messageSender = messageSender
        this.connection = connection
        this.latch = latch
    }

    override fun run() {
        messageSender.sendMessage(connection, latch);
    }

}