package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;

import java.util.List;

public interface ArchiveDocService
{
	List<ArchiveDocProperties> fulltextContains(String word);
	List<ArchiveDocProperties> fulltextFreeText(String word);
	List<ArchiveDocProperties> fulltextContainsPrefix(String word);
	List<ArchiveDocProperties> fulltextContainsFormsOf(String word);
	List<ArchiveDocProperties> fulltextContainsNear(String word, String near, Integer dist);
	List<ArchiveDocProperties> fulltextContainsTableWeight(String list, String listSeparator, String pairSeparator);
}
