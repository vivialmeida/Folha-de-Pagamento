package eventos;

import java.util.Date;
import excecoes.FolhaException;

public class EventoReajuste extends Evento {
	public EventoReajuste(Date dt, double val) throws FolhaException {
		super(dt, val);
		if (val < 300)
			throw new FolhaException("Reajuste com novo salario < 300.");
	}

}
