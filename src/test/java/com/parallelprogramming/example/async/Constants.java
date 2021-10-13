package com.parallelprogramming.example.async;

import java.util.Arrays;
import java.util.List;

public interface Constants {
    public static final List<String> multipleUrl = Arrays.asList(
            "http://localhost:8081/addresses",
            "http://localhost:8081/phones",
            "http://localhost:8081/names");
    public static final String url="http://localhost:8081/addresses";
}
