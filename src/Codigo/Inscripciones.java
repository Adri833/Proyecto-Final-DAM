package Codigo;

public class Inscripciones {

	//Atributos
	private String nombre;
	private int edad;
	private String dni;
	private int telefono;
	private String pais;
	
	//Constructor
	public Inscripciones(String nombre, int edad, int telefono, String dni, String pais) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.telefono = telefono;
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
	
	public int getTelefono() {
		return this.telefono;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	frthvftvfru
	
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
	
	public void setTelefono(int newTelefono) {
		this.telefono = newTelefono;
	}
	
	public void setPais(String newPais) {
		this.pais = newPais;
	}

}
