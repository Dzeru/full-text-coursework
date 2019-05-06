package com.dzeru.fulltextcoursework.controllers;

import com.dzeru.fulltextcoursework.dto.ArchivedDocumentProperties;
import com.dzeru.fulltextcoursework.services.ArchivedDocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping(path = "/fulltext", produces = {APPLICATION_JSON_UTF8_VALUE, APPLICATION_JSON_VALUE})
public class ArchivedDocumentController
{
	@Autowired
	ArchivedDocumentServiceImpl archiveDocService;

	@RequestMapping("/contains")
	public List<ArchivedDocumentProperties> fulltextContains(@RequestParam(value="word") String word)
	{
		return archiveDocService.fulltextContains(word);
	}

	@RequestMapping("/freetext")
	public List<ArchivedDocumentProperties> fulltextFreeText(@RequestParam(value="word") @NotBlank String word)
	{
		return archiveDocService.fulltextFreeText(word);
	}

	@RequestMapping("/containsprefix")
	public List<ArchivedDocumentProperties> fulltextContainsPrefix(@RequestParam(value="word") @NotBlank String word)
	{
		return archiveDocService.fulltextContainsPrefix(word);
	}

	@RequestMapping("/containsformsof")
	public List<ArchivedDocumentProperties> fulltextContainsFormsOf(@RequestParam(value="word") @NotBlank String word)
	{
		return archiveDocService.fulltextContainsFormsOf(word);
	}

	@RequestMapping("/containsnear")
	public List<ArchivedDocumentProperties> fulltextContainsNear(@RequestParam(value="word") @NotBlank String word,
	                                                             @RequestParam(value="near") @NotBlank String near,
	                                                             @RequestParam(value="") @Positive Integer dist)
	{
		return archiveDocService.fulltextContainsNear(word, near, dist);
	}

	@RequestMapping("/containstableweight")
	public List<ArchivedDocumentProperties> fulltextContainsTableWeight(@RequestParam(value="list") @NotBlank String wordsAndWeights,
	                                                                    @RequestParam(value="listsep") @NotBlank String listSeparator,
	                                                                    @RequestParam(value="pairsep") @NotBlank String pairSeparator)
	{
		return archiveDocService.fulltextContainsTableWeight(wordsAndWeights, listSeparator, pairSeparator);
	}
}
