package com.dzeru.fulltextcoursework;

import com.dzeru.fulltextcoursework.entities.ArchivedDocument;
import com.dzeru.fulltextcoursework.repositories.ArchivedDocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullTextRepositoriesTests
{
	@Autowired
	ArchivedDocumentRepository archivedDocumentRepository;

	@Test
	public void getAllArchivedDocuments()
	{
		List<ArchivedDocument> documentList = archivedDocumentRepository.findAll();
		assertEquals( 13, documentList.size());
	}

	@Test
	public void getContainsArchivedDocuments()
	{
		List<ArchivedDocument> documentList = archivedDocumentRepository.fulltextContains("Java");
		assertEquals( 6, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(5));
		assertEquals(documentList.get(1).getDocId(), new Long(6));
		assertEquals(documentList.get(2).getDocId(), new Long(7));
		assertEquals(documentList.get(3).getDocId(), new Long(9));
		assertEquals(documentList.get(4).getDocId(), new Long(10));
		assertEquals(documentList.get(5).getDocId(), new Long(11));
	}

	@Test
	public void getFreeTextArchivedDocuments()
	{
		List<ArchivedDocument> documentList = archivedDocumentRepository.fulltextFreeText("вопросы");
		assertEquals( 4, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(1));
		assertEquals(documentList.get(1).getDocId(), new Long(2));
		assertEquals(documentList.get(2).getDocId(), new Long(3));
		assertEquals(documentList.get(3).getDocId(), new Long(8));
	}

	@Test
	public void getContainsPrefixArchivedDocuments()
	{
		List<ArchivedDocument> documentList = archivedDocumentRepository.fulltextContainsPrefix("кон");
		assertEquals( 6, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(1));
		assertEquals(documentList.get(1).getDocId(), new Long(2));
		assertEquals(documentList.get(2).getDocId(), new Long(3));
		assertEquals(documentList.get(3).getDocId(), new Long(8));
		assertEquals(documentList.get(4).getDocId(), new Long(9));
		assertEquals(documentList.get(5).getDocId(), new Long(12));
	}

	@Test
	public void getContainsNearArchivedDocuments()
	{
		List<ArchivedDocument> documentList = archivedDocumentRepository.fulltextContainsNear("java", "SQL", 200);
		assertEquals( 1, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(7));

		documentList = archivedDocumentRepository.fulltextContainsNear("java", "SQL", 2000);
		assertEquals( 3, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(5));
		assertEquals(documentList.get(1).getDocId(), new Long(6));
		assertEquals(documentList.get(2).getDocId(), new Long(7));
	}

	@Test
	public void getContainsFormsOfArchivedDocuments()
	{
		List<ArchivedDocument> documentList = archivedDocumentRepository.fulltextContainsFormsOf("вопрос");
		assertEquals( 4, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(1));
		assertEquals(documentList.get(1).getDocId(), new Long(2));
		assertEquals(documentList.get(2).getDocId(), new Long(3));
		assertEquals(documentList.get(3).getDocId(), new Long(8));
	}

	@Test
	public void getContainsTableWeightArchivedDocuments()
	{
		Map<String, Double> wordsAndWeights = new HashMap<>();
		wordsAndWeights.put("java", 0.5);
		wordsAndWeights.put("sql", 0.5);

		List<ArchivedDocument> documentList = archivedDocumentRepository.fulltextContainsTableWeight(wordsAndWeights);
		assertEquals( 6, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(7));
		assertEquals(documentList.get(1).getDocId(), new Long(5));
		assertEquals(documentList.get(2).getDocId(), new Long(10));
		assertEquals(documentList.get(3).getDocId(), new Long(11));
		assertEquals(documentList.get(4).getDocId(), new Long(6));
		assertEquals(documentList.get(5).getDocId(), new Long(9));

		wordsAndWeights.remove("java");
		wordsAndWeights.put("java", 1.0);

		documentList = archivedDocumentRepository.fulltextContainsTableWeight(wordsAndWeights);
		assertEquals( 6, documentList.size());
		assertEquals(documentList.get(0).getDocId(), new Long(7));
		assertEquals(documentList.get(1).getDocId(), new Long(10));
		assertEquals(documentList.get(2).getDocId(), new Long(5));
		assertEquals(documentList.get(3).getDocId(), new Long(11));
		assertEquals(documentList.get(4).getDocId(), new Long(6));
		assertEquals(documentList.get(5).getDocId(), new Long(9));
	}
}
