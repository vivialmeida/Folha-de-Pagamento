package eventos;

import excecoes.FolhaException;
import java.util.Date;

public class EventoHoraExtra extends Evento {

	private double qtdHoras;

	public EventoHoraExtra(Date dt, double qtd) throws FolhaException {
		super(dt, qtd);
		if (qtd > 4)
			throw new FolhaException("HoraExtra com qtde. horas > 4.");
	}

}
