package com.dzeru.fulltextcoursework.repositories;

import com.dzeru.fulltextcoursework.entities.ArchivedDocument;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

public class AdditionalArchivedDocumentRepositoryImpl implements AdditionalArchivedDocumentRepository
{
	@PersistenceContext
	private EntityManager entityManager;

	//Слова, начинающиеся заданным текстом, или фразы с такими словами (префиксные выражения)
	@Override
	public List<ArchivedDocument> fulltextContainsPrefix(String word)
	{
		String queryString = "select * from dbo.archived_documents where contains (content, '\"" + word + "*\"')";
		return entityManager.createNativeQuery(queryString, ArchivedDocument.class).getResultList();
	}

	//Словоформы конкретного слова (производное выражение)
	@Override
	public List<ArchivedDocument> fulltextContainsFormsOf(String word)
	{
		String queryString = "select * from dbo.archived_documents where contains " +
				"(content, 'formsof(inflectional, " + word + ")')";
		return entityManager.createNativeQuery(queryString, ArchivedDocument.class).getResultList();
	}

	//Слова или фразы, находящиеся рядом с другими словами или фразами (выражения с учетом расположения)
	@Override
	public List<ArchivedDocument> fulltextContainsNear(String word, String near, Integer dist)
	{
		String queryString = "select * from dbo.archived_documents where contains (content," +
				"'near((" + word + ", " + near + "), " + dist + ")')";
		return entityManager.createNativeQuery(queryString, ArchivedDocument.class).getResultList();
	}

	//Слова или фразы со взвешенными значениями (взвешенное выражение)
	@Override
	public List<ArchivedDocument> fulltextContainsTableWeight(Map<String, Double> wordsAndWeights)
	{
		StringBuilder queryBuilder = new StringBuilder();

		queryBuilder.append("select ad_tbl.*, key_tbl.rank from dbo.archived_documents as ad_tbl " +
				"inner join containstable (dbo.archived_documents, content, 'isabout (");

		for(Map.Entry<String, Double> wordAndWeight : wordsAndWeights.entrySet())
		{
			queryBuilder.append(wordAndWeight.getKey() + " weight(" + wordAndWeight.getValue() + "), ");
		}

		queryBuilder.delete(queryBuilder.lastIndexOf(", "), queryBuilder.capacity()); //Удаляем пробел и запятую у последнего вхождения
		queryBuilder.append(")') as key_tbl on ad_tbl.doc_id = key_tbl.[key] order by key_tbl.rank desc");

		return entityManager.createNativeQuery(queryBuilder.toString(), ArchivedDocument.class).getResultList();
	}
}