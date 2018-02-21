package catalogo;

public class Obra {
	protected int ID;
	String Titulo,Compania,Imagen,NombreCompania;
	public Obra (int id,String titulo,String compania,String imagen,String Nombre) {
	    this.ID=id;
	    this.Titulo=titulo;
	    this.Compania=compania;
	    this.Imagen=imagen;
	    NombreCompania=Nombre;
	}
	public String getNombreCompania() {
		return NombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		NombreCompania = nombreCompania;
	}
	public String toString() {
		return "Obra: ID=" + ID + ", Titulo=" + Titulo + ", Compania=" + Compania + ", Imagen=" + Imagen;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getCompania() {
		return Compania;
	}
	public void setCompania(String compania) {
		Compania = compania;
	}
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	
}
