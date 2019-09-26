package eventos;
import java.util.Date;

public class EventoFalta extends Evento {

	public EventoFalta(Date dt) {
		super(dt, 0);
	}

	public String toString() {
		return super.getTipoEvento() + " em " + super.getDtEvento();
	}

}
