package pl.quanton.commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.Collections;
import java.util.Map;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

public class ApiUtils {

	public final static String XSRF_TOKEN = "XSRF-TOKEN";
	private final static String RESPONSE = "response";
	private Gson gson = new GsonBuilder()
			.serializeNulls()
			.setPrettyPrinting()
			.create();
      
  public void sendSimpleHttpReqest(HttpMethods httpMethods, String path, Map<String, String> params, Map<String, String> headers) {
		setApiPrecondition();
		switch (httpMethods) {
			case POST:
				requestSpecification(params, headers)
						.post(path);
				break;
			case PUT:
				requestSpecification(params, headers)
						.put(path);
				break;
			case GET:
				requestSpecification(params, headers)
						.get(path);
				break;
			case DELETE:
				break;
			case PATH:
				break;
		}
		setSessionVariable(RESPONSE).to(validatableResponse());
	}

	public void sendPutRequestWithBody(String path, Map<String, String> headers, Object body) {
		setApiPrecondition();
		requestSpecification(Collections.emptyMap(), headers)
				.contentType(ContentType.JSON)
				.body(gson.toJson(body))
				.put(path);
		setSessionVariable(RESPONSE).to(validatableResponse());
	}
  
  public Response response(){
		return sessionVariableCalled(RESPONSE);
	}

	private void setApiPrecondition() {
		RestAssured.baseURI = ApiResources.DEFAULT_URL;
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.defaultParser = Parser.JSON;
	}

	private RequestSpecification requestSpecification(Map<String, String> params, Map<String, String> headers) {
		if (ApiResources.RESPONSE_LOGGER_FLAG) {
			return SerenityRest
					.given()
					.log()
					.all()
					.when()
					.params(params)
					.headers(headers);
		} else {
			return SerenityRest
					.given()
					.log()
					.uri()
					.when()
					.params(params)
					.headers(headers);
		}
	}

	private Response validatableResponse() {
		if (ApiResources.RESPONSE_LOGGER_FLAG) {
			return SerenityRest
					.then()
					.log()
					.all(true)
					.extract()
					.response();
		} else {
			return SerenityRest
					.then()
					.log()
					.ifError()
					.extract()
					.response();
		}
	}
}
  
