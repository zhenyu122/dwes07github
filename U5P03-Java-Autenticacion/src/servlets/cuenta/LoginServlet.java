package servlets.cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=getServletContext();
		HttpSession session = request.getSession(false); // L1
		// si ya había sesión con un valor de usuario válido
		if (session != null) {
			if ((session.getAttribute("login") != null)) { // L2
				response.sendRedirect(contexto.getContextPath() + "/MostrarCatalogo"); // L3
			}
		}
		else { // no hay sesión iniciada
            // Declarar una variable de mensaje de error para mostrar después:
            String mensajeError = "";
    		Connection conn = null;
			if (request.getMethod().equals("POST")) { // si venimos de enviar el formulario...
              // Procesar los campos del formulario de login y password
			  // Comprobaciones que debes hacer:
              // a. Error: el campo login no puede estar vacío 
				if(request.getParameter("login")==null && request.getParameter("login").isEmpty()) {
					mensajeError+="Error: el campo login no puede estar vacío ";
				}else 
              // b. Error: el campo password no puede estar vacío
				if(request.getParameter("password")==null && request.getParameter("password").isEmpty()) {
					mensajeError+="Error: el campo password no puede estar vacío";
				}
              // c. Error: no se encuentra el usuario en la base de datos
				  try {
					Class.forName("org.mariadb.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection(contexto.getInitParameter("url"), contexto.getInitParameter("usuarioLectura"), contexto.getInitParameter("passwordLectura"));
					Statement sentencia = null;
					sentencia = conn.createStatement();
					String consulta = "SELECT * FROM usuario where login=\""+request.getParameter("login")+"\"";
					ResultSet rset = sentencia.executeQuery(consulta);
					if (!rset.isBeforeFirst() ) {    
						  mensajeError+="Error: no se encuentra el usuario en la base de datos";
					}else {
		      // d. Error: la contraseña no es válida
						while (rset.next()) {
							if(!rset.getString("password").equals(request.getParameter("password"))) {
								 mensajeError+="Error: la contraseña no es válida";
								 System.out.println("base"+rset.getString("password")+" campo"+request.getParameter("password"));
							}else {
              // Si todo ha ido bien:
              // 1. Crear un objeto de la clase Usuario con los datos obtenidos de la BD   
								Usuario user=new Usuario(rset.getString("login"), rset.getString("password"), rset.getString("nombre"), rset.getBoolean("admin"), rset.getString("descripcion"));
			  // 2. Crear una nueva sesión y avisarlo en un mensaje de log:
				              	session = request.getSession(); // en este caso sin "false" para que se cree
				              	session.setAttribute("usuario", user);
								contexto.log(" * Creando sesión en " + request.getRequestURI());	
          	// 3. Añadir los atributos de sesión "login" y "usuario"
								session.setAttribute("login", rset.getString("login"));
          	// 4. Redirigir al contenido			
								response.sendRedirect(contexto.getContextPath() + "/MostrarCatalogo");
							}
						}
					}
				// Desconexión
				  if (rset != null)
				    rset.close();
				  if (sentencia != null)
				    sentencia.close();
				  if (conn != null)
				    conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
			// salida : L4
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;UTF-8");
			out.println("<html><head><meta charset='UTF-8'/>" 
                        + "<style> .error {color: red}</style>"
                        + "<title>Catálogo de Nombre Apellidos</title></head><body>");
			String creado=request.getParameter("Creado");
			if(creado!=null) {
				out.println("<h2>Se ha creado la cuenta</h2>");
				creado=null;
			}
			String borrado=request.getParameter("Borrado");
			if(borrado!=null) {
				out.println("<h2>Se ha borrado la cuenta</h2>");
				borrado=null;
			}
			out.println("<h3>Inicio de sesión</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='login'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
                    + "</form>" + "<p><a href='"
					+ contexto.getContextPath() + "/Alta'>¿Aún no estás registrado? Haz clic en este enlace</a></p>"
					+ "<h3>" + mensajeError + "</h3>");
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
