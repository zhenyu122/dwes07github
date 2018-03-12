package modelo;

public class Usuario {
	String login,password,nombre,direccion;
	double gasto;
	
	public Usuario(String login,String password,String nombre,double gasto,String direccion) {
		this.login=login;
		this.password=password;
		this.nombre=nombre;
		this.gasto=gasto;
		this.direccion=direccion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	
}
