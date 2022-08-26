package maven.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO extends DAO {
	
	public ClienteDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Cliente cliente) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO cliente (id, nome, endereco, idade, sexo) "
				       + "VALUES ("+cliente.getId()+ ", '" + cliente.getNome() + ",'"+ cliente.getEndereco() + "', '"  
				       + cliente.getIdade() + "', '" + cliente.getSexo() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public void inserirCliente(ClienteDAO clienteDAO) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n==== Inserir cliente === ");
		System.out.print("\nDigite o id: ");
		int id = sc.nextInt();
		System.out.print("\nDigite o nome: ");
		String nome = sc.next();
		System.out.print("\nDigite o endereço: ");
		String endereco = sc.next();
		System.out.print("\nDigite a idade: ");
		int idade = sc.nextInt();
		System.out.print("\nDigite o sexo: ");
		char sexo = sc.next().charAt(0);
		Cliente cliente = new Cliente(id, nome, endereco, idade, sexo);
		if(clienteDAO.insert(cliente) == true) {
		System.out.println("Inserção com sucesso -> " + cliente.toString());
		}
		
		sc.close();
	}

	
	public List<Cliente> get(String orderBy) {	
	
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM cliente" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Cliente u = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getInt("idade"), rs.getString("sexo").charAt(0));
	            clientes.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return clientes;
	}

	public boolean update(Cliente cliente) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n\n==== Atualizar cliente === ");
			System.out.print("\nDigite o id do cliente a ser alterado: ");
			int id = sc.nextInt();
			System.out.print("\nNovo nome: ");
			String nome = sc.next();
			System.out.print("\nNovo endereco: ");
			String endereco = sc.next();
			System.out.print("\nNova idade: ");
			int idade = sc.nextInt();
			System.out.print("\nNovo sexo: ");
			char sexo = sc.next().charAt(0);
			String sql = "UPDATE pessoa SET nome = '" + nome + "', endereco = '"+ endereco + "', idade = '"  
				       + idade + "', sexo = '" + sexo + "'"
					   + " WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			sc.close();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM pessoa WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public void deletarCliente(ClienteDAO clienteDAO) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n==== Deletar cliente === ");
		System.out.println("\nDigite o id: ");
		int id = sc.nextInt();
		clienteDAO.delete(id);
		
     	System.out.println("Cliente deletado com sucesso -> id = " + id );
		
		sc.close();
	}


}
