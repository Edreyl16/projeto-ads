package com.github.jjunio01.projeto.ads.vendas;

import javax.swing.JOptionPane;

/**
 * @author JJunio
 *
 */
public class CupomVenda {

	public static void mostrarCupom(Vendas venda) {
		JOptionPane.showInternalMessageDialog(null, venda.toString());
	}
}
