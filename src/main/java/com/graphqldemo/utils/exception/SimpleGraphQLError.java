package com.graphqldemo.utils.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.servlet.GenericGraphQLError;

import java.util.List;
import java.util.Map;

public class SimpleGraphQLError extends GenericGraphQLError {
    SimpleGraphQLError(String message) {
        super(message);
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return null;
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getExtensions() {
        return null;
    }
}

