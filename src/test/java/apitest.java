import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class apitest {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }






    @Test

    void Test_01() throws FileNotFoundException {
        int max_facts_from_user=0;
        String expected_user="Kasimir Schulz";
        String actual_user = null;

        Response response = doGetRequest("https://cat-fact.herokuapp.com/facts");
        List<Responces> jsonResponse = response.jsonPath().getList("all", Responces.class);

        Map<Object, Long> collect_users= jsonResponse.stream().filter(e -> e.getUser() != null).collect(
                Collectors.groupingBy(res->res.getUser().getName().get_first_last(), Collectors.counting()));
        for(Map.Entry<Object, Long> item:collect_users.entrySet())
            if(item.getValue()>max_facts_from_user)
            {
                max_facts_from_user= Math.toIntExact(item.getValue());
                actual_user=String.valueOf(item.getKey());
            }
        Assert.assertEquals(actual_user, expected_user);













    }


}


