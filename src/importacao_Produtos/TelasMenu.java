package importacao_Produtos;

import javax.swing.JOptionPane;

public class TelasMenu {
	
	public int telaPrincipal() {
		int opcao;
		String opcaoMenuPrincipal = JOptionPane.showInputDialog(
				"EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n"
				+ "=====================================\n" + "*************MENU*************\n"
				+ "=====================================\n" + "1- CADASTRO DE PRODUTOS\n" + "2- MOVIMENTA��O \n"
				+ "3- REAJUSTE DE PRE�OS  \n" + "4- RELAT�TIOS        \n" + "0- FINALIZAR     \n"
				+ "OP��O:");
		opcao = Integer.parseInt(opcaoMenuPrincipal);
		return opcao;
				
	}
	
	public int telaCadastro() {
		int opcao;
		String opcaoMenuCadastro = JOptionPane.showInputDialog("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\n"
		        + "SISTEMA DE CONTROLE DE ESTOQUE\n" + "=====================================\n" 
				+ "***********CADASTRO***********\n" + "=====================================\n" 
		        + "1- INCLUS�O\n" + "2- ALTERA��O \n"
				+ "3- CONSULTA  \n" + "4- EXCLUS�O \n" + "0- RETORNAR\n" + "OP��O:");
		opcao = Integer.parseInt(opcaoMenuCadastro);
		return opcao;
	}
	
	public int telaMovimentacao() {
		int opcao;
		String opcaoMenuMovimentacao = JOptionPane.showInputDialog("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\n"
		        + "SISTEMA DE CONTROLE DE ESTOQUE\n" + "=====================================\n" 
				+ "*********MOVIMENTA��O*********\n" + "=====================================\n" 
		        + "1- ENTRADA\n" + "2- SAIDA \n" + "0- RETORNAR\n");
		opcao = Integer.parseInt(opcaoMenuMovimentacao);
		return opcao;
	}
	

}




