package infrastructure.persistence.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import infrastructure.persistence.IPersistencia;
import modelos.Usuario;

public class MysqlRepositoryImpl implements IPersistencia {

	private Connection connection;
	
	public MysqlRepositoryImpl() {
		connection = ConexionBD.getConnection();
	}
	
	
	@Override
	public void guardar(Usuario newUsuario) {
		
		String query = "INSERT INTO usuarios (nombre, apellido, email, dni, temaCharla) VALUES (?,?,?,?,?)";
		// try with resources
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1 , newUsuario.getNombre());
			statement.setString(2 , newUsuario.getApellido());
			statement.setString(3 , newUsuario.getEmail());
			statement.setInt(4 , newUsuario.getDni());
			statement.setString(5 , newUsuario.getTemaCharla());
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public ArrayList<Usuario> listarUsuarios() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		String query = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				// obtener los datos de cada usuario en el resultado
				
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String email = resultSet.getString("email");
				int dni = resultSet.getInt("dni");
				String temaCharla = resultSet.getString("temaCharla");
				
				// Crear un nuevo objeto Usuario con los datos obtenidos
				
				Usuario usuario = new Usuario(nombre, apellido, email, dni, temaCharla);
				
				usuarios.add(usuario);
				
			}
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
	}
	


	@Override
	public Usuario getUsuarioPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}


}
