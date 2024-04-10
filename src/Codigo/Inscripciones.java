package Codigo;

public class Inscripciones {

	//Atributos
	private String nombre;
	private int edad;
	private String dni;
	private String pais;
	
	//Constructor
	public Inscripciones(String nombre, int edad, String dni, String pais) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.pais = pais;
	}
	
	//Metodos get
	public String getNombre() {
		return this.nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	//Metodos set
	public void setNombre(String newNombre) {
		this.nombre = newNombre;
	}
	
	public void setEdad(int newEdad) {
		this.edad = newEdad;
	}
	
	public void setDni(String newDni) {
		this.dni = newDni;
	}
	
	public void setPais(String newPais) {
		this.pais = newPais;
	}

}
