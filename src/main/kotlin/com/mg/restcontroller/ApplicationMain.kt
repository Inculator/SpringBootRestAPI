package com.mg.restcontroller

import com.sun.glass.ui.Application
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ApplicationMain

fun main(args: Array<String>) {

    SpringApplication.run(ApplicationMain::class.java, *args)
}