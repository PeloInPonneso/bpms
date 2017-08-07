package org.trenet.bpms;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item implements Serializable {

	private static final long serialVersionUID = -122975065758094591L;
	
	private Long id;
	private String code;
	private String description;
	
	public Item() {
		super();
	}

	public Item(Long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
