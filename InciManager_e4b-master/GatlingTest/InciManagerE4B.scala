
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class InciManagerE4B extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("InciManagerE4B")
		.exec(http("request_0")
			.get("/login")
			.headers(headers_0))
		.pause(8)
		.exec(http("request_1")
			.post("/login")
			.headers(headers_0)
			.formParam("userid", "paco@hotmail.com")
			.formParam("password", "123456"))
		.pause(22)
		.exec(http("request_2")
			.post("/incidence/add")
			.headers(headers_0)
			.formParam("incidenceName", "Incidencia Gatling")
			.formParam("descripcion", "Gatling")
			.formParam("latitude", "562656")
			.formParam("longitude", "596592"))
		.pause(4)
		.exec(http("request_3")
			.get("/")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_4")
			.get("/incidence/chatbot")
			.headers(headers_0))
		.pause(10)
		.exec(http("request_5")
			.post("/incidence/chatbot")
			.headers(headers_0)
			.formParam("answer", "Incidencia Gatling 2"))
		.pause(8)
		.exec(http("request_6")
			.post("/incidence/chatbot")
			.headers(headers_0)
			.formParam("answer", "Gatling 2"))
		.pause(7)
		.exec(http("request_7")
			.post("/incidence/chatbot")
			.headers(headers_0)
			.formParam("answer", "151515"))
		.pause(4)
		.exec(http("request_8")
			.post("/incidence/chatbot")
			.headers(headers_0)
			.formParam("answer", "515151"))
		.pause(2)
		.exec(http("request_9")
			.get("/")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_10")
			.post("/logout")
			.headers(headers_0))

	setUp(scn.inject(rampUsers(50) over(60 seconds))).protocols(httpProtocol)
}