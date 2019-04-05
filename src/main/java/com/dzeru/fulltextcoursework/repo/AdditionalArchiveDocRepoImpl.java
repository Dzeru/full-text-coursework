package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchiveDoc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AdditionalArchiveDocRepoImpl implements AdditionalArchiveDocRepo
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ArchiveDoc> fulltextContainsPrefix(String word)
	{
		String queryString = "select * from dbo.archive_docs where contains(archive_doc, '\"" + word + "*\"')";
		Query fulltextQuery = entityManager.createNativeQuery(queryString, ArchiveDoc.class);
		return fulltextQuery.getResultList();
	}

	@Override
	public List<ArchiveDoc> fulltextContainsNear(String word, String near)
	{
		String queryString = "select * from dbo.archive_docs where contains(archive_doc," +
				"'near((" + word + ", " + near + "), 3)')";
		Query fulltextQuery = entityManager.createNativeQuery(queryString, ArchiveDoc.class);
		return fulltextQuery.getResultList();
	}
}