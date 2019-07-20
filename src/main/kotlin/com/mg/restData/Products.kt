package com.mg.restData

object Products {
        var myList: ArrayList<Product> = ArrayList()
        fun makeList() {
            myList.add(Product(1,"Khadi Hair cleanser", 120))
            myList.add(Product(2,"Khadi Hair serun", 198))
            myList.add(Product(3,"Khadi Rosewater", 130))
            myList.add(Product(4,"Khadi Lavender Soap", 60))
        }
}