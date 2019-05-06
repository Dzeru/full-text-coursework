package com.dzeru.fulltextcoursework.entities;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "archived_documents")
public class ArchivedDocument
{
	@Id
	@Positive
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long docId;

	private byte[] content;
	private String name;
	private String extension;

	public Long getDocId()
	{
		return docId;
	}

	public void setDocId(Long docId)
	{
		this.docId = docId;
	}

	public byte[] getContent()
	{
		return content;
	}

	public void setContent(byte[] content)
	{
		this.content = content;
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
