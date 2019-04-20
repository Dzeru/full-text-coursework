package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchiveDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveDocRepo extends JpaRepository<ArchiveDoc, Long>, AdditionalArchiveDocRepo<ArchiveDoc, Long>
{
	//Одно или несколько конкретных слов или фраз (простое выражение)
	@Query(value = "select * from dbo.archive_docs where contains (archive_doc, :word)", nativeQuery = true)
	List<ArchiveDoc> fulltextContains(@Param("word") String word);

	//Синонимические формы конкретного слова (тезаурус)
	@Query(value = "select * from dbo.archive_docs where freetext (archive_doc, :word)", nativeQuery = true)
	List<ArchiveDoc> fulltextFreeText(@Param("word") String word);
}