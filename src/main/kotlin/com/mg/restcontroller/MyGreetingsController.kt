package com.mg.restcontroller

import com.mg.restData.Greetings
import com.mg.restData.Product
import com.mg.restData.Products
import org.springframework.web.bind.annotation.*
import javax.xml.ws.WebServiceClient

@RestController
class MyGreetingsController {

    @GetMapping("/hello")
    fun helloWorld() = Greetings("Mohak", "Hello Mohak")

    @RequestMapping("/getProducts")
    fun getProducts(): ArrayList<Product> {
        Products.makeList()
        return Products.myList
    }

    @RequestMapping("/getProducts/{id}")
    fun getProductsBasedOnId(
        @PathVariable("id") id: Int, @RequestHeader(name = "myHeader", required = true) header: String)
            : Product {
        if(header.equals("ABC")) {
            Products.makeList()
            return Products.myList.stream().filter{product -> product.productId == id}.findFirst().get()
        }
        return Product(0, "This is an invalid product", productPrice = 0)
    }
}