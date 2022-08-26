package maven.project;

import java.util.*;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		

		do {
			
			System.out.println("1 - Listar\n2 - Inserir\n3 - Excluir\n4 - Atualizar\n5 - Sair\n");
			System.out.print("\nEscolha: ");
			opcao = sc.nextInt();
			
			while (opcao < 1 || opcao > 5) {
				System.out.println("\nOpcao Invalida!\n");
				System.out.println("1 - Listar\n2 - Inserir\n3 - Excluir\n4 - Atualizar\n5 - Sair\n");
				System.out.print("\nEscolha: ");
				opcao = sc.nextInt();
			}
		    switch (opcao) {
		      case 1: clienteDAO.get("id"); break;
		      case 2: clienteDAO.inserirCliente(clienteDAO); break;
		      case 3: clienteDAO.deletarCliente(clienteDAO); break;
		      case 4: clienteDAO.update(cliente); break;
		      case 5: clienteDAO.finalize(); break;
	        }
		} while (opcao != 5 );
		
		sc.close();
	
	}
}