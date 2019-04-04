package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;

import java.util.List;

public interface ArchiveDocService
{
	List<ArchiveDocProperties> fulltext(String word);
}
