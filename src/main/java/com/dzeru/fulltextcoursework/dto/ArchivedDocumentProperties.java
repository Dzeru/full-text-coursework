package com.dzeru.fulltextcoursework.dto;

public class ArchivedDocumentProperties
{
	Long docId;
	String name;
	String extension;

	public ArchivedDocumentProperties(Long docId, String name, String extension)
	{
		this.docId = docId;
		this.name = name;
		this.extension = extension;
	}

	public ArchivedDocumentProperties() {}

	public Long getDocId()
	{
		return docId;
	}

	public void setDocId(Long docId)
	{
		this.docId = docId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}
}
