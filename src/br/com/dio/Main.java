package br.com.dio;

import br.com.dio.banco.Banco;
import br.com.dio.cliente.Cliente;
import br.com.dio.conta.Conta;
import br.com.dio.conta.customExceptions.ContaBloqueada;
import br.com.dio.conta.customExceptions.ContaDesativada;
import br.com.dio.conta.customExceptions.SaldoInsuficiente;
import br.com.dio.conta.historico.Transacao;
import br.com.dio.enums.ContaTipo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Marcelo", "12312312312");
        Cliente c2 = new Cliente("Maria", "12312312312312");
        Cliente c3 = new Cliente("Pedro", "12312312312");

        Banco banco = new Banco();
        Conta marcelo = banco.criarConta(c1, ContaTipo.CORENTE);
        Conta maria = banco.criarConta(c2, ContaTipo.POPUPANCA);
        Conta pedro = banco.criarConta(c3, ContaTipo.CORENTE);

        try {
            marcelo.depositar(10000d, marcelo);
            marcelo.transferir(1200d, maria);
            marcelo.transferir(1200d, pedro);

            maria.transferir(300, pedro);
            maria.sacar(maria.getSaldo());

            pedro.sacar(pedro.getSaldo());

        } catch (ContaBloqueada contaBloqueada) {
            contaBloqueada.printStackTrace();
        } catch (ContaDesativada contaInativa) {
            contaInativa.printStackTrace();
        } catch (SaldoInsuficiente saldoInsuficiente) {
            saldoInsuficiente.printStackTrace();
        }   finally {
            mostraHistorico(marcelo);
            mostraHistorico(maria);
            mostraHistorico(pedro);

            System.out.println(marcelo.getExtrato());
            System.out.println(maria.getExtrato());
            System.out.println(pedro.getExtrato());
        }

    }

    public static void mostraHistorico(List<Transacao> transacoes) {
        System.out.println("\tDATA \t OPERAÇÃO \t VALOR(R$) \t ORIGEM \t DESTINO");
        transacoes.forEach((t) -> System.out.println("\t" + t.getData() + "\t" + t.getTipoOperacao() + "\t" + "R$ " + t.getValor() + "\t" + t.getOrigem().getCliente().getNome() + " --> " + t.getDestino().getCliente().getNome()));
        System.out.println("\n");
    }

    public static void mostraHistorico(Conta conta) {
        System.out.println("\nNOME: " + conta.getCliente().getNome() + "\nCPF: " + conta.getCliente().getCpf());
        mostraHistorico(conta.getHistoricoTransacoes());
    }
}
