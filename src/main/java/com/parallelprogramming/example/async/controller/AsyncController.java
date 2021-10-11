package com.parallelprogramming.example.async.controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.parallelprogramming.example.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
	public CompletableFuture<Object>  testAsynch()
	{
		List<String> multipleUrl = Arrays.asList(
				"http://localhost:8081/addresses",
				"http://localhost:8081/phones",
				"http://localhost:8081/names");
		CompletableFuture<Object> allDoneFutureNew=allDoneFutureNew= AsyncService.loadAsyncUrlData(multipleUrl);
		return allDoneFutureNew;
	}
	}


