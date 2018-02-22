package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catalogo.Autor;
import catalogo.Obra;

/**
 * Servlet implementation class MostrarCatalogoServlet
 */
@WebServlet("/MostrarCatalogo")
public class MostrarCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Obra obra;Autor autor;
		PrintWriter out =response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Connection conn = null;
		Statement sentencia = null;
		try {
			  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/catalogo07";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();
		  String consulta = "SELECT obras.*,autor.* FROM obras,autor where Compania=autor.ID";
		  
		  if(request.getParameter("orden")!=null && request.getParameter("autor")!=null) {
			  if(request.getParameter("orden").equalsIgnoreCase("asc")) {
				  consulta =session.getAttribute("consultaAutor")+" order by Titulo asc";
			  }else if(request.getParameter("orden").equalsIgnoreCase("desc")) {
				  consulta =session.getAttribute("consultaAutor")+" order by Titulo desc";
			  }
		  }else {
			  if(request.getParameter("orden")!=null) {
				  if(request.getParameter("orden").equalsIgnoreCase("asc")) {
					  consulta += " order by Titulo asc";
				  }else if(request.getParameter("orden").equalsIgnoreCase("desc")) {
					  consulta += " order by Titulo desc";
				  }
			  }
			  if(request.getParameter("autor")!=null) {
				  consulta = "SELECT autor.*,obras.* FROM obras,autor where Compania=autor.ID and autor.ID="+request.getParameter("autor");
				  session.setAttribute("consultaAutor", consulta);
				  session.setAttribute("Autor", request.getParameter("autor"));
				 /* if(request.getParameter("orden")!=null) {
					  if(request.getParameter("orden").equalsIgnoreCase("asc")) {
						  consulta=request.getAttribute("consultaAutor")+" order by Titulo asc";
					  }else if(request.getParameter("orden").equalsIgnoreCase("desc")){
						  consulta=request.getAttribute("consultaAutor")+" order by Titulo desc";
					  }
				  }*/
			  }
		  }
		  if(request.getParameter("busqueda")!=null) {
			  String busqueda= request.getParameter("busqueda");
			  String[] arBusqueda= busqueda.split(" ");
			  if(arBusqueda.length>1) {
				  for(int i=0; i<arBusqueda.length;i++) {
					  if(i==0) {
					  	consulta+=" AND (obras.titulo LIKE '%"+arBusqueda[i]+"%'"; 
					  }
					  if(i>0) {
						consulta+=" OR obras.titulo LIKE '%"+arBusqueda[i]+"%'"; 
					  }
					  if(i==arBusqueda.length-1) {
						consulta+=" OR obras.titulo LIKE '%"+arBusqueda[i]+"%')"; 
					  }
				  }
			  }else {
					consulta+=" AND obras.titulo LIKE '%"+busqueda+"%'"; 
			  }
		  }
	//////////////////////////////////////
		// Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		
		  ResultSet rset = sentencia.executeQuery(consulta);

		  // Paso 5: Mostrar resultados
		  if (!rset.isBeforeFirst() ) {    
			   out.println("<h3>No hay resultados</p>");
		  	}
		  out.println("<html> <head>"
		  		+ "<style>td,th{text-align:center}a{text-decoration:none;}a:hover{color:red}td:empty{border:0}"
		  		+ "</style>"
		  		+ "<meta charset='UTF-8'/></head><body>");

		  ///Busqueda
		  out.println("<form action='"+request.getRequestURI()+"' method='post'>");
		  out.println("<input class='form-control' placeholder='Buscar' type='text' name='busqueda'/>");
		  out.println("<input type='submit' name='enviar' value='Enviar'/>");
		  
		  
		  out.println("<table border='1'>");
		  out.println("<thead><tr>");
		 /* if(request.getParameter("autor")!=null) {
			  out.println("<th>Nombre Compania</th><th>Sede Compania</th><th>Imagen Compania</th>");
		  }*/
		  if(request.getParameter("autor")!=null) {
			  out.println("<th>Titulo<a href='./MostrarCatalogo?orden=asc&autor="+session.getAttribute("Autor")+"'>&#9650</a><a href='./MostrarCatalogo?orden=desc&autor="+session.getAttribute("Autor")+"'>&#9660</a></th>"
				  		+ "<th>Imagen</th>"
				  		+ "<th>Compania</th>"
				  		+ "</tr></thead><tbody>");
		  }else {
			  out.println("<th>Titulo<a href='./MostrarCatalogo?orden=asc'>&#9650</a><a href='./MostrarCatalogo?orden=desc'>&#9660</a></th>"
			  		+ "<th>Imagen</th>"
			  		+ "<th>Compania</th>"
			  		+ "</tr></thead><tbody>");
		  }
		  boolean done=false;
		  while (rset.next()) {
			obra=new Obra(rset.getInt("obras.ID"), rset.getString("Titulo"), rset.getString("Compania"),rset.getString("obras.Imagen"),rset.getString("Nombre"));
			out.println("<tr>");
		    if(request.getParameter("autor")!=null && !done) {
			  autor=new Autor(rset.getInt("autor.ID"), rset.getString("autor.Nombre"), rset.getString("autor.Sede"), rset.getString("autor.Imagen"));
			  //out.println("<td>"+autor.getNombre()+"</td><td>"+autor.getSede()+"</td><td><img width=100px src='./img/"+autor.getImagen()+"'></td>");
			  out.println("<ul>"
			  		+"<li>Nombre : "+autor.getNombre()
			  		+"<li>Sede : "+autor.getSede()
			  		+"<li><img width=100px src='./img/"+autor.getImagen()+"'/>"
			  		+ "</ul>");
			  done=true;
		    }
		    out.println("<td>" + obra.getTitulo()+ "</td>"
		    		+ "<td><a href='./MostrarObra?idObra="+obra.getID()+"'><img width=100px src='./img/"+obra.getImagen()+"'/></a></td>"
    				+ "<td><a href='./MostrarCatalogo?autor="+obra.getCompania()+"'>"+obra.getNombreCompania()+"</a></td></tr>");
		    
		  }
		  out.println("</tbody></table>");
		  out.println("<a href='./MostrarCatalogo'><button>Limpiar filtros</button></a>");
		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		  out.println("<p>No existe</p>");
		}
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
