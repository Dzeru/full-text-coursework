package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchivedDocument;

import java.util.List;
import java.util.Map;

public interface AdditionalArchivedDocumentRepository
{
	//Слова, начинающиеся заданным текстом, или фразы с такими словами (префиксные выражения)
	List<ArchivedDocument> fulltextContainsPrefix(String word);

	//Словоформы конкретного слова (производное выражение)
	List<ArchivedDocument> fulltextContainsFormsOf(String word);

	//Слова или фразы, находящиеся рядом с другими словами или фразами (выражения с учетом расположения)
	List<ArchivedDocument> fulltextContainsNear(String word, String near, Integer dist);

	//Слова или фразы со взвешенными значениями (взвешенное выражение)
	List<ArchivedDocument> fulltextContainsTableWeight(Map<String, Double> wordsAndWeights);
}
