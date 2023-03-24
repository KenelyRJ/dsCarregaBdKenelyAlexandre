package carregabanco;

import java.sql.SQLException;
import java.util.Scanner;

import carregabanco.controller.CarregaBancoController;
import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;
import carregabanco.view.CarregaBancoView;

public class CarregaBanco {
	/*public static void main(String[] args) {
		new CarregaBancoView().main();
		//CarregaBancoController.loader(CarregaBancoView.class, args);
		//AlunoModel alunoModel = AlunoDao.getInstance().getById(1);    
	}*/
	
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
				inserirNoBanco(scanner);
				break;
				/*case 2:
				update(scanner);
				break;
			case 3:
				buscar();
				break;
			case 4:
				listar();
				break;
			case 5:
				excluir();
				break;*/
			case 0:
				System.out.println("Até a próxima!");
				break;
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}

	public static void inserirNoBanco(Scanner scanner) {
		
		System.out.println("\n######################### Cadastrar Aluno #########################");

		System.out.println("Digite o nome do aluno ");
		String nome_estudante = scanner.nextLine();
		System.out.println("Digite a cordenação ");
		String coordenacao = scanner.next();
		System.out.println("Digite o curso ");
		String curso = scanner.next();
		System.out.println("Digite a situação ");
		String situacao = scanner.next();
		System.out.println("Digite a o período de entrada ");
		String periodo_entrada = scanner.next();
		
		System.out.println("\n***** Dados para Pessoa *****");
		
		System.out.println("Digite o campus do aluno");
		String campus = scanner.next();
		System.out.println("Digite o polo ");
		String polo = scanner.next();
		System.out.println("Digite o email ");
		String email_institucional = scanner.next();
		System.out.println("Digite a idade ");
		int idade = scanner.nextInt();
		System.out.println("Digite o sexo");
		String sexo = scanner.next();
		
		AlunoDao alunoDao = AlunoDao.getInstance();
		
		AlunoModel aluno = new AlunoModel();
		aluno.setNome_estudante(nome_estudante);
		aluno.setCoordenacao(coordenacao);
		aluno.setCurso(curso);
		aluno.setSituacao(situacao);
		aluno.setPeriodo_entrada(periodo_entrada);
		aluno.setCampus(campus);
		aluno.setPolo(polo);
		aluno.setEmail_institucional(email_institucional);
		aluno.setIdade(idade);
		aluno.setSexo(sexo);

		alunoDao.persist(aluno);
		
		System.out.println("\n***** Aluno cadastro com sucesso *****\n");

	}
}
