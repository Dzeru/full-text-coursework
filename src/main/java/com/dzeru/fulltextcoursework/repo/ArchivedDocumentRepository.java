package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchivedDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivedDocumentRepository extends JpaRepository<ArchivedDocument, Long>, AdditionalArchivedDocumentRepository
{
	//Одно или несколько конкретных слов или фраз (простое выражение)
	@Query(value = "select * from dbo.archived_documents where contains (content, :word)", nativeQuery = true)
	List<ArchivedDocument> fulltextContains(@Param("word") String word);

	//Синонимические формы конкретного слова (тезаурус)
	@Query(value = "select * from dbo.archived_documents where freetext (content, :word)", nativeQuery = true)
	List<ArchivedDocument> fulltextFreeText(@Param("word") String word);
}