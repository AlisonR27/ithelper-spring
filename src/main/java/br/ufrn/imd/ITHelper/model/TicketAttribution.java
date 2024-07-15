package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Atribuicao_Chamado")
public class TicketAttribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtribuicao_Chamado")
    private Long idAtribuicaoChamado;

    @ManyToOne
    @JoinColumn(name = "idtecnico", nullable = false)
    private Technician tecnico;

    @ManyToOne
    @JoinColumn(name = "idchamado", nullable = false)
    private Ticket chamado;

    @Column(name = "datahoraatribuicao")
    private Timestamp dataHoraAtribuicao;

    // Getters and Setters

    public Long getIdAtribuicaoChamado() {
        return idAtribuicaoChamado;
    }

    public void setIdAtribuicaoChamado(Long idAtribuicaoChamado) {
        this.idAtribuicaoChamado = idAtribuicaoChamado;
    }

    public Technician getTecnico() {
        return tecnico;
    }

    public void setTecnico(Technician tecnico) {
        this.tecnico = tecnico;
    }

    public Ticket getChamado() {
        return chamado;
    }

    public void setChamado(Ticket chamado) {
        this.chamado = chamado;
    }

    public Timestamp getDataHoraAtribuicao() {
        return dataHoraAtribuicao;
    }

    public void setDataHoraAtribuicao(Timestamp dataHoraAtribuicao) {
        this.dataHoraAtribuicao = dataHoraAtribuicao;
    }
}
