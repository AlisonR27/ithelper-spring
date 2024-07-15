package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Acao")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacao")
    private Long idAction;

    @Column(name = "descricaoacao", length = 200, nullable = false)
    private String descricaoAcao;

    @Column(name = "datahoraacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp dataHoraAcao;

    @ManyToOne
    @JoinColumn(name = "idatribuicao_chamado", nullable = false)
    private TicketAttribution atribuicaoChamado;

    // Getters and Setters


    public Long getIdAction() {
        return idAction;
    }

    public void setIdAction(Long idAction) {
        this.idAction = idAction;
    }

    public String getDescricaoAcao() {
        return descricaoAcao;
    }

    public void setDescricaoAcao(String descricaoAcao) {
        this.descricaoAcao = descricaoAcao;
    }

    public Timestamp getDataHoraAcao() {
        return dataHoraAcao;
    }

    public void setDataHoraAcao(Timestamp dataHoraAcao) {
        this.dataHoraAcao = dataHoraAcao;
    }

    public TicketAttribution getAtribuicaoChamado() {
        return atribuicaoChamado;
    }

    public void setAtribuicaoChamado(TicketAttribution atribuicaoChamado) {
        this.atribuicaoChamado = atribuicaoChamado;
    }
}
