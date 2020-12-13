package com.github.jjunio01.projeto.ads.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.github.jjunio01.projeto.ads.entidades.Usuario;

/**
 * @author JJunio
 *
 */
public class UsuarioDAOImplCSV implements UsuarioDAO {

	private final String caminho = "databaseUsuarios.txt";

	@Override
	public void remover(String login) {

		List<Usuario> usuarioCadastrados = listarTodos();
		for (Usuario cadastrado : usuarioCadastrados) {
			if (cadastrado.getLogin().equals(login)) {
				usuarioCadastrados.remove(cadastrado);
				adicionarLista(usuarioCadastrados);
				JOptionPane.showMessageDialog(null, "Usu�rio removido com sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}

	}

	@Override
	public List<Usuario> listarTodos() {

		try {
			return (ArrayList<Usuario>) FileUtil.recuperarInformacoes(caminho);

		} catch (ClassNotFoundException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados.", "Sistema CompreAqui",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public void adicionar(Usuario usuario) {

		List<Usuario> usuarioCadastrados = listarTodos();
		usuarioCadastrados.add(usuario);
		try {
			FileUtil.gravarInformacoes(usuarioCadastrados, caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Usuario t) {

		List<Usuario> usuarioCadastrados = listarTodos();
		for (Usuario cadastrado : usuarioCadastrados) {
			if (cadastrado.getLogin().equals(t.getLogin())) {
				usuarioCadastrados.remove(cadastrado);
				usuarioCadastrados.add(t);
				adicionarLista(usuarioCadastrados);
				JOptionPane.showMessageDialog(null, "Usu�rio atualizado com sucesso.", "Sistema CompreAqui",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}

	}

	@Override
	public void adicionarLista(List<Usuario> t) {
		try {
			FileUtil.gravarInformacoes(t, caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}