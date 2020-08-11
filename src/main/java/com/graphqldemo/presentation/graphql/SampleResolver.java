package com.graphqldemo.presentation.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SampleResolver implements GraphQLQueryResolver {
    public String hello() {
        return "Hello GraphQL";
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
