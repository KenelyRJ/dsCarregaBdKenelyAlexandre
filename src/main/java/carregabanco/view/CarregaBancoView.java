package carregabanco.view;

import java.util.ArrayList;
import carregabanco.controller.CarregaBancoController;
import carregabanco.model.AlunoModel;

public class CarregaBancoView {
	
	public CarregaBancoView() {
		
		CarregaBancoController carregaBancoController = new CarregaBancoController();
		ArrayList<AlunoModel> valores = carregaBancoController.inserirNoBanco(aluno);
		carregaBancoController.inserirNoBanco(valores);
						
		//A parte da visualiza��o seria isso
		System.out.println(valores.size());
		for(AlunoModel n: valores)
		System.out.println(n.getCampus() + " - " + n.getNome_estudante()+ " - " + n.getIdade());
		
		
	}
	public void menu() {
		
	}
	
	
}