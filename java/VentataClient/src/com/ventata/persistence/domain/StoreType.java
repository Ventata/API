package com.ventata.persistence.domain;

public class StoreType {
	
	private int Id;
	private String Name;


	public StoreType() {
		super();
	}


	/**
	 * @param id
	 * @param name
	 */
	public StoreType(int id, String name) {
		super();
		Id = id;
		Name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StoreType [Id=" + Id + ", Name=" + Name + "]";
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	
	
	

}
