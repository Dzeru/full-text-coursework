package com.dzeru.fulltextcoursework.dto;

public class ArchiveDocProperties
{
	Long docId;
	String docName;
	String typeOfDoc;

	public ArchiveDocProperties(Long docId, String docName, String typeOfDoc)
	{
		this.docId = docId;
		this.docName = docName;
		this.typeOfDoc = typeOfDoc;
	}

	public ArchiveDocProperties()
	{

	}

	public Long getDocId()
	{
		return docId;
	}

	public void setDocId(Long docId)
	{
		this.docId = docId;
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
