package br.com.frinfo.pontointeligente.model;

import br.com.frinfo.pontointeligente.enumerator.PerfilEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "valor_hora")
    private BigDecimal valorHora;

    @Column(name = "qtd_horas_trabalho_dia")
    private Float qtdHorasTrabalhoDia;

    @Column(name = "qtd_horas_almoco")
    private Float qtdHorasAlmoco;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private PerfilEnum perfil;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa empresa;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public Float getQtdHorasTrabalhoDia() {
        return qtdHorasTrabalhoDia;
    }

    public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
        this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
    }

    public Float getQtdHorasAlmoco() {
        return qtdHorasAlmoco;
    }

    public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
        this.qtdHorasAlmoco = qtdHorasAlmoco;
    }

    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @Transient
    public Optional<BigDecimal> getValorHoraOpt(){
        return Optional.ofNullable(valorHora);
    }
    @Transient
    public Optional<Float> getQtdHorasTrabalhoDiaOpt(){
        return Optional.ofNullable(qtdHorasTrabalhoDia);
    }
    @Transient
    public Optional<Float> getQtdHorasAlmocoOpt(){
        return Optional.ofNullable(qtdHorasAlmoco);
    }
    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
                + ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco="
                + qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao="
                + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", empresa=" + empresa + "]";
    }

}
