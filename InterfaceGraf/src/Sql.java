import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Sql {
	private Connection connection = null;
				// gerencia as consultas com o banco de dados
				private Statement statement = null;
				// armazena as irfoma��es vindo de um select.
				private ResultSet resultset = null;
				// 1� Java data base connection
				// 2 � servidor
				// 3 � nome da tabela
				String servidor = "jdbc:mysql://localhost:3306/JAVA";
				// login do banco de dados
				String usuario ="root";
				String senha = "";
				// Driver utilizado para conex�o
				String driver= "com.mysql.jdbc.Driver";
				//Exce��o
				try {
					// faz conex�o com o banco 
					this.connection = DriverManager.getConnection(servidor, usuario, senha);
					// cria o ambiente para executar c�digos  dentro do banco
					this.statement = this.connection.createStatement();
					System.out.println("Conex�o efetuada com sucesso");
				}catch (Exception e) {
					System.out.println("Erro: "+ e.getMessage());

				}
				// gerencia a conex�o com o banco de dados 
				public ResultSet listarAmigos() {

					try {
					String query = "select * from amigo";
					this.resultset =this.statement.executeQuery(query);
				}catch (Exception e) {
					 System.out.println("Erro: "+ e.getMessage());
					}
					return resultset;
				}

				//DELETAR CONTATOS 
			public void deletarContatos(String id ) {
							try {
								String query = "delete from amigo where id_amigo = '"+id+"'";
								System.out.println(this.statement.executeUpdate(query));

							}catch(Exception e) {
								System.out.println("Erro :"+e.getMessage());
							}

						}

			 
			// ATUALIZAR CONTATOS 
			public void atualizarContato(String id, String nome, String apelido, String telefone) {
							try {
								String query = "update amigo set nome ='"+nome+"', "
										+ "apelido = '"+apelido+"', telefone ='"+telefone+"' "
										+ "where id_amigo ='"+id+"'";
								System.out.println(this.statement.executeUpdate(query));
							}catch(Exception e) {
								System.out.println("Erro :"+e.getMessage());
							}

						}

			}
				
}
}
