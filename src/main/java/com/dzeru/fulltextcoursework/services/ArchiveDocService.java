package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;
import com.dzeru.fulltextcoursework.entities.ArchiveDoc;

import java.util.List;

public interface ArchiveDocService
{
	List<ArchiveDocProperties> fulltext();
	List<String> fulltextName();
	String[][] fulltextNameAndType();
}
