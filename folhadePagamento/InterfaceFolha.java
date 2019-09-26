package folhadePagamento;

import java.util.Date;

public interface InterfaceFolha {
	
	Date getDtInicial() throws Exception;

	Date getDtFinal() throws Exception;

	void incluiDebito(String hist, double val) throws Exception;

	void incluiCredito(String hist, double val) throws Exception;
}