package com.parallelprogramming.example.async;

import com.parallelprogramming.example.async.controller.AsyncController;
import com.parallelprogramming.example.async.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.AssertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.parallelprogramming.example.async.Constants.url;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = AsyncService.class)
public class AsyncServiceTest {
    private static Logger log = LoggerFactory.getLogger(AsyncServiceTest.class);

    @InjectMocks
        private AsyncService asyncService;
    @InjectMocks
    private static RestTemplate restTemplate=new RestTemplate();

        @Test
        public void loadAsyncUrlDataTest() throws ExecutionException, InterruptedException {
            List<CompletableFuture<List<Object>>> urlResponse = Constants.multipleUrl.stream()
                    .map(url -> CompletableFuture.supplyAsync(() ->
                            asyncService.getAllEmployeeDetails(url)
                    ).exceptionally(exception -> {
                        System.err.println("exception: " + exception);
                     fail(exception);
                        return null;}))
                    .collect(Collectors.toList());
            assertEquals(3,urlResponse.size());
        }

    @Test
    public void getAllEmployeeDetails() {
        List<Object> employeeDetails=restTemplate
                .getForObject(url,List.class);
        assertNotNull(employeeDetails);
        assertEquals(2,employeeDetails.size());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            fail(e);
        }
    }


    }

