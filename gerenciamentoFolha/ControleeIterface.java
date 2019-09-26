package gerenciamentoFolha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



import empresaConveniada.MedGrupo;
import empresaConveniada.InterfaceConvenio;
import eventos.Evento;
import eventos.EventoAtraso;
import eventos.EventoComissao;
import eventos.EventoFalta;
import eventos.EventoHoraExtra;
import eventos.EventoReajuste;
import eventos.EventoRescisao;
import excecoes.FolhaException;
import funcionarios.Funcionario;

public class ControleeIterface {

	private RepositoriodeDados BD;

	public ControleeIterface() throws ParseException {
		BD = new RepositoriodeDados();
		BD.adicionaFuncionario();
	}

	public void iniciaSistema() throws ParseException, FolhaException {

		int opcao = this.getOpcao();
		while (opcao != 4) {
			switch (opcao) {

			case 1:

				InterfaceConvenio convenio1 = new MedGrupo();
				Funcionario funcionario = BD
						.buscaFuncionario(getInt("Id funcionario: "));
				funcionario.registraConvenio(convenio1, "1");

				break;

			case 2:

				switch (getInt("opção: 1-Atraso, 2-Comissao, 3-Falta, 4-Hora Extra, 5-Reajuste, 6-rescisao ")) {

				case 1:

					Funcionario funcionarioA = BD
							.buscaFuncionario(getInt("Id funcionario: "));
					Evento eventoA = new EventoAtraso(
							strData(getStr("data dd/mm/aaaa ")),
							getInt("qtde. horas de Atraso: "));
					funcionarioA.registraEvento(eventoA);

					break;

				case 2:

					Funcionario funcionarioC = BD
							.buscaFuncionario(getInt("Id funcionario: "));
					Evento eventoC = new EventoComissao(
							strData(getStr("data dd/mm/aaaa ")),
							getInt("valor da Comissao: "));
					funcionarioC.registraEvento(eventoC);

					break;

				case 3:

					Funcionario funcionarioF = BD
							.buscaFuncionario(getInt("Id funcionario: "));
					Evento eventoF = new EventoFalta(
							strData(getStr("data dd/mm/aaaa ")));
					funcionarioF.registraEvento(eventoF);

					break;

				case 4:

					Funcionario funcionarioH = BD
							.buscaFuncionario(getInt("Id funcionario: "));
					Evento eventoH = new EventoHoraExtra(
							strData(getStr("data dd/mm/aaaa ")),
							getInt("qtde. horas: "));
					funcionarioH.registraEvento(eventoH);

					break;

				case 5:

					Funcionario funcionarioR = BD
							.buscaFuncionario(getInt("Id funcionario: "));
					Evento eventoR = new EventoReajuste(
							strData(getStr("data dd/mm/aaaa ")),
							getInt("Valor "));
					funcionarioR.registraEvento(eventoR);

					break;

				case 6:

					Funcionario funcionarioRec = BD
							.buscaFuncionario(getInt("Id funcionario: "));
					Evento eventoRec = new EventoRescisao(
							strData(getStr("data dd/mm/aaaa ")),
							getInt("Motivo-> SE_DEMITIU = 1, FOI_DEMITIDO = 2, APOSENTADO = 3: "),
							getBool("avisoPrevio -> true ou false: "));
					funcionarioRec.registraEvento(eventoRec);

					break;

				}

				break;

			case 3:

				Funcionario funcionario2 = BD
						.buscaFuncionario(getInt("Id funcionario: "));
				funcionario2.geraDemonstrativo();

				break;
			}
			opcao = getOpcao();

		}

	}

	private int getOpcao() {

		int opcao;
		do {

			opcao = getInt("Opcao: 1 - Registrar Convenio Medico, 2 - Adicionar Evento, 3 - Gerar Demonstrativo 4 - Sair");
			if (opcao != 1 & opcao != 2 & opcao != 3 & opcao != 4) {
				opcao = 0;
			}
		} while (opcao == 0);
		return opcao;
	}

	private int getInt(String string) {

		Scanner r = new Scanner(System.in);

		System.out.println("Entre com " + string);

		if (r.hasNextInt()) {
			return r.nextInt();
		}
		String st = r.next();
		System.out.println("Erro na Leitura de Dados");

		return 0;
	}

	private String getStr(String string) {

		Scanner s = new Scanner(System.in);

		System.out.println("Entre com " + string);

		if (s.hasNext()) {
			return s.next();
		}
		String st = s.next();
		System.out.println("Erro na Leitura de Dados");

		return null;
	}

	private Boolean getBool(String string) {

		Scanner t = new Scanner(System.in);

		System.out.println("Entre com " + string);

		if (t.hasNextBoolean()) {
			System.out.println("passou aqui2");
			return t.nextBoolean();
		}
		String st = t.next();
		System.out.println("Erro na Leitura de Dados");

		return null;
	}

	private Date strData(String data) throws ParseException {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		formatoData.setLenient(false);
		return formatoData.parse(data);
	}
}
