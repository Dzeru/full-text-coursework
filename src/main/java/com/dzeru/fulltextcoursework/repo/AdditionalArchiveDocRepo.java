package com.dzeru.fulltextcoursework.repo;

import java.util.List;
import java.util.Map;

public interface AdditionalArchiveDocRepo<T, I>
{
	List<T> fulltextContainsPrefix(String word);
	List<T> fulltextContainsFormsOf(String word);
	List<T> fulltextContainsNear(String word, String near, Integer dist);
	List<T> fulltextContainsTableWeight(Map<String, Double> wordsAndWeights);
}
