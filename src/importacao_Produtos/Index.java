package importacao_Produtos;

import javax.swing.JOptionPane;

public class Index {
	
	public static void main(String[] args) {
		
		TelasMenu tela = new TelasMenu();
		
		int opMenu;
		do {
			
			opMenu = tela.telaPrincipal();
			
			switch (opMenu) {
			case 0:
				opMenu = 0;
				System.out.println("Programa sendo encerrado...");
				break;
			case 1:
				int opMenuCadastro = tela.telaCadastro();
				switch (opMenuCadastro) {
				case 0:
					JOptionPane.showMessageDialog(null, "Retornando ao Menu Principal");
					break;
				case 1:
					String continuarInclusao = "SIM";
					while (continuarInclusao.equalsIgnoreCase("SIM")) {
						
						Produto produto = new Produto();
						ControleEstoque dadosProduto = new ControleEstoque();
						
						produto.setNomeProduto(JOptionPane.showInputDialog ("NOME:").toUpperCase());
						produto.setMarcaProduto(JOptionPane.showInputDialog ("MARCA:").toUpperCase());
						produto.setUnidadeMedida(JOptionPane.showInputDialog ("UNIDADE MEDIDA:").toUpperCase());
						String quant = JOptionPane.showInputDialog("QUANTIDADE:");
						int quantidade = Integer.parseInt(quant);
						produto.setQuantidade(quantidade);
						produto.setQuantidadeTotalEstoque(produto.getQuantidade());
						String preco = JOptionPane.showInputDialog("PREÇO UNITÁRIO:");
						double valor = Double.parseDouble(preco);
						produto.setPrecoUnitario(valor);
						dadosProduto.adicionarProdutos(produto);
						dadosProduto.imprimindo();
						
						continuarInclusao = JOptionPane.showInputDialog("Deseja continuar cadastrando?\n [SIM/NÃO]");
					}
					break;
					
				case 2:
					System.out.println("entrei na alteração de produtos"); 
					Produto produtoAlterar = new Produto();
					produtoAlterar.setNomeProduto (JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n" + "NOME DO PRODUTO:").toUpperCase());
					produtoAlterar.setMarcaProduto (JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n" + "MARCA").toUpperCase());
					ControleEstoque alterarProdutoLista = new ControleEstoque();
					Produto localizarParaAlterar = alterarProdutoLista.buscarProduto(produtoAlterar.getNomeProduto(), produtoAlterar.getMarcaProduto());
					alterarProdutoLista.alterarProduto(localizarParaAlterar);
					
					break;
					
				case 3:
					
					Produto localizar = new Produto();
					localizar.setNomeProduto (JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n" + "NOME DO PRODUTO").toUpperCase());
					localizar.setMarcaProduto (JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n" + "MARCA:").toUpperCase());
					ControleEstoque buscandoProdutoLista = new ControleEstoque();
                    Produto buscarDadoseImprimir = buscandoProdutoLista.buscarProduto(localizar.getNomeProduto(),localizar.getMarcaProduto());
					buscandoProdutoLista.buscareImprimir(buscarDadoseImprimir);
					
					break;
					
				case 4:
					
					String continuarRemover = "SIM";
					while(continuarRemover.equalsIgnoreCase("SIM")) {
						
						ControleEstoque remocaoProduto = new ControleEstoque();
						Produto produto = new Produto();
						produto.setNomeProduto (JOptionPane.showInputDialog("PAGINA DE REMOÇÃO DE PRODUTO\n" + "NOME DO PRODUTO").toUpperCase());
						produto.setMarcaProduto(JOptionPane.showInputDialog("PAGINA DE REMOÇÃO DE PRODUTO\n" + "MARCA:").toUpperCase());
						Produto buscarDadoseRemover = remocaoProduto.buscarProduto(produto.getNomeProduto(), produto.getMarcaProduto());
						int confirmarExclusao = JOptionPane.showConfirmDialog (null, "DESEJA REMOVER?");
						if(confirmarExclusao == 0) {
							remocaoProduto.removerProduto(buscarDadoseRemover);
						}
						continuarRemover = JOptionPane.showInputDialog ("DESEJA CONTINUAR?");									
					}
					
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Valor invalido!\nTeste Novamente");
				}
				break;
				
			case 2:
				
				int opMenuMovimentacao = tela.telaMovimentacao();
				switch (opMenuMovimentacao) {
				case 0:
					JOptionPane.showMessageDialog(null, "Retornnado ao menu principal");
					break;
				case 1:
					
					String continuar = "SIM";
					while(continuar.equalsIgnoreCase("SIM"));{
					   Produto entradaProduto = new Produto();
					   ControleEstoque aumentarQuantidade = new ControleEstoque();
					   int entrada = JOptionPane.showConfirmDialog(null, "VOCÊ ESTÁ NA PAGINA DE ENTRADA DE PRODUTOS." + "DESEJA CONTINUAR?");
				    if(entrada == 0) {
	                    
				    	entradaProduto.setNomeProduto(JOptionPane.showInputDialog("INFORME NOME:").toUpperCase());
				    	entradaProduto.setMarcaProduto(JOptionPane.showInputDialog("INFORME MARCA:").toUpperCase());
				    	Produto buscar = aumentarQuantidade.buscarProduto(entradaProduto.getNomeProduto(),entradaProduto.getMarcaProduto());
				    	aumentarQuantidade.entradaProduto(buscar);
				    	}else {
				    		continuar = "NÃO";
				    	}     
				        if (continuar != "NÃO") {
				        	
				        	continuar = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
				        }
				}   
				        
				        break;
				case 2:
					 
					continuar = "SIM";
					while (continuar.equalsIgnoreCase("SIM")) {
						Produto saidaProduto = new Produto();
						ControleEstoque aumentarQuantidade = new ControleEstoque();
						int entrada = JOptionPane.showConfirmDialog(null, "VOCÊ ESTÁ NA PAGINA DE SAIDA DE PRODUTOS.\n" + "DESEJA CONTINUAR?");
						
						if (entrada == 0) {
							
							saidaProduto.setNomeProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
							saidaProduto.setMarcaProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
							Produto buscar = aumentarQuantidade.buscarProduto(saidaProduto.getNomeProduto(), saidaProduto.getMarcaProduto());
							aumentarQuantidade.saidaProduto(buscar);		
						}else{
							continuar = "NÃO";
						}
						
						if(continuar != "NÃO") {
							
							continuar = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
						}
				}
					break;
				default:
				   JOptionPane.showMessageDialog(null, "Valor invalido! \nTente novamente");				
				}
				break;
			case 3:
				 String continuar = "SIM";
				while (continuar.equalsIgnoreCase("SIM")) {
					Produto ajustarProduto = new Produto();
					ControleEstoque aumentarQuantidade = new ControleEstoque();
					int entrada = JOptionPane.showConfirmDialog(null, "VOCÊ ESTÁ NA PAGINA DE REAJUSTE DE PREÇO.\n" + "DESEJO CONTINUAR?");
					if (entrada == 0) {
						
						ajustarProduto.setNomeProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
						ajustarProduto.setMarcaProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
						Produto buscar = aumentarQuantidade.buscarProduto(ajustarProduto.getNomeProduto(), ajustarProduto.getMarcaProduto());
						aumentarQuantidade.reajustePreco(buscar);
					}else {
						continuar = "NÃO";
					}
					if(continuar != "NÃO") {
						
						continuar = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
					}
				}
				break;
			case 4:
				System.out.println("Entrada no relatorio dos produtos");
				ControleEstoque totalProdutos = new ControleEstoque();
				totalProdutos.listaTotalProdutos();
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Valor invalido!\nTente novamente");
			}
		} while (opMenu != 0);
					
   }
	
}
