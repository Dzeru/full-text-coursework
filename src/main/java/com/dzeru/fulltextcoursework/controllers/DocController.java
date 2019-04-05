package com.dzeru.fulltextcoursework.controllers;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;
import com.dzeru.fulltextcoursework.services.ArchiveDocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fulltext")
public class DocController
{
	@Autowired
	ArchiveDocServiceImpl archiveDocService;

	@RequestMapping("/contains")
	public List<ArchiveDocProperties> fulltextContains(@RequestParam(value="word") String word)
	{
		List<ArchiveDocProperties> docs = archiveDocService.fulltextContains(word);

		return docs;
	}

	@RequestMapping("/freetext")
	public List<ArchiveDocProperties> fulltextFreeText(@RequestParam(value="word") String word)
	{
		List<ArchiveDocProperties> docs = archiveDocService.fulltextFreeText(word);

		return docs;
	}

	@RequestMapping("/containsprefix")
	public List<ArchiveDocProperties> fulltextContainsPrefix(@RequestParam(value="word") String word)
	{
		List<ArchiveDocProperties> docs = archiveDocService.fulltextContainsPrefix(word);

		return docs;
	}

	@RequestMapping("/containsnear")
	public List<ArchiveDocProperties> fulltextContainsNear(@RequestParam(value="word") String word, @RequestParam(value="near") String near)
	{
		List<ArchiveDocProperties> docs = archiveDocService.fulltextContainsNear(word, near);

		return docs;
	}
}
