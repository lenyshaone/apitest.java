import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class apitest {

    @Test
    void Test_01() {
        Response response = RestAssured.get("https://cat-fact.herokuapp.com/facts");

        List < Map < String, String >> user = response.jsonPath().getList("all.user.name");
        Map < String, String > name_K = user.get(0);
        Mostcommon mc = new Mostcommon();
        Assert.assertEquals(name_K, mc.mostCommon(user));
    }
}


