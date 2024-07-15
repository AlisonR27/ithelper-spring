package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipamento")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipamento")
    private Long idHardware;

    @ManyToOne
    @JoinColumn(name = "idchamado", nullable = false)
    private Ticket chamado;

    @Column(name = "patrimonio")
    private String patrimonio;

    @Column(name = "tipoequipamento")
    private String tipoEquipamento;

    @Column(name = "modeloequipamento")
    private String modeloEquipamento;

    @Column(name = "localequipamento")
    private String localEquipamento;

    // Getters and Setters

    public Long getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(Long idHardware) {
        this.idHardware = idHardware;
    }

    public Ticket getChamado() {
        return chamado;
    }

    public void setChamado(Ticket chamado) {
        this.chamado = chamado;
    }

    public String setPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(String modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public String getLocalEquipamento() {
        return localEquipamento;
    }

    public void setLocalEquipamento(String localEquipamento) {
        this.localEquipamento = localEquipamento;
    }
}
