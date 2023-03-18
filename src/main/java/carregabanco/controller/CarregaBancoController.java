package carregabanco.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;

public class CarregaBancoController {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("Selecione a opção desejada:");
			System.out.println("1 - Cadastrar ");
			System.out.println("2 - Editar ");
			System.out.println("3 - Buscar ");
			System.out.println("4 - Listar ");
			System.out.println("5 - Excluir");

			System.out.println("0 - Sair");

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				inserir();
				break;
			case 2:
				update();
				break;
			case 3:
				buscar();
				break;
			case 4:
				listar();
				break;
			case 5:
				excluir();
				break;
			case 0:
				System.out.println("Até a próxima!");
				break;
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}


		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome da pessoa ");
		String nome_estudante = scanner.nextLine();	
		System.out.println("Digite a cordenação ");
		String coordenacao = scanner.next();
		System.out.println("Digite o curso ");
		String curso = scanner.next();
		System.out.println("Digite a situação ");
		String situacao = scanner.next();
		System.out.println("Digite a o período de entrada ");
		String periodo_entrada = scanner.next();
		
		
			
			
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	private static ArrayList<AlunoModel> valores = new ArrayList<AlunoModel>();

	public ArrayList<AlunoModel> loader(String file) {
		try {
			Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/" + file), "UTF-8");
			BufferedReader bf = new BufferedReader(reader);
			String linha = bf.readLine();
			linha = bf.readLine();
			while (linha != null) {
				String[] data = linha.split(",");
				AlunoModel aluno = new AlunoModel();
				aluno.setCampus(data[0]);
				aluno.setPolo(data[1]);
				aluno.setCoordenacao(data[2]);
				aluno.setCurso(data[3]);
				aluno.setNome_estudante(data[4]);
				aluno.setSituacao(data[5]);
				aluno.setIdade(!data[6].isBlank() && !data[6].isEmpty() ? Integer.parseInt(data[6]) : 0);
				aluno.setSexo(data[7]);
				aluno.setEmail_institucional(data[8]);
				aluno.setPeriodo_entrada(data[9]);

				valores.add(aluno);
				linha = bf.readLine();
			}
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		return valores;
	}

	public void inserirNoBanco(ArrayList<AlunoModel> listaDeAlunos) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		for (AlunoModel aluno : listaDeAlunos) {
			alunoDao.persist(aluno);
		}

	}
}
