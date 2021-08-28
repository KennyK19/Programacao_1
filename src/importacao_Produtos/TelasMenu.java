package importacao_Produtos;

import javax.swing.JOptionPane;

public class TelasMenu {
	
	public int telaPrincipal() {
		int opcao;
		String opcaoMenuPrincipal = JOptionPane.showInputDialog(
				"EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n"
				+ "=====================================\n" + "*************MENU*************\n"
				+ "=====================================\n" + "1- CADASTRO DE PRODUTOS\n" + "2- MOVIMENTAÇÃO \n"
				+ "3- REAJUSTE DE PREÇOS  \n" + "4- RELATÓTIOS        \n" + "0- FINALIZAR     \n"
				+ "OPÇÃO:");
		opcao = Integer.parseInt(opcaoMenuPrincipal);
		return opcao;
				
	}
	
	public int telaCadastro() {
		int opcao;
		String opcaoMenuCadastro = JOptionPane.showInputDialog("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n"
		        + "SISTEMA DE CONTROLE DE ESTOQUE\n" + "=====================================\n" 
				+ "***********CADASTRO***********\n" + "=====================================\n" 
		        + "1- INCLUSÃO\n" + "2- ALTERAÇÃO \n"
				+ "3- CONSULTA  \n" + "4- EXCLUSÃO \n" + "0- RETORNAR\n" + "OPÇÃO:");
		opcao = Integer.parseInt(opcaoMenuCadastro);
		return opcao;
	}
	
	public int telaMovimentacao() {
		int opcao;
		String opcaoMenuMovimentacao = JOptionPane.showInputDialog("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n"
		        + "SISTEMA DE CONTROLE DE ESTOQUE\n" + "=====================================\n" 
				+ "*********MOVIMENTAÇÃO*********\n" + "=====================================\n" 
		        + "1- ENTRADA\n" + "2- SAIDA \n" + "0- RETORNAR\n");
		opcao = Integer.parseInt(opcaoMenuMovimentacao);
		return opcao;
	}
	

}




