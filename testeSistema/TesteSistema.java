/*
 * Chaenne Milene
 * Estudo de Caso Folha de Pagamento - 09/01/2018
 */



package testeSistema;

import java.text.ParseException;

import excecoes.FolhaException;
import gerenciamentoFolha.ControleeIterface;

public class TesteSistema {
	
	
	public static void main(String[] args) throws ParseException, FolhaException {
		
		 ControleeIterface Sistema = new ControleeIterface();
		 Sistema.iniciaSistema();
		
	}

}
