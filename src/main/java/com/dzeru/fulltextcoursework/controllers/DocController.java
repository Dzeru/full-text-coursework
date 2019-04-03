package com.dzeru.fulltextcoursework.controllers;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;
import com.dzeru.fulltextcoursework.services.ArchiveDocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fulltext")
public class DocController
{
	@Autowired
	ArchiveDocServiceImpl archiveDocService;

	@RequestMapping("/fulltext")
	public List<ArchiveDocProperties> fulltext()
	{
		List<ArchiveDocProperties> docs = archiveDocService.fulltext();

		return docs;
	}

	/*@RequestMapping("/fulltextname")
	public List<String> fulltextname()
	{
		List<String> docs = archiveDocRepo.fulltextName();

		return docs;
	}

	@RequestMapping("/fulltextnameandtype")
	public String[][] fulltextnameandtype()
	{
		String[][] docs = archiveDocRepo.fulltextNameAndType();

		return docs;
	}*/
}
