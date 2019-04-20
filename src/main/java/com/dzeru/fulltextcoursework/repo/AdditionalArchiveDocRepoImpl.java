package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchiveDoc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class AdditionalArchiveDocRepoImpl implements AdditionalArchiveDocRepo<ArchiveDoc, Long>
{
	@PersistenceContext
	private EntityManager entityManager;

	//Слова, начинающиеся заданным текстом, или фразы с такими словами (префиксные выражения)
	@Override
	public List<ArchiveDoc> fulltextContainsPrefix(String word)
	{
		String queryString = "select * from dbo.archive_docs where contains (archive_doc, '\"" + word + "*\"')";
		Query fulltextQuery = entityManager.createNativeQuery(queryString, ArchiveDoc.class);
		return fulltextQuery.getResultList();
	}

	//Словоформы конкретного слова (производное выражение)
	@Override
	public List<ArchiveDoc> fulltextContainsFormsOf(String word)
	{
		String queryString = "select * from dbo.archive_docs where contains " +
				"(archive_doc, 'formsof(inflectional, " + word + ")')";
		Query fulltextQuery = entityManager.createNativeQuery(queryString, ArchiveDoc.class);
		return fulltextQuery.getResultList();
	}

	//Слова или фразы, находящиеся рядом с другими словами или фразами (выражения с учетом расположения)
	@Override
	public List<ArchiveDoc> fulltextContainsNear(String word, String near, Integer dist)
	{
		String queryString = "select * from dbo.archive_docs where contains (archive_doc," +
				"'near((" + word + ", " + near + "), " + dist + ")')";
		Query fulltextQuery = entityManager.createNativeQuery(queryString, ArchiveDoc.class);
		return fulltextQuery.getResultList();
	}

	//Слова или фразы со взвешенными значениями (взвешенное выражение)
	@Override
	public List<ArchiveDoc> fulltextContainsTableWeight(Map<String, Double> wordsAndWeights)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("select ad_tbl.*, key_tbl.rank from dbo.archive_docs as ad_tbl " +
				"inner join containstable (dbo.archive_docs, archive_doc, 'isabout (");

		for(Map.Entry<String, Double> wordAndWeight : wordsAndWeights.entrySet())
		{
			sb.append(wordAndWeight.getKey() + " weight(" + wordAndWeight.getValue() + "), ");
		}

		sb.delete(sb.lastIndexOf(", "), sb.capacity()); //Удаляем пробел и запятую у последнего вхождения
		sb.append(")') as key_tbl on ad_tbl.doc_id = key_tbl.[key] order by key_tbl.rank desc");

		String queryString = sb.toString();
		Query fulltextQuery = entityManager.createNativeQuery(queryString, ArchiveDoc.class);

		return fulltextQuery.getResultList();
	}
}