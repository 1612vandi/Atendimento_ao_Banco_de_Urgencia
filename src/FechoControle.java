import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FechoControle {

        ArrayList<Medico> fechoMedicoArrayList;

        public FechoControle() {
            fechoMedicoArrayList = new ArrayList<>();
        }

        public ArrayList<Medico> getListFechoMedico() {
            consultarArquivoFecho();
            return fechoMedicoArrayList;
        }

        public void cadastrarfecho(Medico medico) {
            fechoMedicoArrayList.add(medico);
            salvarArquivoFecho();
        }
        private void consultarArquivoFecho() {
            Scanner input = null;

            try {
                try {
                    fechoMedicoArrayList.clear();
                    input = new Scanner(new File("Atendimento.txt"));

                    while(input.hasNext()) {
                        Medico medico = new Medico();
                        medico.setNome(input.next());
                        fechoMedicoArrayList.add(medico);
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
        public void salvarArquivoFecho() {
            try {
                try (Formatter output = new Formatter("Atendimento.txt")) {
                    for (Medico medico : fechoMedicoArrayList) {
                        output.format("%s\n",medico.getNome());
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
 }


