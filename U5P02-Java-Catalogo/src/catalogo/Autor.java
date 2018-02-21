package catalogo;

public class Autor {
	protected int ID;
	String Nombre,Sede,Imagen;
	public Autor (int id,String nombre,String sede,String imagen) {
	    this.ID=id;
	    this.Nombre=nombre;
	    this.Sede=sede;
	    this.Imagen=imagen;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getSede() {
		return Sede;
	}
	public void setSede(String sede) {
		Sede = sede;
	}
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
}
