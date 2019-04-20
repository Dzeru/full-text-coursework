package com.dzeru.fulltextcoursework.repo;

import java.util.List;
import java.util.Map;

public interface AdditionalArchiveDocRepo<T, I>
{
	//Слова, начинающиеся заданным текстом, или фразы с такими словами (префиксные выражения)
	List<T> fulltextContainsPrefix(String word);

	//Словоформы конкретного слова (производное выражение)
	List<T> fulltextContainsFormsOf(String word);

	//Слова или фразы, находящиеся рядом с другими словами или фразами (выражения с учетом расположения)
	List<T> fulltextContainsNear(String word, String near, Integer dist);

	//Слова или фразы со взвешенными значениями (взвешенное выражение)
	List<T> fulltextContainsTableWeight(Map<String, Double> wordsAndWeights);
}
