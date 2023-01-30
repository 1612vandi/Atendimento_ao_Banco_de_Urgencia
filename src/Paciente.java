public class Paciente {
    // VARIAVEIS PARA ARMAZENAR OS DADOS DE REGISTRO DOS PACIENTES
    private String nome, bi, morada;
    private String idade;
    private String dataEntrada;

    // VARIAVEIS PARA ARMAZENAR OS RASTREIOS DOS PACIENTES
    private String temperatura, peso, pressaoArterial;
    private String estado;

    // VARIAVEl PARA ARMAZENAR OS PAGAMENTOS DOS PACIENTES
    private String pagamento;

    // VARIAVEIS PARA ARMAZENAR O TEMPO DE ESPERA DOS PACIENTES AO SEREM ATENDIDOS
    private String tempoAtendimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoAtendimento(String tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }
}

