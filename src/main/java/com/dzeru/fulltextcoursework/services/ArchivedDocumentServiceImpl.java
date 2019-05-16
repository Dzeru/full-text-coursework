package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchivedDocumentProperties;
import com.dzeru.fulltextcoursework.entities.ArchivedDocument;
import com.dzeru.fulltextcoursework.repositories.ArchivedDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ArchivedDocumentServiceImpl implements ArchivedDocumentService
{
	@Autowired
	ArchivedDocumentRepository archivedDocumentRepository;

	@Override
	@Transactional(readOnly = true)
	public List<ArchivedDocumentProperties> fulltextContains(String word)
	{
		List<ArchivedDocument> archivedDocumentList = archivedDocumentRepository.fulltextContains(word);
		return convertADListToADPList(archivedDocumentList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivedDocumentProperties> fulltextFreeText(String word)
	{
		List<ArchivedDocument> archivedDocumentList = archivedDocumentRepository.fulltextFreeText(word);
		return convertADListToADPList(archivedDocumentList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivedDocumentProperties> fulltextContainsPrefix(String word)
	{
		List<ArchivedDocument> archivedDocumentList = archivedDocumentRepository.fulltextContainsPrefix(word);
		return convertADListToADPList(archivedDocumentList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivedDocumentProperties> fulltextContainsFormsOf(String word)
	{
		List<ArchivedDocument> archivedDocumentList = archivedDocumentRepository.fulltextContainsFormsOf(word);
		return convertADListToADPList(archivedDocumentList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivedDocumentProperties> fulltextContainsTableWeight(String list,
	                                                                    String listSeparator,
	                                                                    String pairSeparator)
	{
		Map<String, Double> wordsAndWeights = convertWWListToMap(list, listSeparator, pairSeparator);
		List<ArchivedDocument> archivedDocumentList = archivedDocumentRepository.fulltextContainsTableWeight(wordsAndWeights);
		return convertADListToADPList(archivedDocumentList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArchivedDocumentProperties> fulltextContainsNear(String word, String near, Integer dist)
	{
		List<ArchivedDocument> archivedDocumentList = archivedDocumentRepository.fulltextContainsNear(word, near, dist);
		return convertADListToADPList(archivedDocumentList);
	}

	private List<ArchivedDocumentProperties> convertADListToADPList(List<ArchivedDocument> archivedDocumentList)
	{
		List<ArchivedDocumentProperties> archivedDocumentPropertiesList = new ArrayList<ArchivedDocumentProperties>();

		for(ArchivedDocument archivedDocument : archivedDocumentList)
		{
			ArchivedDocumentProperties archivedDocumentProperties = new ArchivedDocumentProperties(archivedDocument.getDocId(),
					archivedDocument.getName(), archivedDocument.getExtension());
			archivedDocumentPropertiesList.add(archivedDocumentProperties);
		}

		return archivedDocumentPropertiesList;
	}

	private Map<String, Double> convertWWListToMap(String list, String listSeparator, String pairSeparator)
	{
		return Stream.of(list)
				.flatMap(toSplit -> Stream.of(toSplit.split(listSeparator)))
				.map(pair -> pair.split(pairSeparator))
				.collect(Collectors.toMap(
					splittedPair -> splittedPair[0],
					splittedPair -> Double.parseDouble(splittedPair[1])
				));
	}
}
