package br.com.sts.ddum.model.repository.impls;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.entities.PrestacaoConta;
import br.com.sts.ddum.model.entities.QPrestacaoConta;
import br.com.sts.ddum.model.repository.interfaces.PrestacaoContaRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class PrestacaoContaRepositoryImpl extends
		QueryDslJpaRepository<PrestacaoConta, Long> implements
		PrestacaoContaRepository {

	private final QPrestacaoConta qPrestacaoConta = QPrestacaoConta.prestacaoConta;

	@Inject
	public PrestacaoContaRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<PrestacaoConta, Long>(
				PrestacaoConta.class, entityManager.getMetamodel()),
				entityManager);
	}

	@Override
	public List<PrestacaoConta> buscarPorNome(String nome) {
		return null;
	}

	@Override
	public List<PrestacaoConta> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("saldoDisponivel"))
			predicate.and(qPrestacaoConta.saldoDisponivel
					.eq((BigDecimal) params.get("saldoDisponivel")));
		if (params.containsKey("dataInicial")
				&& !params.containsKey("dataFinal"))
			predicate.and(qPrestacaoConta.dataPrestacao.after((Date) params
					.get("dataInicial")));
		if (!params.containsKey("dataInicial")
				&& params.containsKey("dataFinal"))
			predicate.and(qPrestacaoConta.dataPrestacao.before((Date) params
					.get("dataFinal")));
		if (params.containsKey("dataInicial")
				&& params.containsKey("dataFinal"))
			predicate.and(qPrestacaoConta.dataPrestacao.between(
					(Date) params.get("dataInicial"),
					(Date) params.get("dataFinal")));
		// if (params.containsKey("repasse.id"))
		// predicate.and(qPrestacaoConta.repasse.id.eq(Long.parseLong(params
		// .get("repasse.id").toString())));
		predicate.and(qPrestacaoConta.ativo.eq(true));
		return createQuery(predicate).orderBy(
				qPrestacaoConta.dataPrestacao.asc()).listDistinct(
				qPrestacaoConta);
	}

	@Override
	public List<PrestacaoConta> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		// predicate.and(qPrestacaoConta.documentos.any().documento.valor.eq(valor));
		predicate.and(qPrestacaoConta.ativo.eq(true));
		return createQuery(predicate).orderBy(
				qPrestacaoConta.dataPrestacao.asc()).listDistinct(
				qPrestacaoConta);
	}

	@Override
	public List<PrestacaoConta> autocompletar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		// if (params.containsKey("valor"))
		// predicate.and(qPrestacaoConta.numeroEmpenho.eq(Long
		// .parseLong(params.get("valor").toString())));
		// if (params.containsKey("segmento"))
		// predicate.and(qPrestacaoConta.segmento.eq((SegmentoEnum) params
		// .get("segmento")));
		predicate.and(qPrestacaoConta.ativo.eq(true));
		return createQuery(predicate).orderBy(
				qPrestacaoConta.dataPrestacao.asc()).listDistinct(
				qPrestacaoConta);
	}

}
