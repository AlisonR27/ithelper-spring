package br.ufrn.imd.ITHelper.dto;



import br.ufrn.imd.ITHelper.config.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.sql.Timestamp;

public class TicketDTO {
    @JsonView({Views.Public.class})
    private Long idChamado;
    @JsonView({Views.Public.class})
    private String nomeUsuario;
    @JsonView({Views.Public.class})
    private String tituloChamado;
    @JsonView({Views.Public.class})
    private String descricaoChamado;
    @JsonView({Views.Public.class})
    private Timestamp dataHoraAbertura;
    @JsonView({Views.Public.class})
    private char prioridade;
    @JsonView({Views.Public.class})
    private char statusChamado;
    @JsonView({Views.Public.class})
    private Timestamp dataHoraFechamento;
    @JsonView({Views.Public.class})
    private String nomeDepartamento;


    public Long getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(Long idChamado) {
        this.idChamado = idChamado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTituloChamado() {
        return tituloChamado;
    }

    public void setTituloChamado(String tituloChamado) {
        this.tituloChamado = tituloChamado;
    }

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado(String descricaoChamado) {
        this.descricaoChamado = descricaoChamado;
    }

    public Timestamp getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Timestamp dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public char getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(char prioridade) {
        this.prioridade = prioridade;
    }

    public char getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(char statusChamado) {
        this.statusChamado = statusChamado;
    }

    public Timestamp getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Timestamp dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
}
