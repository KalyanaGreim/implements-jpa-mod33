package org.kaly.domain;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "TB_CARRO")
    public class Carro {

        @Id
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="carro_seq")
        @SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
        private Long id;

        @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
        private String codigo;

        @Column(name = "NOME", length = 50, nullable = false)
        private String nome;

        @Column(name = "DESCRICAO", length = 100, nullable = false)
        private String descricao;

        @ManyToOne
        @JoinColumn(name = "marca_id")
        private Marca marca;

        @ManyToMany
        @JoinColumn(name = "acessorio_id")
        private List<Acessorio> acessorios;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Marca getMarca() {
            return marca;
        }

        public void setMarca(Marca marca) {
            this.marca = marca;
        }

        public List<Acessorio> getAcessorios() {
            return acessorios;
        }

        public void setAcessorios(List<Acessorio> acessorios) {
            this.acessorios = acessorios;
        }
    }

