package pl.quanton.api;

import net.thucydides.core.annotations.Step;
import pl.quanton.commons.ApiUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static pl.quanton.commons.HttpMethods.GET;

public class ApiSteps {

    private ApiUtils apiUtils = new ApiUtils();
    private final static String DUCK_DUCK = "https://duckduckgo.com/";

    @Step
    public void searchSomeTextInDuckDuck(String searchingPhrase){
        final Map<String, String> params = new HashMap<>();
        params.put("q", "warta tower");
        params.put("t", "h_");
        apiUtils.sendSimpleHttpReqest(GET, DUCK_DUCK, params, Collections.emptyMap());
    }
}
