package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MyComputer1 extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """.Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_1 = Map(
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """.Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_2 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """.Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")



	val scn = scenario("MyComputer1")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_1")
			.get("/computers/new")
			.headers(headers_1))
		.pause(18)
		.exec(http("request_2")
			.post("/computers")
			.headers(headers_2)
			.formParam("name", "MyComputer2")
			.formParam("introduced", "2020-01-01")
			.formParam("discontinued", "2021-01-01")
			.formParam("company", "16"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}