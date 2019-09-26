package gerenciamentoFolha;

import funcionarios.Funcionario;
import funcionarios.FuncionarioComissionado;
import funcionarios.FuncionarioMensalista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class RepositoriodeDados {

	private ArrayList<Funcionario> funcionarios;


	public RepositoriodeDados() throws ParseException {
		
		this.funcionarios = new ArrayList<Funcionario>();

	}
	
	public void adicionaFuncionario() throws ParseException {
		this.funcionarios.add(new FuncionarioComissionado("Joao Carlos", strData("10/05/2017"), 1500));

		this.funcionarios.add(new FuncionarioComissionado("Camila Lima", strData("10/05/2017"),2500));

		this.funcionarios.add(new FuncionarioMensalista("Paula de Sousa", strData("10/06/2017"),3500));

		this.funcionarios.add(new FuncionarioComissionado("Carlos Alberto",strData("02/01/2018"), 4500));

		this.funcionarios.add(new FuncionarioMensalista("Samiao Dias", strData("10/01/2017"),3500));

		this.funcionarios.add(new FuncionarioComissionado("Maria Jose", strData("10/12/2017"),5500));

		this.funcionarios.add(new FuncionarioMensalista("Sebastiana Francisca",strData("10/05/2015"), 2500));

		this.funcionarios.add(new FuncionarioComissionado("Rose Leite", strData("10/05/2013"),3500));

		this.funcionarios.add( new FuncionarioMensalista("Camila Sales", strData("10/05/2012"),2500));

		this.funcionarios.add(new FuncionarioComissionado("Jose Cristo", strData("08/05/2017"),2500));

	}

	public Funcionario buscaFuncionario(int idFuncionario) {

		Iterator<Funcionario> it = this.funcionarios.iterator();
		
		while (it.hasNext()) {
			
			Funcionario funcionarioSelct = (Funcionario) it.next();
			if (funcionarioSelct.getIdFuncionario()==idFuncionario) {
				return funcionarioSelct;
			}			
		}
		return null;
	}

	private Date strData(String data) throws ParseException {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		formatoData.setLenient(false);
		return formatoData.parse(data);
	}

}
