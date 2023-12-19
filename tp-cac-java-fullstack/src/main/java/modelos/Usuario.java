package modelos;


public class Usuario {
	
	private String nombre;
	private String apellido;
	private String email;
	private int dni;
	private String temaCharla;

	
	
	public Usuario(String nombre, String apellido, String email, int dni, String temaCharla) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.temaCharla = temaCharla;

	}


	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}
	
	public String getEmail() {
		return this.email;
	}

	public int getDni() {
		return this.dni;
	}

	public String getTemaCharla() {
		return this.temaCharla;
	}

	public void setTemaCharla(String TemaCharla) {
		this.temaCharla = TemaCharla;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + this.nombre + 
				", apellido=" + this.apellido + 
				", email=" + this.email +
				", dni=" + this.dni +
				", temaCharla=" + this.temaCharla +"]";
	}
	
	
	

}
