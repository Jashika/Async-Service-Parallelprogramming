package com.parallelprogramming.example.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Autowired
	private static RestTemplate restTemplate=new RestTemplate();

	public static CompletableFuture<Object> loadAsyncUrlData(List<String> urls) {
		List<CompletableFuture<List<Object>>> urlResponse = urls.stream()
				.map(url -> CompletableFuture.supplyAsync(() ->
						 getAllEmployeeDetails(url)
				).exceptionally(exception -> {
					System.err.println("exception: " + exception);
					return null;}))
				.collect(Collectors.toList());
		CompletableFuture<Object> combinedData = combineAllUrlResponseData(urlResponse);
		return combinedData;
	}
	public  static CompletableFuture<Object> combineAllUrlResponseData(List<CompletableFuture<List<Object>>> responses) {
		CompletableFuture<Void> completableResponses =
				CompletableFuture.allOf(responses.toArray(new CompletableFuture[responses.size()]));
		return completableResponses.thenApply(k ->
				responses.stream().
						map(response ->
						 response.join()).collect(Collectors.toList()));
	}

	public static List<Object>  getAllEmployeeDetails(String url) {
		log.info("getAllEmployeeDetails Starts");
		List<Object> employeeDetails=restTemplate
				.getForObject(url,List.class);
		log.info("getAllEmployeeDetails, {}", employeeDetails);
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new IllegalStateException(e);
			}

		log.info("getAllEmployeeDetails completed");
		return employeeDetails;
	}

}
