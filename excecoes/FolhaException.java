package excecoes;

import funcionarios.Funcionario;
import eventos.Evento;

public class FolhaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String descricao;
	private Funcionario funcionario;
	private Evento evento;
	private Exception exception;

	public FolhaException(String st) {
		this.descricao = st;
	}

	public FolhaException(String st, Funcionario f) {
		this.descricao = st;
		this.funcionario = f;
	}

	public FolhaException(String st, Funcionario f, Evento e) {
		this.descricao = st;
		this.funcionario = f;
		this.evento = e;
	}

	public FolhaException(String st, Funcionario f, Exception ex) {
		this.descricao = st;
		this.funcionario = f;
		this.exception = ex;
	}

	public String toString() {
		return ("FuncionarioException: " + this.descricao
				+ (this.funcionario == null ? " " : "\n " + this.funcionario)
				+ (this.evento == null ? " " : "\n " + this.evento) + (this.exception == null ? " "
					: "\n " + this.exception));
	}
}