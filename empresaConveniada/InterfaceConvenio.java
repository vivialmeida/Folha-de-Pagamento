package empresaConveniada;

import folhadePagamento.InterfaceFolha;

public interface InterfaceConvenio<String> {
	void processaContrato(String id, InterfaceFolha f) throws Exception;
}