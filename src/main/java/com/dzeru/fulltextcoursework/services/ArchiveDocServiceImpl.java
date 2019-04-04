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

	@Override
	public List<ArchiveDocProperties> fulltext(String word)
	{
		List<ArchiveDoc> archiveDocsList = archiveDocRepo.fulltext(word);
		List<ArchiveDocProperties> archiveDocPropertiesList = new ArrayList<ArchiveDocProperties>();

		for(ArchiveDoc archiveDoc : archiveDocsList)
		{
			ArchiveDocProperties archiveDocProperties = new ArchiveDocProperties(archiveDoc.getDocId(),
					archiveDoc.getDocName(), archiveDoc.getTypeOfDoc());
			archiveDocPropertiesList.add(archiveDocProperties);

		}

		return archiveDocPropertiesList;
	}
}
