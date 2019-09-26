package funcionarios;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import folhadePagamento.InterfaceFolha;
import folhadePagamento.Lancamento;

public class Demonstrativo implements InterfaceFolha {
	private Funcionario funcionario;
	private Date dtInicial;
	private Date dtFinal;
	private ArrayList<Lancamento> lancamentos;

	public Demonstrativo(Funcionario f, Date inicio, Date fim) {
		this.funcionario = f;
		this.dtInicial = inicio;
		this.dtFinal = fim;
		this.lancamentos = new ArrayList<>();
	}

	public Date getDtInicial() {
		return this.dtInicial;
	}

	public Date getDtFinal() {
		return this.dtFinal;
	}

	public void incluiDebito(String hist, double val) throws Exception {
		this.lancamentos.add(new Lancamento(hist, -val));
	}

	public void incluiCredito(String hist, double val) throws Exception {
		this.lancamentos.add(new Lancamento(hist, val));
	}

	public String toString() {
		return ("Demonstrativo de Pagamento:" + "\n Periodo de "
				+ this.dtInicial + " a " + this.dtFinal + "\n " + this.funcionario);
	}

	public void imprime() {
		Lancamento l;
		float total = 0;
		System.out.println(this);
		Iterator<Lancamento> lista = this.lancamentos.iterator();
		while (lista.hasNext()) {
			l = (Lancamento) lista.next();
			System.out.println(l);
			total += l.getValor();
		}
		System.out.println("Total a pagar: " + total);
	}
}
