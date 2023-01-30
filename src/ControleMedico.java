import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ControleMedico {
        ArrayList<Medico> medicoArrayList;

        public ControleMedico() {
            medicoArrayList = new ArrayList<>();
        }


        public ArrayList<Medico> getListMedico() {
            consultarArquivo();
            return medicoArrayList;
        }

        public void cadastrarMedico(Medico medico) {
            medicoArrayList.add(medico);
            salvarArquivo();
        }

        public Medico selecionarMedico(String id) {
            consultarArquivo();
            if(!medicoArrayList.isEmpty()) {
                for(int i = 0; i <= medicoArrayList.size(); i++) {
                    if(medicoArrayList.get(i).getId().equals(id)) {
                        return medicoArrayList.get(i);
                    }
                }
            }
            return null;
        }

        private void consultarArquivo() {
            Scanner input = null;

            try {
                try {
                    medicoArrayList.clear();
                    input = new Scanner(new File("medico.txt"));

                    while(input.hasNext()) {
                        Medico medico = new Medico();
                        medico.setId(input.next());
                        medico.setNome(input.next());
                        medico.setEspecialidade(input.next());
                        medicoArrayList.add(medico);
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

    public void excluirMedico(Medico medico) {
        medicoArrayList.remove(medico);
        salvarArquivo();
    }

        public void salvarArquivo() {

            try {
                try (Formatter output = new Formatter("medico.txt")) {
                    for (Medico medico : medicoArrayList) {
                        output.format("%s %s %s \n", medico.getId(), medico.getNome(), medico.getEspecialidade());
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
    }

