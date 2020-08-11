package com.graphqldemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.graphqldemo.domain.Customer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerGraphQLTest extends GraphQLTestTemplate {
    @Test
    public void testCustomers() throws IOException, JSONException {

        GraphQLResponse response = perform("customer.graphql", null);

        assertTrue(response.isOk());

        String json = response.getRawResponse().getBody();
        System.out.println("Body: " + json);

        JSONArray jC = new JSONObject(json).getJSONObject("data").getJSONArray("clientes");
        System.out.println(jC);

        ObjectMapper mapper = new ObjectMapper();

        List<Customer> customers = mapper.readValue(jC.toString(), new TypeReference<List<Customer>>() {
        });

        customers.forEach(c -> System.out.println(c.getName()));
    }
}
