import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class apitest {

    @Test

    void Test_01() {
        List < Map < String, String >> usernames = RestAssured.get("https://cat-fact.herokuapp.com/facts").jsonPath().getList("all.user.name");
        int max_facts_from_user=0;
        String expected_user="Kasimir Schulz";
        String actual_user = null;

       Map<Map<String, String>, Long> collect_users=usernames.stream().collect(
               Collectors.groupingBy(Function.identity(), Collectors.counting()));

       for(Map.Entry<Map<String, String>, Long> item:collect_users.entrySet())
           if(item.getValue()>max_facts_from_user)
           {
               max_facts_from_user= Math.toIntExact(item.getValue());
               actual_user=String.valueOf(item.getKey().get("first")+" "+item.getKey().get("last"));
           }
        Assert.assertEquals(actual_user, expected_user);
    }
}


