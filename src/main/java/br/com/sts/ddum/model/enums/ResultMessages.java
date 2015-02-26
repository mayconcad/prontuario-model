package br.com.sts.ddum.model.enums;

public enum ResultMessages {

	CREATE_SUCESS("Registro Realizado com Sucesso!"), UPDATE_SUCESS(
			"Registro Atualizado com Sucesso!"), DELETE_SUCESS(
			"Registro Removido com Sucesso!"),

	ERROR_CRUD("Ocorreu um erro durante a operação!"),

	INVALID_CPF("Número do CPF inválido!"),

	ERROR_LOAD_DOTACAO("Ocorreu um erro durante o carregamento da Dotação!");

	private String descricao;

	private ResultMessages(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public enum PermissionsMessage {

		PERMISSION_NOT_CREATE(
				"O usuário '%s' não possui permissão para criar este item"), PERMISSION_NOT_EDIT(
				"O usuário '%s' não possui permissão para editar este item"), PERMISSION_NOT_FIND(
				"O usuário '%s' não possui permissão para buscar este item");

		private String descricao;

		private PermissionsMessage(String message) {
			this.descricao = message;
		}

		public String permissaoUsuario(String userName) {
			return String.format(descricao, userName);
		}
	}
}
