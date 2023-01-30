import java.util.Scanner;
public class interfacePrincipal {
    private final ControlePaciente controlePaciente;
    private final  ControleMedico controleMedico;
    private final FechoControle fechoControle;
    private final Scanner input;
    Paciente paciente;
    Medico medico;

    public interfacePrincipal(){
        input = new Scanner(System.in);
        controlePaciente = new ControlePaciente();
        controleMedico = new ControleMedico();
        fechoControle = new FechoControle();
        paciente = new Paciente();
        medico= new Medico();
    }
    public void menu(){
        int escolha;
        boolean luoopMenu = true;

        while (luoopMenu){
            System.out.println("1.)-REGISTRAR");
            System.out.println("2.)-RASTREIO");
            System.out.println("3.)-PAGAMENTO");
            System.out.println("4.)-ATENDIMENTO");
            System.out.println("5.)-CONSULTAR ATENDIDOS");
            System.out.println("6.)-LISTAR MEDICOS");
            System.out.println("7.)-FECHO");
            System.out.println("0.)-SAIR");
            System.out.print("DIGITE A OPÇÃO:");
            escolha = input.nextInt();


            switch(escolha){
                case 1:
                    System.out.print("**************************--REGISTRAR NOVO PACIENTE--**************************\n");
                    cadastrarPaciente();
                    menu();
                    break;
                case 2:
                    System.out.print("**************************--RASTREAMENTO DO PACIENTE--**************************\n");
                    rastrearPaciente();
                    menu();
                case 3:
                    System.out.print("**************************--PAGAMENTO DO PACIENTE--**************************\n");
                    fazerPagamento();
                    menu();
                    break;
                case 4:
                    atenderPaciente();
                    menu();
                    break;
                case 5:
                    System.out.println("\nlista de todos os pacientes atendidos até ao momento\n");
                    listasPacientes();
                    menu();
                    break;
                case 6:
                    listarMedico();
                    switch (menuSecundario()) {
                        case 1 -> {
                            System.out.print("**************************--REGISTRAR NOVO MEDICO--**************************\n");
                            cadastrarMedico();
                        }
                        case 2 -> {
                            System.out.print("**************************--ACTUALIZAR INFORMAÇÃO--**************************\n");
                            actualizarInformacao();
                        }
                        case 3 -> {
                            System.out.print("**************************--EXCLUIR MÊDICO--**************************\n");
                            excluirMedico();
                        }
                    }
                    break;

                case 7:
                    System.out.println("\n imprime o relatório com a quantidade de pacientes atendidos\n");
                    listasPacientesRelatorioFinal();
                    menu();
                    break;
                case 0:
                    System.out.println("SAINDO DA APLICAÇÃO...");
                    luoopMenu = false;
                    break;
                default:
                    System.out.print("\nOpcao incorreta!\n");
                    System.out.print("\n");
                    System.out.print("Cancelando Operação...\n");
                    menu();
                    break;
            }
        }
    }

    public int menuSecundario() {
        int opcao;
        while (true) {
            System.out.println("1.)-ADICIONAR MEDICO");
            System.out.println("2.)-ACTUALIZAR INFORMAÇÃO");
            System.out.println("3.)-ELIMINAR MÊDICO");
            System.out.print("0 - Voltar para o Menu Principal\n");
            System.out.print("\n");

            System.out.print("Digite a opção: ");
            opcao = input.nextInt();

            System.out.print("\n");

            if (opcao > 4) {
                System.out.print("\nOpção incorreta!\n");
                System.out.print("\n");
            } else {
                return opcao;
            }
        }
    }

    public void cadastrarPaciente(){
        String nomePaciente;
        String biPacinte;
        String moradaPaciente;
        String idadepaciente;
        String dataEntradaPaciente;

        System.out.print("NOME:");
        nomePaciente=input.next();

        System.out.print("B.I:");
        biPacinte=input.next();

        System.out.print("IDADE:");
        idadepaciente=input.next();

        System.out.print("MORADA:");
        moradaPaciente=input.next();

        System.out.print("DATA DE ENTRADA DD/MM/AA");
        dataEntradaPaciente=input.next();

        Paciente paciente;
        paciente = new Paciente();
        paciente.setNome(nomePaciente);
        paciente.setBi(biPacinte);
        paciente.setIdade(idadepaciente);
        paciente.setMorada(moradaPaciente);
        paciente.setDataEntrada(dataEntradaPaciente);
        controlePaciente.cadastrarPaciente(paciente);

        System.out.print("\nCadastrado com sucesso!\n");
    }

