import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class apitest {
    @Test
    void Test_01() {
        int max_facts_from_user = 0;
        String expected_user = "Kasimir Schulz";
        String actual_user = null;

        Response response = RestAssured.get("https://cat-fact.herokuapp.com/facts");
        List<Responces> jsonResponse = response.jsonPath().getList("all", Responces.class);

        Map<Object, Long> collect_users = jsonResponse.stream().filter(e -> e.getUser() != null).collect(
                Collectors.groupingBy(res -> res.getUser().getName().get_first_last(), Collectors.counting()));
        for (Map.Entry<Object, Long> item : collect_users.entrySet())
            if (item.getValue() > max_facts_from_user) {
                max_facts_from_user = Math.toIntExact(item.getValue());
                actual_user = String.valueOf(item.getKey());
            }
        Assert.assertEquals(actual_user, expected_user);
    }
}















