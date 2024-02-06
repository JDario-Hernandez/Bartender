package com.main.model;

public class Request {
	// Constructor, getters y setters

	
	public Request(int Q, int id) {
		this.id = id;
		this.Q = Q;
	}
	private int id;
	private int Q;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQ() {
		return Q;
	}

	public void setQ(int Q) {
		this.Q = Q;
	}

}