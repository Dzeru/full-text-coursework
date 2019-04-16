package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;
import com.dzeru.fulltextcoursework.entities.ArchiveDoc;
import com.dzeru.fulltextcoursework.repo.ArchiveDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArchiveDocServiceImpl implements ArchiveDocService
{
	@Autowired
	ArchiveDocRepo archiveDocRepo;

	private List<ArchiveDocProperties> convertADListToADPList(List<ArchiveDoc> archiveDocList)
	{
		List<ArchiveDocProperties> archiveDocPropertiesList = new ArrayList<ArchiveDocProperties>();

		for(ArchiveDoc archiveDoc : archiveDocList)
		{
			ArchiveDocProperties archiveDocProperties = new ArchiveDocProperties(archiveDoc.getDocId(),
					archiveDoc.getDocName(), archiveDoc.getTypeOfDoc());
			archiveDocPropertiesList.add(archiveDocProperties);

		}
		
		return archiveDocPropertiesList;
	}

	private Map<String, Double> convertWWListToMap(String list, String listSeparator, String pairSeparator)
	{
		Map<String, Double> wordsAndWeights = new HashMap<>();
		String[] pairs = list.split(listSeparator);
		String[] splitPair;

		for(int i = 0; i < pairs.length; i++)
		{
			splitPair = pairs[i].split(pairSeparator);
			wordsAndWeights.put(splitPair[0], Double.parseDouble(splitPair[1]));
		}

		return wordsAndWeights;
	}

	@Override
	public List<ArchiveDocProperties> fulltextContains(String word)
	{
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextContains(word);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}

	@Override
	public List<ArchiveDocProperties> fulltextFreeText(String word)
	{
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextFreeText(word);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}

	@Override
	public List<ArchiveDocProperties> fulltextContainsPrefix(String word)
	{
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextContainsPrefix(word);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}

	@Override
	public List<ArchiveDocProperties> fulltextContainsFormsOf(String word)
	{
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextContainsFormsOf(word);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}

	@Override
	public List<ArchiveDocProperties> fulltextContainsTableWeight(String list,
	                                                              String listSeparator,
	                                                              String pairSeparator)
	{
		Map<String, Double> wordsAndWeights = convertWWListToMap(list, listSeparator, pairSeparator);
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextContainsTableWeight(wordsAndWeights);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}

	@Override
	public List<ArchiveDocProperties> fulltextContainsNear(String word, String near, Integer dist)
	{
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextContainsNear(word, near, dist);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}
}
