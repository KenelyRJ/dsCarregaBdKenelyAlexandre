package carregabanco.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;

public class CarregaBancoController {
	private static ArrayList<AlunoModel> valores = new ArrayList<AlunoModel>();
	//campus, polo, coordenacao, curso, nome_estudante, situacao, idade, sexo, email_institucional, periodo_entrada
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
				aluno.setIdade(!data[6].isBlank() && !data[6].isEmpty()? Integer.parseInt(data[6]) : 0);
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
		for(AlunoModel aluno : listaDeAlunos) {
			alunoDao.persist(aluno);
		}
	}
	
	
}
