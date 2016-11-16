package my

import io.vertx.core.*
import io.vertx.kotlin.core.http.HttpServerOptions

fun main(args: Array<String>) {
  val vertx = Vertx.vertx()
  vertx.deployVerticle(Server())
}

class Server : AbstractVerticle() {

  override fun start() {
    vertx.createHttpServer(
        HttpServerOptions(
            port = 8080,
            host = "localhost"
        ))
        .requestHandler() { req ->
          req.response().end("Hello from Kotlin")
        }
        .listen()
    print("Server started on 8080")
  }
}
