package controllers;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Usuario;
import infrastructure.persistence.*;
//import infrastructure.persistence.memory.*;
import infrastructure.persistence.mysql.MysqlRepositoryImpl;
import mappers.*;

public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private IPersistencia persistence = new MemoryRepositoryImpl();
	private IPersistencia persistence = new MysqlRepositoryImpl();
    private MapperJson mapper = new MapperJson();
    
    public Controlador() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Usuario> lista = persistence.listarUsuarios();
		String listaUsuariosJson = mapper.toJson(lista);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(listaUsuariosJson);
		
	}

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombre = request.getParameter("nombreInput");
		String apellido = request.getParameter("apellidoInput");
		String email = request.getParameter("emailInput");
		int dni = Integer.parseInt(request.getParameter("dniInput"));
		String temaCharla = request.getParameter("temaCharlaInput");
		
		
		Usuario usuario = new Usuario (nombre, apellido, email, dni, temaCharla);
		
		// persistir el usuario
		persistence.guardar(usuario);
			
		// para devolver el objeto creado al front ==> Json
		
		// si no se utiliza alguna dependencia habria que hacer algo como lo siguiente
//		String jsonFake = String.format(
//                "{\"id\": \"%s\", \"nombre\": \"%s\", \"apellido\": \"%s\", \"fechaAlta\": \"%s\"}",
//                usuario.getId(), usuario.getNombre(), usuario.getApellido());
		/* 
		 * { 
		 * 	"nombre" : "Sergio",
		 * 	"apellido": "Pereyra"
		 * }
		 * 
		 * 
		 * 
		 * */
		
		
		String usuarioJson = mapper.toJson(usuario); // usamos Jackson como dependencia que agregamos al pom.xml

		response.getWriter().write(usuarioJson);
		
		
	}

}
