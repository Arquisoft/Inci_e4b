package com.uniovi

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class IncidashBoardE4b extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8090")
		.inferHtmlResources()
		.acceptEncodingHeader("gzip, deflate")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"Accept-Language" -> "es-ES,es;q=0.9",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Language" -> "es-ES,es;q=0.9")

	val headers_4 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"Accept-Language" -> "es-ES,es;q=0.9",
		"Origin" -> "http://localhost:8090",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Accept-Language" -> "es-ES,es;q=0.9",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_13 = Map(
		"A-IM" -> "x-bm,gzip",
		"Accept-Encoding" -> "gzip, deflate")

    val uri1 = "http://clientservices.googleapis.com/chrome-variations/seed"

	val scn = scenario("IncidashBoardE4b")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/css/custom.css")
			.headers(headers_1),
            http("request_2")
			.get("/")
			.headers(headers_0),
            http("request_3")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(11)
		.exec(http("request_4")
			.post("/login")
			.headers(headers_4)
			.formParam("username", "000000Z")
			.formParam("password", "123456")
			.formParam("${_csrf.parameterName}", "${_csrf.token}")
			.resources(http("request_5")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(5)
		.exec(http("request_6")
			.get("/api/incidencias")
			.headers(headers_6)
			.resources(http("request_7")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_8")
			.get("/incidencias/location/1")
			.headers(headers_0),
            http("request_9")
			.get("/css/custom.css")
			.headers(headers_1),
            http("request_10")
			.get("/api/incidencias")
			.headers(headers_6)))
		.pause(10)
		.exec(http("request_11")
			.get("/incidencias/all")
			.headers(headers_0)
			.resources(http("request_12")
			.get("/css/custom.css")
			.headers(headers_1),
            http("request_13")
			.get(uri1 + "?osname=win&channel=stable&milestone=66")
			.headers(headers_13),
            http("request_14")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_15")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_16")
			.get("/incidencias/location/3")
			.headers(headers_0),
            http("request_17")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(10)
		.exec(http("request_18")
			.get("/incidencias/all")
			.headers(headers_0)
			.resources(http("request_19")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_20")
			.get("/api/incidencias")
			.headers(headers_6)
			.resources(http("request_21")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_22")
			.get("/incidencias/location/4")
			.headers(headers_0),
            http("request_23")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(10)
		.exec(http("request_24")
			.get("/")
			.headers(headers_0)
			.resources(http("request_25")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_26")
			.get("/api/incidencias")
			.headers(headers_6)
			.resources(http("request_27")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_28")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_29")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_30")
			.get("/incidencias/location/2")
			.headers(headers_0),
            http("request_31")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(7)
		.exec(http("request_32")
			.get("/incidencias/list")
			.headers(headers_0)
			.resources(http("request_33")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_34")
			.get("/api/operario/12")
			.headers(headers_6)
			.resources(http("request_35")
			.get("/notificaciones/list")
			.headers(headers_0),
            http("request_36")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_37")
			.get("/filtro/list")
			.headers(headers_0)
			.resources(http("request_38")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_39")
			.get("/filtro/add")
			.headers(headers_0)
			.resources(http("request_40")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_41")
			.get("/")
			.headers(headers_0)
			.resources(http("request_42")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_43")
			.get("/api/incidencias")
			.headers(headers_6)
			.resources(http("request_44")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_45")
			.get("/api/incidencias")
			.headers(headers_6),
            http("request_46")
			.get("/logout")
			.headers(headers_0),
            http("request_47")
			.get("/css/custom.css")
			.headers(headers_1)))

	setUp(scn.inject(rampUsers(200) over(200))).protocols(httpProtocol)
}