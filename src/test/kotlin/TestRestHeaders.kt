import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.apache.tomcat.jni.Lock.name
import java.net.HttpURLConnection
import java.net.URL
import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import org.junit.Assert
import org.junit.Test
import org.springframework.boot.test.context.TestComponent
import java.io.InputStreamReader
import java.io.BufferedReader



class TestRestHeaders {

    @Test
    fun testMyRestAPI(){
        var url: URL = URL("http://localhost:9090/getProducts/3");
        var conn =  url.openConnection()
        conn.setRequestProperty("method", "POST")
        conn.setRequestProperty("Accept", "application/json")
        conn.setRequestProperty("myHeader", "ABC")

        val br = BufferedReader(
            InputStreamReader(
                conn.getInputStream()
            )
        )

        println("Output from Server .... \n")
        var list = br.readLines()
        Assert.assertEquals("{\"productId\":3,\"productName\":\"Khadi Rosewater\",\"productPrice\":130}",
            list.get(0))
    }
}