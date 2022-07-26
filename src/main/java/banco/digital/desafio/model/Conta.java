package banco.digital.desafio.model;


import javax.persistence.*;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Conta_id")
    private Long id;
    private int agencia;
    private int numero;
    private double saldo;
    private double valor;

    private String conta;
    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;


    Conta(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

   
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
