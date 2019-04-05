package com.dzeru.fulltextcoursework.services;

import com.dzeru.fulltextcoursework.dto.ArchiveDocProperties;
import com.dzeru.fulltextcoursework.entities.ArchiveDoc;
import com.dzeru.fulltextcoursework.repo.ArchiveDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
	public List<ArchiveDocProperties> fulltextContainsNear(String word, String near)
	{
		List<ArchiveDoc> archiveDocList = archiveDocRepo.fulltextContainsNear(word, near);
		List<ArchiveDocProperties> archiveDocPropertiesList = convertADListToADPList(archiveDocList);
		return archiveDocPropertiesList;
	}
}
