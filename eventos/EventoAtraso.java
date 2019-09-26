package eventos;

import java.util.Date;
import excecoes.FolhaException;

public class EventoAtraso extends Evento {
	public EventoAtraso(Date dt, double qtd) throws FolhaException {
		super(dt, qtd);
		if (qtd > 2)
			throw new FolhaException("Atraso com qtde. horas > 2");
	}

}
