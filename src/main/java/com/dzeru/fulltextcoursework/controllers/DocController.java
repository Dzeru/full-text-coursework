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

	@RequestMapping("/fulltext")
	public List<ArchiveDocProperties> fulltext(@RequestParam(value="word") String word)
	{
		List<ArchiveDocProperties> docs = archiveDocService.fulltext(word);

		return docs;
	}
}
