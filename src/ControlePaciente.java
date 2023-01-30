import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ControlePaciente extends Medico{
    ArrayList<Paciente> pacienteArrayList;
    ArrayList<Paciente> RastreioPacienteArrayList;
    ArrayList<Paciente> PagamentoPacienteArrayList;
    ArrayList<Paciente> atendimentoPacienteArrayList;
    public ControlePaciente() {
        pacienteArrayList = new ArrayList<>();
        RastreioPacienteArrayList = new ArrayList<>();
        PagamentoPacienteArrayList = new ArrayList<>();
        atendimentoPacienteArrayList = new ArrayList<>();
    }

    // Metodos Pacientes

    public ArrayList<Paciente> getListPaciente() {
        consultarArquivo();
        return pacienteArrayList;
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacienteArrayList.add(paciente);
        salvarArquivo();
    }

    public Paciente selecionarPaciente(String nome) {
        consultarArquivo();
        if(!pacienteArrayList.isEmpty()) {
            for(int i = 0; i <= pacienteArrayList.size(); i++) {
                if(pacienteArrayList.get(i).getNome().equals(nome)) {
                    return pacienteArrayList.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                pacienteArrayList.clear();
                input = new Scanner(new File("Paciente.txt"));

                while(input.hasNext()) {
                    Paciente paciente = new Paciente();
                    paciente.setNome(input.next());
                    paciente.setBi(input.next());
                    paciente.setIdade(input.next());
                    paciente.setMorada(input.next());
                    paciente.setDataEntrada(input.next());
                    pacienteArrayList.add(paciente);
                }
            } finally {
                if(input != null) {
                    input.close();
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    public void salvarArquivo() {

        try {
            try (Formatter output = new Formatter("Paciente.txt")) {
                for (Paciente paciente : pacienteArrayList) {
                    output.format("%s %s %s %s %s\n", paciente.getNome(), paciente.getBi(), paciente.getIdade(), paciente.getMorada() , paciente.getDataEntrada());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    // Metodos Rastreios
    public void rastrearPaciente(Paciente paciente) {
        RastreioPacienteArrayList.add(paciente);
        salvarArquivoRastreio();
    }

    public ArrayList<Paciente> getListRastreioPaciente() {
        consultarArquivoRastreio();
        return RastreioPacienteArrayList;
    }


    private void consultarArquivoRastreio() {
        Scanner input = null;

        try {
            try {
                RastreioPacienteArrayList.clear();
                input = new Scanner(new File("Rastreio.txt"));

                while(input.hasNext()) {
                    Paciente paciente = new Paciente();
                    paciente.setPeso(input.next());
                    paciente.setTemperatura(input.next());
                    paciente.setPressaoArterial(input.next());
                    paciente.setEstado(input.next());
                    RastreioPacienteArrayList.add(paciente);
                }
            } finally {
                if(input != null) {
                    input.close();
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    public void salvarArquivoRastreio() {

        try {

            try (Formatter output = new Formatter("Rastreio.txt")) {
                for (Paciente paciente : RastreioPacienteArrayList) {
                    output.format("%s %s %s %s \n",paciente.getPeso(), paciente.getTemperatura(), paciente.getPressaoArterial(), paciente.getEstado());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    // Metodos Pamentos
    public void fazerPagamento(Paciente paciente){
        PagamentoPacienteArrayList.add(paciente);
        salvarArquivoPagamento();
    }

    public ArrayList<Paciente> getListPagamentoPaciente() {
        consultarArquivoPagamento();
        return PagamentoPacienteArrayList;
    }

    private void consultarArquivoPagamento() {
        Scanner input = null;

        try {
            try {
                PagamentoPacienteArrayList.clear();
                input = new Scanner(new File("Pagamento.txt"));

                while(input.hasNext()) {
                    Paciente paciente = new Paciente();
                    paciente.setPagamento(input.next());
                    PagamentoPacienteArrayList.add(paciente);
                }
            } finally {
                if(input != null) {
                    input.close();
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    public void salvarArquivoPagamento() {

        try {
            try (Formatter output = new Formatter("Pagamento.txt")) {
                for (Paciente paciente : PagamentoPacienteArrayList) {
                    output.format("%s \n", paciente.getPagamento());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    // Metodos Atendimentos Pacientes
    public ArrayList<Paciente> getListPacienteAtendidos() {
        consultarArquivoAtendimento();
        return atendimentoPacienteArrayList;
    }

    public void AtenderPaciente(Paciente paciente) {
        atendimentoPacienteArrayList.add(paciente);
        salvarArquivoAtendimento();
    }

    public Paciente selecionarAtendimentoPaciente(String tempoAtendimentoPaciente) {
        consultarArquivoAtendimento();
        if(!atendimentoPacienteArrayList.isEmpty()) {
            for(int i = 0; i <= atendimentoPacienteArrayList.size(); i++) {
                if(atendimentoPacienteArrayList.get(i).getTempoAtendimento().equals(tempoAtendimentoPaciente)) {
                    return atendimentoPacienteArrayList.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivoAtendimento() {
        Scanner input = null;

        try {
            try {
                atendimentoPacienteArrayList.clear();
                input = new Scanner(new File("Tem.txt"));

                while(input.hasNext()) {
                    Paciente paciente = new Paciente();
                    paciente.setTempoAtendimento(input.next());
                    atendimentoPacienteArrayList.add(paciente);
                }
            } finally {
                if(input != null) {
                    input.close();
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    public void salvarArquivoAtendimento() {

        try {
            try (Formatter output = new Formatter("Atendimento.txt")) {
                for (Paciente paciente : atendimentoPacienteArrayList) {
                    output.format("%s\n", paciente.getTempoAtendimento());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
