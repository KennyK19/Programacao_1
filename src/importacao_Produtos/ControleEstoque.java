package importacao_Produtos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ControleEstoque implements RegrasDeNegocios {
	
	public static List<Produto> produtos = new ArrayList<Produto>();
	
	@SuppressWarnings("static-access")
	public void adicionarProdutos(Produto produto) {
		
		if (!produtos.contains(produto) == true) {
			this.produtos.add(produto);
			JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO!\n" + produto);
		} else {
			JOptionPane.showMessageDialog(null, "Aten��o!!!\n" + "Produto j� est� cadastrado!");
		}
		System.out.println("tamanho lista = " + produtos.size());	
	}
	
	public Produto buscarProduto(String nome, String marca) {
		for (Produto produtoBuscados : produtos) {
			if (produtoBuscados.getNomeProduto().contains(nome.trim())
					&& produtoBuscados.getMarcaProduto().contains(marca.trim())) {
				return produtoBuscados;
			}
		}
		return null;
	}
		
	public void removerProduto(Produto produto) {
	    if (produtos.contains(produto) == true) {
	    	int resp = JOptionPane.showConfirmDialog(null, "Produto Localizado.\n\n" + produto + "\n\nDeseja Remover?");
	    	if (resp == 0) {
	    		JOptionPane.showMessageDialog(null, "O Produto\n\n" + produto + "\n\nFoi removido com sucesso!");
	    		this.produtos.remove(produto);
	    	} else {
	    		JOptionPane.showMessageDialog(null, "OK, PRODUTO N�O REMOVIDO");
	    		} 
	      }else {
	    		JOptionPane.showMessageDialog(null, "PRODUTO N�O LOCALIZADO\n" + "TENTE NOVAMENTE!");
	    	}
	}	    
	
	public void imprimindo() {
		for (Produto produtoLista : produtos) {
			System.out.println(produtoLista);
		}
	}
	
	public void buscareImprimir(Produto produto) {
		if (produtos.contains(produto) == true) {
			JOptionPane.showMessageDialog(null, produto);
		}else {
			JOptionPane.showMessageDialog(null, "SEU PRODUTO N�O LOCALIZADO\n" + "TENTE NOVAMENTE!");
		}
	}
	
	public void alterarProduto1(Produto produto) {
		String continuar = "SIM";
		while (continuar.equalsIgnoreCase("SIM")) {
			
			for (Produto produto2 : produtos) {
				if ((produto2.getNomeProduto() == produto.getNomeProduto())
					&& (produto2.getMarcaProduto() == produto.getMarcaProduto())) {
					int entrarNaAlteracao = JOptionPane.showConfirmDialog(null,"Produto localizado\n"
					+ produto2 + "\n\nATEN��O !!! \nN�o � possivel fazer altera��es de nome ou de marca\n" 
					+ "Deseja continuar?");
					if (entrarNaAlteracao == 0) {
						String alteracao = JOptionPane.showInputDialog("\nQual altera��o que deseja fazer?\n"
						+ "1 - UNIDADE MEDIDA.\n2-PRE�O UNIT�RIO\n3-QUANTIDADE\n");
						int alterarProduto = Integer.parseInt(alteracao);
						
						if (alterarProduto == 1) {
							String novaMedida = JOptionPane.showInputDialog("NOVA UNIDADE DE MEDIDA:");
							int confirmarAlteracao = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR A ALTERA��O?");
							
							if (confirmarAlteracao == 0) {
								produto2.setUnidadeMedida(novaMedida);
								
								JOptionPane.showMessageDialog(null, "PRODUTO ALTERADO COM SUCESSO!\n" + "====NOVOS DADOS====\n" + produto2);
							}
						} else if (alterarProduto == 2) {
							String preco = JOptionPane.showInputDialog("NOVO PRE�O:");
							int confirmarAlteracao = JOptionPane.showConfirmDialog(null,"DESEJA CONFIRMAR ALTERA��O");
							if (confirmarAlteracao == 0) {
								double novoPreco = Double.parseDouble(preco);
								produto2.setPrecoUnitario(novoPreco);
								JOptionPane.showMessageDialog(null,"PRODUTO ALTERADO COM SUCESSO\n" + "==== NOVOS DADOS ====\n" + produto2);
							}
						}else if (alterarProduto == 3) {
							String quantidade = JOptionPane.showInputDialog("NOVA QUANTIDADE:");
							int confirmarAlteracao = JOptionPane.showConfirmDialog(null,"DESEJA CONFIRMAR ALTERA��O?");
							if (confirmarAlteracao == 0) {
								
								int novaQuantidade = Integer.parseInt(quantidade);
								produto2.setQuantidade(novaQuantidade);
								produto2.setQuantidadeTotalEstoque(produto2.getQuantidade());
								JOptionPane.showMessageDialog(null, "PRODUTO ALTERADO COM SUCESSO!\n" + "==== NOVOS DADOS ====\n" + produto2);
							}
															
						} else {
							JOptionPane.showMessageDialog (null, "op��o incorreta, encerrando!");
						}
					}
				}
			}
		
			continuar = JOptionPane.showInputDialog ("DESEJA FAZER MAIS ALGUMA ALTERA��O?");
		}
		
	}
	
	@Override
	public void alterarProduto (Produto produto) {
		String continuar = "SIM";
		while (continuar.equalsIgnoreCase("SIM")) {
			
			for (Produto produto2 : produtos) {
				if ((produto2.getNomeProduto() == produto.getNomeProduto())
				 && (produto2.getMarcaProduto() == produto.getMarcaProduto())) {
				int entrarNaAlteracao = JOptionPane.showConfirmDialog(null,
						"Produto localizado\n" + produto2
						+ "\n\n ATEN��O!!! \n N�o � possivel fazer altera��es de nome ou marca\n"
						+ "Deseja Continuar?");
				if (entrarNaAlteracao == 0) {
					String alteracao = JOptionPane.showInputDialog("Qual altera��o que deseja fazer?\n" 
				    + "1 - UNIDADE MEDIDA \n2 - PRE�O UNIT�RIO \n3 - QUANTIDADE\n");
					int alterarProduto = Integer.parseInt(alteracao);
					
					if (alterarProduto == 1) {
						String novaMedida = JOptionPane.showInputDialog("NOVA UNIDADE DE MEDIDA:");
						int confirmarAlteracao = JOptionPane.showConfirmDialog(null,"DESEJA CONFIRMAR ALTERA��O?");
						if (confirmarAlteracao == 0) {
							produto2.setUnidadeMedida(novaMedida);
							
							JOptionPane.showMessageDialog(null, "PRODUTO ALTERADO COM SUCESSO!\n" + "==== NOVOS DADOS ====\n" + produto2);
						}
					}else if (alterarProduto == 2) {
					   String preco = JOptionPane.showInputDialog("NOVO PRE�O:");
					   int confirmarAltaracao = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR ALTERA��O");
					   if (confirmarAltaracao == 0) {
						   double novoPreco = Double.parseDouble(preco);
						   produto2.setPrecoUnitario(novoPreco);
						   JOptionPane.showMessageDialog(null,"PRODUTO ALTERADO COM SUCESSO!\n" + "==== NOVOS DADOS ====\n" + produto2);
						   }
					       } else {
						JOptionPane.showMessageDialog(null,"op��o incorreta, encerrado!");
					}
				  }
				}
			 }
			
			continuar = JOptionPane.showInputDialog("DESEJA FAZER MAIS ALGUMA ALTERA��O?");
		}
    }
	
	public void entradaProduto(Produto produto) {
		// TODO Auto-generated method stub  TODO Auto-generated method stub
		if(produtos.contains(produto) == true) {
			String quant = JOptionPane.showInputDialog("INFORME A QUANTIDADE:");
			int quantidade = Integer.parseInt(quant);
			produto.setQuantidade(quantidade);
			int adicionarProduto = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR A ENTRADA?");
			if (adicionarProduto == 0) {
				
				produto.setQuantidadeTotalEstoque(produto.getQuantidadeTotalEstoque() + produto.getQuantidade());
				JOptionPane.showMessageDialog(null, "NOVOS DADOS DO PRODUTO\n\n" + produto);
			}
		}else {
			JOptionPane.showMessageDialog(null, "PRODUTO N�O LOCALIZADO!");
		}
	}
	public void saidaProduto(Produto produto) {
		if(produtos.contains(produto) == true) {
			String quant = JOptionPane.showInputDialog("INFORME A QUANTIDADE:");
			int quantidade = Integer.parseInt(quant);
			produto.setQuantidade(quantidade);
			int saidaProduto = JOptionPane.showConfirmDialog(null,"DESEJA CONFIRMAR A ENTRADA?");
			if (saidaProduto == 0) {
				
				produto.setQuantidadeTotalEstoque(produto.getQuantidadeTotalEstoque() - produto.getQuantidade());
				JOptionPane.showMessageDialog(null, "NOVOS DADOS DO PRODUTO\n\n" + produto);
			}
		}else {
			JOptionPane.showMessageDialog(null, "PRODUTO N�O LOCALIZADO!");
		}
	}
	
	public void listaTotalProdutos() {
		for (Produto produtosTotaisEstoque : produtos) {
			JOptionPane.showMessageDialog(null, produtosTotaisEstoque);
		}
	}
	
	public void reajustePreco(Produto produto) {
		if (produtos.contains(produto) == true) {
		    String preco = JOptionPane.showInputDialog("INFORME O PERCENTUAL DE AUMENTO:");
		    double porcentagem = Double.parseDouble(preco);
		    double novoPreco = (produto.getPrecoUnitario() + (produto.getPrecoUnitario() * porcentagem) / 100);
		    int ajustarPreco = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR A ENTRADA?");
		    if (ajustarPreco == 0) {
		    	produto.setPrecoUnitario(novoPreco);
		    	JOptionPane.showMessageDialog(null, "NOVOS DADOS DO PRODUTO\n\n" + produto);
		    }
		}else {
			JOptionPane.showMessageDialog(null, "PRODUTO N�O LOCALIZADO!");
			
		}
	}

}
