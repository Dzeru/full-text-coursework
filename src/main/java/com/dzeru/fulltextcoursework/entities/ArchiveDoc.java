package com.dzeru.fulltextcoursework.entities;

import javax.persistence.*;

@Entity
@Table(name = "archive_docs")
public class ArchiveDoc
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long docId;

	byte[] archiveDoc;
	String docName;
	String typeOfDoc;

	public Long getDocId()
	{
		return docId;
	}

	public void setDocId(Long docId)
	{
		this.docId = docId;
	}

	public byte[] getArchiveDoc()
	{
		return archiveDoc;
	}

	public void setArchiveDoc(byte[] archiveDoc)
	{
		this.archiveDoc = archiveDoc;
	}

	public String getDocName()
	{
		return docName;
	}

	public void setDocName(String docName)
	{
		this.docName = docName;
	}

	public String getTypeOfDoc()
	{
		return typeOfDoc;
	}

	public void setTypeOfDoc(String typeOfDoc)
	{
		this.typeOfDoc = typeOfDoc;
	}
}
