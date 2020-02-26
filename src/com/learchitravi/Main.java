package com.learchitravi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static Inputs inputs = new Inputs();

    private static Set<Integer> idLibriInviati = new HashSet<>();

    public static void main(String[] args) {

        readFile(args[0]);

        writeOutput();

        return;

    }

    private static void readFile(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            if(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] row = data.split(" ");
                inputs.setTotaleLibri(Integer.parseInt(row[0]));
                inputs.setTotLibrerie(Integer.parseInt(row[1]));
                inputs.setTempoMassimo(Integer.parseInt(row[2]));
            }

            if(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] row = data.split(" ");
                int[] arr = new int[row.length];
                for(int i = 0; i < row.length; i ++) {
                    arr[i] = Integer.parseInt(row[i]);
                }
                inputs.setPunteggioLibri(arr);
            }

            List<Libreria> librerie = new ArrayList<>();
            int countLib = 0;
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] row = data.split(" ");
                Libreria l = new Libreria();
                l.setNumeroLibri(Integer.parseInt(row[0]));
                l.setSignUp(Integer.parseInt(row[1]));
                l.setNumeroLibriAlGiorno(Integer.parseInt(row[2]));

                if(myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    row = data.split(" ");
                    Integer[] arr = new Integer[row.length];
                    int sum = 0;
                    for(int i = 0; i < row.length; i ++) {
                        sum += inputs.getPunteggioLibri()[Integer.parseInt(row[i])];
                        arr[i] = Integer.parseInt(row[i]);
                    }
                    l.setScoreTotLibri(sum);

                    Arrays.sort(arr, new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            return - (inputs.getPunteggioLibri()[a] - inputs.getPunteggioLibri()[b]);
                        }
                    });
                    l.setIdLibri(arr);
                }

                l.setIdLibreria(countLib++);

                l.setScore(l.calcolaScore(inputs.getTotaleLibri()));

                librerie.add(l);
            }

            librerie.sort(Libreria::compareTo);

            inputs.setLibrerie(librerie);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeOutput() {

        List<Integer> idLibsChosen = new ArrayList<>();

        List<Libreria> libs = inputs.getLibrerie();

        int sumTempi = 0;
        int sumScore = 0;
        for(int i = 0; i < libs.size(); i++) {
            sumTempi += libs.get(i).getSignUp();
            if(sumTempi < inputs.getTempoMassimo()) {
                idLibsChosen.add(libs.get(i).getIdLibreria());

                int numeroDiLibriDaManadare = (inputs.getTempoMassimo() - sumTempi) * libs.get(i).getNumeroLibriAlGiorno();
                if(numeroDiLibriDaManadare > libs.get(i).getNumeroLibri()) {
                    numeroDiLibriDaManadare = libs.get(i).getNumeroLibri();
                }
                libs.get(i).setLibriDaMandare(numeroDiLibriDaManadare);

                int countLibriInviati = 0;

                for(int j = 0; j < libs.get(i).getIdLibri().length; j++) {
                    if(countLibriInviati < numeroDiLibriDaManadare) {
                        if(!idLibriInviati.contains(libs.get(i).getIdLibri()[j])) {
                            libs.get(i).getIdLibriDaMandare().add(libs.get(i).getIdLibri()[j]);
                            sumScore += inputs.getPunteggioLibri()[libs.get(i).getIdLibri()[j]];
                            idLibriInviati.add(libs.get(i).getIdLibri()[j]);
                            countLibriInviati++;
                        }
                    } else {
                        break;
                    }
                }

                if(countLibriInviati < Math.ceil(inputs.getTotaleLibri() * 0.0001f)) {
                    sumTempi -= libs.get(i).getSignUp();
                    idLibsChosen.remove(idLibsChosen.size()-1);
                }
            } else {
                break;
            }
        }



        System.out.println(idLibsChosen.size());

        for(int i = 0; i < idLibsChosen.size(); i++) {

            final int index = i;

            Libreria myLib = libs.stream()
                    .filter(lib -> idLibsChosen.get(index) == lib.getIdLibreria())
                    .findAny()
                    .orElse(null);

            System.out.println(myLib.getIdLibreria() + " " + myLib.getIdLibriDaMandare().size());
            String idLibri = "";
            for(int j = 0; j < myLib.getIdLibriDaMandare().size(); j++) {
                idLibri += myLib.getIdLibriDaMandare().get(j) + " ";
            }
            System.out.println(idLibri);
        }



    }
}
