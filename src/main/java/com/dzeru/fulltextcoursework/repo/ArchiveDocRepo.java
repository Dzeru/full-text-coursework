package com.dzeru.fulltextcoursework.repo;

import com.dzeru.fulltextcoursework.entities.ArchiveDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveDocRepo extends JpaRepository<ArchiveDoc, Long>
{
	@Query(value = "select * from dbo.archive_docs where contains (archive_doc, 'small')", nativeQuery = true)
	List<ArchiveDoc> fulltext();

	@Query(value = "select doc_name from dbo.archive_docs where contains (archive_doc, 'small')", nativeQuery = true)
	List<String> fulltextName();

	@Query(value = "select doc_name, type_of_doc from dbo.archive_docs where contains (archive_doc, 'small')", nativeQuery = true)
	String[][] fulltextNameAndType();
}