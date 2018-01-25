package br.com.saude.prontuario.model.enums;

public enum ResultMessages {

	CREATE_SUCESS("Registro Realizado com Sucesso!"), UPDATE_SUCESS(
			"Registro Atualizado com Sucesso!"), DELETE_SUCESS(
			"Registro Removido com Sucesso!"),

	ERROR_CRUD("Ocorreu um erro durante a operação!"),

	INVALID_CPF("Número do CPF inválido!"),

	INVALID_COD_BANK(
			"De acordo com Parâmetro de Repasse o código do Banco deve ser: "),

	ERROR_LOAD_DOTACAO("Ocorreu um erro durante o carregamento da Dotação!"),

	ERROR_ONLY_ADMIN_OPERATION(
			"Somente o Administrador pode realizar esta operação!"), ERROR_ONLY_ADMIN_AND_GESTOR_OPERATION(
			"Somente o Administrador ou Gestor podem realizar esta operação!"),

	ERROR_DUPLICATE_OBJECT("Já existe %s para os dados %s informados !");

	private String descricao;

	private ResultMessages(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * @description enum descreve mensagens relacionadas às permissões de
	 *              usuário
	 * @author developer
	 *
	 */
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

	public enum ResponsavelMessage {

		INVALID_REPONSAVEL(
				"O Empenho não pode ser gerado, pois a data final da vigência do Responsável expirou!");

		private String descricao;

		private ResponsavelMessage(String message) {
			this.descricao = message;
		}

		public String getDescricao() {
			return descricao;
		}
	}
}
