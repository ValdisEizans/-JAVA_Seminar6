package lv.venta.service;

import java.util.ArrayList;

public interface ICRUDServiceBase<Ttype> {
	//CRUD ka baze tam funkcijam, ko var sablionizet

	//Retrieve all
	public abstract ArrayList<Ttype> retrieveAll() throws Exception;
	
	//Retrieve by ID
	public abstract Ttype retrieveById(long id) throws Exception;
	
	//Delete by ID
	public abstract void deleteById(long id) throws Exception;

}