    public void rastrearPaciente(){
        String temperaturaPaciente, pesoPaciente, pressaoArterialPaciente;
        String estadoPaciente;

        System.out.print("TEMPERATURA:");
        temperaturaPaciente=input.next();

        System.out.print("PESO:");
        pesoPaciente=input.next();

        System.out.print("PRESSÃO ARTERIAL:");
        pressaoArterialPaciente=input.next();

        System.out.print("ESTADO DE SAUDE:");
        System.out.println("1.)-GRAVE");
        System.out.println("2.)-URGENTE");
        System.out.println("3.)-MODERADO");
        estadoPaciente = input.next();

        estadoPaciente = switch (estadoPaciente) {
            case "1" -> "GRAVE";
            case "2" -> "URGENTE";
            case "3" -> "MODERADO";
            default -> estadoPaciente;
        };

        Paciente paciente;
        paciente = new Paciente();
        paciente.setTemperatura(temperaturaPaciente);
        paciente.setPeso(pesoPaciente);
        paciente.setPressaoArterial(pressaoArterialPaciente);
        paciente.setEstado(estadoPaciente);
        controlePaciente.rastrearPaciente(paciente);

        System.out.print("\nEfectuado com sucesso!\n");
    }
    public void fazerPagamento(){
        String nomepaciente;

        try{
            System.out.print("Informe o nome do paciente, Para realizar o pagamento: ");
            nomepaciente = input.next();

            System.out.print("\n");

            Paciente paciente = controlePaciente.selecionarPaciente(nomepaciente);

            if(paciente != null){
                System.out.print("Realize a pagamento:");
                System.out.print("\n");

                String pagamentoPaciente;
                System.out.println("INFORMO ESTADO DE PAGAMENTO DO PACIENTE S/N");
                pagamentoPaciente = input.next();

                pagamentoPaciente = switch (pagamentoPaciente) {
                    case "S" -> "PAGO";
                    case "N" -> "NÃO-PAGO";
                    default -> pagamentoPaciente;
                };

                paciente.setPagamento(pagamentoPaciente);
                controlePaciente.fazerPagamento(paciente);

                System.out.print("\npagamento realizado com sucesso!\n");
            }
        } catch(Exception e){
            System.out.print(e.getMessage());
        }

        if(!controlePaciente.getListPaciente().isEmpty() && !controlePaciente.getListPagamentoPaciente().isEmpty() ){

            for(int i = 0; i < controlePaciente.getListPaciente().size(); i++){
                System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                System.out.println("\n");
            }

        } else {
            System.out.print("\nNão existe nenhum 'REGISTRO' disponivel até o momento!\n");
        }
    }
    public void atenderPaciente(){
        System.out.println("\n O ATENDIMENTO É FEITO POR ORDEM DE GRAVIDADE DO PACIENTE:\n");
        String tempoEsperaAtendimento;
        String nomeMedico;
        if(!controlePaciente.getListPaciente().isEmpty() && !controlePaciente.getListRastreioPaciente().isEmpty() && !controlePaciente.getListPagamentoPaciente().isEmpty() ){
                for(int i = 0; i < controlePaciente.getListPaciente().size(); i++){
                    if (controlePaciente.getListRastreioPaciente().get(i).getEstado().equals("GRAVE") && controlePaciente.getListPagamentoPaciente().get(i).getPagamento().equals("PAGO") ){
                        System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                        System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                        System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                        System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                        System.out.print("INFORMA O NOME DO MEDICO QUE ATENDEU O PACIENTE:");
                        nomeMedico = input.next();
                        medico.setNome(nomeMedico);
                        fechoControle.cadastrarfecho(medico);
                        System.out.print("INFORMA O TEMPO DE ESPERA DO PACIENTE HH:MM:");
                        tempoEsperaAtendimento = input.next();
                        paciente.setTempoAtendimento(tempoEsperaAtendimento);
                        controlePaciente.AtenderPaciente(paciente);
                        System.out.println("\n");

                    }else if (controlePaciente.getListRastreioPaciente().get(i).getEstado().equals("GRAVE") && controlePaciente.getListPagamentoPaciente().get(i).getPagamento().equals("NÃO PAGO") ){
                        System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                        System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                        System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                        System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                        System.out.print("INFORMA O NOME DO MEDICO QUE ATENDEU O PACIENTE:");
                        nomeMedico = input.next();
                        medico.setNome(nomeMedico);
                        fechoControle.cadastrarfecho(medico);
                        System.out.print("INFORMA O TEMPO DE ESPERA DO PACIENTE HH:MM:");
                        tempoEsperaAtendimento = input.next();
                        paciente.setTempoAtendimento(tempoEsperaAtendimento);
                        controlePaciente.AtenderPaciente(paciente);
                        System.out.println("\n");

                    }else if (controlePaciente.getListRastreioPaciente().get(i).getEstado().equals("URGENTE") && controlePaciente.getListPagamentoPaciente().get(i).getPagamento().equals("PAGO")){

                        System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                        System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                        System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                        System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                        System.out.print("INFORMA O NOME DO MEDICO QUE ATENDEU O PACIENTE:");
                        nomeMedico = input.next();
                        medico.setNome(nomeMedico);
                        fechoControle.cadastrarfecho(medico);
                        System.out.print("INFORMA O TEMPO DE ESPERA DO PACIENTE HH:MM:");
                        tempoEsperaAtendimento = input.next();
                        paciente.setTempoAtendimento(tempoEsperaAtendimento);
                        controlePaciente.AtenderPaciente(paciente);
                        System.out.println("\n");

                    }else if(controlePaciente.getListRastreioPaciente().get(i).getEstado().equals("URGENTE") && controlePaciente.getListPagamentoPaciente().get(i).getPagamento().equals("NÃO PAGO")) {

                        System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                        System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                        System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                        System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                        System.out.print("INFORMA O NOME DO MEDICO QUE ATENDEU O PACIENTE:");
                        nomeMedico = input.next();
                        medico.setNome(nomeMedico);
                        fechoControle.cadastrarfecho(medico);
                        System.out.print("INFORMA O TEMPO DE ESPERA DO PACIENTE HH:MM:");
                        tempoEsperaAtendimento = input.next();
                        paciente.setTempoAtendimento(tempoEsperaAtendimento);
                        controlePaciente.AtenderPaciente(paciente);
                        System.out.println("\n");

                    }else if (controlePaciente.getListRastreioPaciente().get(i).getEstado().equals("MODERADO") && controlePaciente.getListPagamentoPaciente().get(i).getPagamento().equals("PAGO")) {

                        System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                        System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                        System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                        System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                        System.out.print("INFORMA O NOME DO MEDICO QUE ATENDEU O PACIENTE:");
                        nomeMedico = input.next();
                        medico.setNome(nomeMedico);
                        fechoControle.cadastrarfecho(medico);
                        System.out.print("INFORMA O TEMPO DE ESPERA DO PACIENTE HH:MM:");
                        tempoEsperaAtendimento = input.next();
                        paciente.setTempoAtendimento(tempoEsperaAtendimento);
                        controlePaciente.AtenderPaciente(paciente);
                        System.out.println("\n");

                    }else if (controlePaciente.getListRastreioPaciente().get(i).getEstado().equals("MODERADO") && controlePaciente.getListPagamentoPaciente().get(i).getPagamento().equals("NÃO-PAGO")) {

                        System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                        System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                        System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                        System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                        System.out.print("INFORMA O NOME DO MEDICO QUE ATENDEU O PACIENTE:");
                        nomeMedico = input.next();
                        medico.setNome(nomeMedico);
                        fechoControle.cadastrarfecho(medico);
                        System.out.print("INFORMA O TEMPO DE ESPERA DO PACIENTE HH:MM:");
                        tempoEsperaAtendimento = input.next();
                        paciente.setTempoAtendimento(tempoEsperaAtendimento);
                        controlePaciente.AtenderPaciente(paciente);
                        System.out.println("\n");

                    }
                }
        }
    }
    public void listasPacientes(){
        System.out.println("PACIENTES ATENDIDOS ATÉ O MOMENTO\n");
        if(!controlePaciente.getListPaciente().isEmpty() && !controlePaciente.getListRastreioPaciente().isEmpty() && !controlePaciente.getListPagamentoPaciente().isEmpty() && !controlePaciente.getListPacienteAtendidos().isEmpty()){
            for(int i = 0; i < controlePaciente.getListPaciente().size(); i++){
                    System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                    System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                    System.out.println("Peso: " + controlePaciente.getListRastreioPaciente().get(i).getPeso());
                    System.out.println("Temperatura: " + controlePaciente.getListRastreioPaciente().get(i).getTemperatura());
                    System.out.println("Pressão Arterial: " + controlePaciente.getListRastreioPaciente().get(i).getPressaoArterial());
                    System.out.println("Estado: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                    System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                    System.out.println("\n");
                }
            }
    }

    public void listasPacientesRelatorioFinal(){
        System.out.println("PACIENTES ATENDIDOS ATÉ O MOMENTO\n");
        if(!controlePaciente.getListPaciente().isEmpty() && !controlePaciente.getListRastreioPaciente().isEmpty() && !controlePaciente.getListPagamentoPaciente().isEmpty() && !controlePaciente.getListPacienteAtendidos().isEmpty() && !fechoControle.getListFechoMedico().isEmpty()){
            for(int i = 0; i < controlePaciente.getListPaciente().size(); i++){
                System.out.println("Nome: " + controlePaciente.getListPaciente().get(i).getNome());
                System.out.println("Idade: " + controlePaciente.getListPaciente().get(i).getIdade());
                System.out.println("B.I: " + controlePaciente.getListPaciente().get(i).getBi());
                System.out.println("Data De Entrada: " + controlePaciente.getListPaciente().get(i).getDataEntrada());
                System.out.println("Peso: " + controlePaciente.getListRastreioPaciente().get(i).getPeso());
                System.out.println("Temperatura: " + controlePaciente.getListRastreioPaciente().get(i).getTemperatura());
                System.out.println("Pressão Arterial: " + controlePaciente.getListRastreioPaciente().get(i).getPressaoArterial());
                System.out.println("Estado do Paciente: " + controlePaciente.getListRastreioPaciente().get(i).getEstado());
                System.out.println("Estado do pagamento: " + controlePaciente.getListPagamentoPaciente().get(i).getPagamento());
                System.out.println("Tempo de atendimento: " + controlePaciente.getListPacienteAtendidos().get(i).getTempoAtendimento());
                System.out.println("Medico: " +fechoControle.getListFechoMedico().get(i).getNome());
                System.out.println("\n");
            }
        }
    }

    public void cadastrarMedico(){
        String idMedico;
        String nomeMedico;
        String especialidadeMedico;

        System.out.print("ID:");
        idMedico=input.next();

        System.out.print("NOME:");
        nomeMedico=input.next();

        System.out.print("ESPECIADADE:");
        especialidadeMedico=input.next();

        Medico medico;
        medico= new Medico();
        medico.setId(idMedico);
        medico.setNome(nomeMedico);
        medico.setEspecialidade(especialidadeMedico);
        controleMedico.cadastrarMedico(medico);

        System.out.print("\ncadastrado com sucesso!\n");
    }
    public void listarMedico(){
        if(!controleMedico.getListMedico().isEmpty()){
            System.out.println("MEDICOS EM SERVIÇOS \n");

            for(int i = 0; i < controleMedico.getListMedico().size(); i++){
                System.out.println("ID: "+ controleMedico.getListMedico().get(i).getId());
                System.out.println("Nome: " + controleMedico.getListMedico().get(i).getNome());
                System.out.println("Especialidade: " + controleMedico.getListMedico().get(i).getEspecialidade());
                System.out.println("\n");
            }
        } else {
            System.out.print("\nNão existe nenhum 'Medico' disponivel até o momento!\n");
        }
    }
    public void actualizarInformacao(){
        String id;
        String nomeMedico;
        String especialidade;
        try{
            System.out.print("Informe o Id do Medico, Para realizar a actualização: ");
            id = input.next();
            System.out.print("\n");

            Medico medico = controleMedico.selecionarMedico(id);

            if(medico != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.print("id: ");
                id = input.next();
                System.out.print("Nome: ");
                nomeMedico = input.next();
                System.out.print("Especialidade: ");
                especialidade = input.next();

                medico.setId(id);
                medico.setNome(nomeMedico);
                medico.setEspecialidade(especialidade);
                controleMedico.salvarArquivo();
                System.out.print("\nMedico alterado com sucesso!\n");
            }
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    public void excluirMedico(){
        String id;

        try{
            System.out.print("Para realizar a exclusão, informe o Id do Medico: ");
            id = input.next();

            System.out.print("\n");

            Medico medico = controleMedico.selecionarMedico(id);

            if(medico != null){
                controleMedico.excluirMedico(medico);
                System.out.println("Medico excluido com sucesso!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

