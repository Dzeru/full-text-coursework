package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchivedDocumentProperties;

import java.util.List;

public interface ArchivedDocumentService
{
	List<ArchivedDocumentProperties> fulltextContains(String word);
	List<ArchivedDocumentProperties> fulltextFreeText(String word);
	List<ArchivedDocumentProperties> fulltextContainsPrefix(String word);
	List<ArchivedDocumentProperties> fulltextContainsFormsOf(String word);
	List<ArchivedDocumentProperties> fulltextContainsNear(String word, String near, Integer dist);
	List<ArchivedDocumentProperties> fulltextContainsTableWeight(String list, String listSeparator, String pairSeparator);
}
