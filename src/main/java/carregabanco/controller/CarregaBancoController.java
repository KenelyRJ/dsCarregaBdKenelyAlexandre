package carregabanco.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carregabanco.model.AlunoModel;
import carregabanco.model.PessoaModel;
import carregabanco.repository.AlunoDao;

public class CarregaBancoController {

	public void inserirNoBanco (AlunoModel aluno) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.persist(aluno);
	}
		
		

	private void update(Scanner scanner) {

		System.out.println("######################### Atualizar #########################");

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

		AlunoModel alunoModel = new AlunoModel();
		alunoModel.setNome_estudante(nome_estudante);
	}

	private ArrayList<AlunoModel> valores = new ArrayList<AlunoModel>();

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

}
