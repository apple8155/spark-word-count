package com.oneplan.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.oneplan.service.WordCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCountController {

	@Autowired
	WordCountService service;

	@RequestMapping(method = RequestMethod.POST, path = "/wordcount")
	public Map<String, Long> count(@RequestParam(required = false) String words) {
		List<String> wordList = Arrays.asList(words.split("\\|"));
		return service.getCount(wordList);
	}


	@RequestMapping(method = RequestMethod.GET, path = "/count")
	public long countlines(@RequestParam(required = false) String words) {
		return service.getlineCount();
	}

}
