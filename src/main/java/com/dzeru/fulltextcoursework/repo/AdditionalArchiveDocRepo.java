package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchiveDoc;

import java.util.List;

public interface AdditionalArchiveDocRepo
{
	List<ArchiveDoc> fulltextContainsPrefix(String word);
	List<ArchiveDoc> fulltextContainsNear(String word, String near, Integer dist);
}
