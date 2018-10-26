package br.com.deliver.testePratico.service;

import br.com.deliver.testePratico.model.Contas;
import br.com.deliver.testePratico.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContasService {

    private ContasRepository repository;

    @Autowired
    public ContasService(ContasRepository repository) {
        this.repository = repository;
    }

    public void save(Contas conta) {
        setDiasAtraso(conta);

        conta.setValorCorrigido(conta.getValor());

        if (conta.getDiasAtraso() > 0) {
            Double multa = 1.05;
            Double juros = 1.003;

            if (conta.getDiasAtraso() <= 3) {
                multa = 1.02;
                juros = 1.001;
            } else if (conta.getDiasAtraso() <= 5) {
                multa = 1.03;
                juros = 1.002;
            }

            conta.setValorCorrigido(calculateJuros(conta, multa, juros));
        }

        this.repository.save(conta);
    }

    public List<Contas> findAll() {
        return this.repository.findAll();
    }

    private Double calculateJuros(Contas conta, Double multa, Double juros) {
        double valorCorrigido = conta.getValor() * multa;

        for (int i = 0; i < conta.getDiasAtraso(); i++) {
            valorCorrigido = valorCorrigido * juros;
        }

        return  valorCorrigido;
    }

    private void setDiasAtraso(Contas conta) {
        if (conta.getDataPagamento() == null) {
            conta.setDiasAtraso(calculateDate(new Date(), conta.getDataVencimento()));
        } else if (isDiasAtraso(conta)) {
            conta.setDiasAtraso(calculateDate(conta.getDataPagamento(), conta.getDataVencimento()));
        } else {
            conta.setDiasAtraso(0);
        }
    }

    private boolean isDiasAtraso(Contas conta) {
        return conta.getDataPagamento().getTime() > conta.getDataVencimento().getTime();
    }

    private Integer calculateDate(Date newerDate, Date olderDate) {
        return (int)( (newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24) );
    }
}
