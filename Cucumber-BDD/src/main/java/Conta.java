import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Este código representa uma conta bancária.
 * Autor: Amanda Lopes Tenor
 */
public class Conta {
	/** 
	 * @param saldo Variável do saldo atual da conta.
	 */
    private int saldo;

    /**
     * Cria nova instância da classe Conta com o saldo inicial atribuído.
     * 
     * @param saldoInicial O saldo inicial da conta.
     */
    public Conta(int saldoInicial) {
        this.saldo = saldoInicial;
    }
    
    /**
     * Define o saldo inicial para um cliente especial.
     * 
     * @param saldoInicial O saldo inicial da conta para o cliente especial.
     * @throws Throwable Se ocorrer um erro durante a execução (implementação pendente).
     */
    @Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
    public void um_cliente_especial_com_saldo_atual_de_reais(int saldoInicial) throws Throwable {
        this.saldo = saldoInicial;
    }
	
    /**
     * Processa uma solicitação de saque na conta do cliente especial.
     * 
     * @param valorSaque O valor a ser sacado.
     * @throws RuntimeException Se o valor sacado ultrapassar o saldo atual.
     */
    @When("^for solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais(int valorSaque) throws RuntimeException {
        if (valorSaque > this.saldo) {
            throw new RuntimeException("Saldo insuficiente para o saque");
        }

        this.saldo -= valorSaque;
    }
	
    /**
     * Verifica se o saque foi realizado e atualiza o saldo da conta.
     * 
     * @param saldoAtt O novo saldo da conta após o saque.
     * @throws RuntimeException Se o saldo da conta não for atualizado corretamente após o saque.
     */
    @Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int saldoAtt) throws RuntimeException {
        if (this.saldo != saldoAtt) {
            throw new RuntimeException("O saldo da conta não foi atualizado corretamente após o saque");
        }
    }
	
    /**
     * Verifica outros resultados da operação.
     * 
     * @throws Throwable Se ocorrer um erro durante a execução(implementação pendente).
     */
    @Then("^verifica outros resultados$")
    public void verifica_outros_resultados() throws Throwable {
        // Resultados adicionais podem ser verificados aqui, caso necessário
    }
}