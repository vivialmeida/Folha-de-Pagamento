package eventos;
import java.util.Date;
import excecoes.FolhaException;

public class EventoComissao extends Evento {
	public EventoComissao(Date dt, double val) throws FolhaException {
		super(dt, val);
		if (val <= 0)
			throw new FolhaException("Comissao com valor <= 0.");
	}

}
