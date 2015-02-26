package br.com.sts.ddum.model.enums;

public enum QueryEnum {

	UNIDADES_CONTABEIS(
			"SELECT DISTINCT cgp.unidade.cd_unidade, cgp.unidade.nm_unidade FROM  cgp.orcamento INNER JOIN cgp.atividade_projeto ON (cgp.orcamento.cd_atividade_projeto = cgp.atividade_projeto.cd_atividade_projeto) INNER JOIN cgp.unidade ON (cgp.orcamento.cd_unidade = cgp.unidade.cd_unidade) "), ATIVIDADES_CONTABEIS(
			"SELECT DISTINCT cgp.atividade_projeto.cd_atividade_projeto, cgp.atividade_projeto.de_atividade_projeto, cgp.orcamento.cd_orgao FROM  cgp.orcamento   "
					+ "INNER JOIN cgp.atividade_projeto ON (cgp.orcamento.cd_atividade_projeto = cgp.atividade_projeto.cd_atividade_projeto)  "
					+ "INNER JOIN cgp.unidade ON (cgp.orcamento.cd_unidade = cgp.unidade.cd_unidade) WHERE cgp.unidade.cd_unidade = %s "), CONTAS_CONTABEIS(
			"SELECT DISTINCT cgp.plano_conta.cd_codigo_conta,   cgp.plano_conta.de_titulo FROM  cgp.orcamento   "
					+ "INNER JOIN cgp.atividade_projeto ON (cgp.orcamento.cd_atividade_projeto = cgp.atividade_projeto.cd_atividade_projeto)  INNER JOIN cgp.plano_conta ON (cgp.orcamento.cd_codigo_conta = cgp.plano_conta.cd_codigo_conta)  INNER JOIN cgp.unidade ON (cgp.orcamento.cd_unidade = cgp.unidade.cd_unidade) WHERE cgp.atividade_projeto.cd_atividade_projeto = %s "), RECURSOS_CONTABEIS(
			"SELECT DISTINCT cgp.fonte_recurso.cd_fonte_recurso,   cgp.fonte_recurso.de_fonte_recurso FROM  cgp.orcamento   INNER JOIN cgp.fonte_recurso ON (cgp.orcamento.cd_fonte_recurso = cgp.fonte_recurso.cd_fonte_recurso)   INNER JOIN cgp.atividade_projeto ON (cgp.orcamento.cd_atividade_projeto = cgp.atividade_projeto.cd_atividade_projeto)  INNER JOIN cgp.plano_conta ON (cgp.orcamento.cd_codigo_conta = cgp.plano_conta.cd_codigo_conta)  INNER JOIN cgp.unidade ON (cgp.orcamento.cd_unidade = cgp.unidade.cd_unidade) WHERE cgp.plano_conta.cd_codigo_conta LIKE '%s%%' ");

	private String descricao;

	private QueryEnum(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public enum Responsavel {

		RESPONSAVEL_FIREBIRD(
				"select DISTINCT servidor.servidor_id,  servidor.matricula_funcional,	    servidor.cpf,	    servidor.rg,    servidor.orgao_expedidor,	    servidor.data_expedicao_rg,	    servidor.nome_servidor,     local_pagamento.codigo_banco, 	    servidor.conta_salario,	    servidor.tipo_conta_salario, 	    servidor.dv_conta_salario,     servidor.dv_agencia_salario,     servidor.endereco_residencial,     servidor.bairro,     servidor.cidade,    servidor.uf,     cargos.cargo_id,     cargos.nome_cargo, servidor.agencia_salario	FROM servidor 	   inner join local_pagamento on (servidor.local_pagamento_id = local_pagamento.local_pagamento_id)	   inner join cargos on (servidor.cargo_id = cargos.cargo_id), fonte_recurso");
		private String descricao;

		private Responsavel(String descricao) {
			this.descricao = descricao;
		}

		@Override
		public String toString() {
			return descricao;
		}
		// "select DISTINCT servidor.matricula_funcional, servidor.cpf, servidor.nome_servidor, local_pagamento.codigo_banco, servidor.conta_salario,  servidor.tipo_conta_salario,  servidor.dv_conta_salario,  servidor.dv_agencia_salario from servidor inner join local_pagamento on (servidor.local_pagamento_id = local_pagamento.local_pagamento_id) ");
	}

	public enum ParametroRepasse {

		DOTACAO_ORCAMENTO_ID(
				"SELECT DISTINCT orc.rowid_orcamento FROM cgp.orcamento orc WHERE orc.cd_unidade = %s AND orc.cd_atividade_projeto = %s AND orc.cd_codigo_conta = '%s' AND orc.cd_fonte_recurso = %s AND orc.nu_exercicio = %s");

		private String descricao;

		private ParametroRepasse(String descricao) {
			this.descricao = descricao;
		}

		@Override
		public String toString() {
			return descricao;
		}
	}
}