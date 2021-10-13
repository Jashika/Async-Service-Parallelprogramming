package com.parallelprogramming.example.async;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parallelprogramming.example.async.controller.AsyncController;
import com.parallelprogramming.example.async.model.EmployeeAddress;
import com.parallelprogramming.example.async.model.EmployeeName;
import com.parallelprogramming.example.async.model.EmployeePhoneNumber;
import com.parallelprogramming.example.async.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(value = AsyncController.class)
public class AsyncControllerTest {
    @InjectMocks
    private AsyncController asyncController;

    @Test
    public void testAsyncTest() throws ExecutionException, InterruptedException {

        CompletableFuture<Object> allDoneFutureNew=allDoneFutureNew= AsyncService.loadAsyncUrlData(Constants.multipleUrl);
       assertTrue(allDoneFutureNew.complete(allDoneFutureNew));
        assertNotNull(allDoneFutureNew.get());
    }


}
