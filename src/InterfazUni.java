import PaqGI1.Dispenser;
import PaqGI1.Medicine;
import PaqGI1.Pharmacy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUni  extends JFrame {
    private JRadioButton RB1;
    private JRadioButton RB2;
    private JRadioButton RB3;
    private JRadioButton RB4;
    private JTextField TXT1;
    private JTextArea TA1;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JTextField TF1;
    private JTextField TF2;
    private JTextField TF3;
    private JLabel JL1;
    private JLabel JL2;
    private JLabel JL3;
    private JPanel A;
    private ButtonGroup BGROUP1;

    private Pharmacy ph;


    public InterfazUni(Pharmacy ph) {
        this.ph = ph;
        Dispenser d = new Dispenser(15, 20);
        setTitle("Welcome");
        setContentPane(A);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


//2 cuadrado
        RB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <= 14; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[0].dispenser[i][j];
                        if (medicine != null) {
                            String word1 = medicine.getName();
                            TA1.append(word1 + "  ");

                        } else {
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }
        });
        RB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <= 14; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[1].dispenser[i][j];
                        if (medicine != null) {
                            String word1 = medicine.getName();
                            TA1.append(word1 + "  ");

                        } else {
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }
        });

        RB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <= 14; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[2].dispenser[i][j];
                        if (medicine != null) {

                            String word1 =medicine.getName();
                            TA1.append(word1 + "  ");

                        } else {
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }
        });


        RB4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <=14; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[3].dispenser[i][j];
                        if (medicine != null) {
                            String word1 = medicine.getName();
                            TA1.append(word1 + "  ");
                        }else{
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }

    });


/*
        public void actionPerformed(ActionEvent e) {
            TA1.setText("");
            for (int i = 0; i <=4; i++) {
                for (int j = 4; j >= 0; --j) {
                    Medicine medicine = ph.dispensers[3].dispenser[i][j];
                    if (medicine != null) {
                        String word1 = InterfazUni.this.ph.dispensers[0].dispenser[i][j].getName();

                        TA1.append(word1 + "           " + "\n");


                    }else{
                        TA1.append("Vacío\t");
                    }

                }
                TA1.append("\n");
            }
        }

 */
        //3cuadrado
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nameMedicine = TF1.getText();
                int amount = Integer.parseInt(TF3.getText());
                String nameCompany = TF2.getText();
                int medRest=0;



                boolean found = false;
                int column = -1;
                if (nameMedicine.equals("paracetamol")) {
                    column = 0;
                } else if (nameMedicine.equals("ibuprofeno")) {
                    column = 1;
                } else if (nameMedicine.equals("omeprazol")) {
                    column = 2;
                } else if (nameMedicine.equals("Toseína")) {
                    column = 3;
                } else if (nameMedicine.equals("Apiretal")) {
                    column = 4;
                }else if(nameMedicine.equals("diazepam")){
                    column=5;
                }else if(nameMedicine.equals("tylenol")){
                    column=6;
                }else if(nameMedicine.equals("amoxicilina")) {
                    column = 7;
                }else if(nameMedicine.equals("prozac")) {
                    column = 8;
                }else if(nameMedicine.equals("xanax")) {
                    column = 9;
                }else if(nameMedicine.equals("viagra")) {
                    column = 10;
                }else if(nameMedicine.equals("lipitor")) {
                    column = 11;
                }else if(nameMedicine.equals("zoloft")) {
                    column = 12;
                }else if(nameMedicine.equals("advil")) {
                    column = 13;
                }else if(nameMedicine.equals("zantac")) {
                    column = 14;
                }else if(nameMedicine.equals("nexium")) {
                    column = 15;
                }else if(nameMedicine.equals("prednisona")){
                    column=16;
                }else if(nameMedicine.equals("ventolin")) {
                    column = 17;
                }else if(nameMedicine.equals("ritalin")) {
                    column = 18;
                }else if(nameMedicine.equals("benadryl")) {
                    column = 19;
                }

                if (column != -1) {

                    // Iterar a través de los dispensadores
                    for (int i = 0; i < ph.dispensers.length; i++) {
                        // Verificar si hay suficientes medicamentos disponibles

                        if (amount > 0) {
                            // Suficientes medicamentos disponibles en este dispensador
                            if (amount <=15) {
                                // Quitar solo la cantidad requerida de medicamentos
                                for (int j = 0; j < ph.dispensers[i].dispenser.length && amount > 0; j++) {
                                    if (ph.dispensers[i].dispenser[j][column] != null) {
                                        ph.dispensers[i].dispenser[j][column] = null;
                                        amount--;
                                    }
                                }
                                found = true;
                                break;
                            }
                            else {

                                TA1.setText("No existen tantos medicamentos en los dispensadores,prueba a hacer refill");
                                for (int j = 0; j < ph.dispensers[i].dispenser.length && amount > 0; j++) {
                                    if (ph.dispensers[i].dispenser[j][column] != null) {
                                        ph.dispensers[i].dispenser[j][column] = null;
                                        amount--;
                                    }
                                }
                                found = true;
                                medRest=amount-15;
                                if(medRest<=15 && medRest>0) {
                                    // Quitar todos los medicamentos disponibles y seguir buscando en el siguiente dispensador
                                    for (int j = 0; j < ph.dispensers[i + 1].dispenser.length && medRest > 0; j++) {
                                        if (ph.dispensers[i].dispenser[j][column] != null) {
                                            ph.dispensers[i].dispenser[j][column] = null;
                                            medRest--;
                                            if (medRest == 0) {
                                                break;
                                            }
                                        }
                                    }
                                    }
                                        else if(medRest>15) {
                                            for (int j = 0; j < ph.dispensers[i + 1].dispenser.length && medRest > 0; j++) {
                                                if (ph.dispensers[i].dispenser[j][column] != null) {
                                                    ph.dispensers[i].dispenser[j][column] = null;
                                                    medRest--;
                                                    if (medRest == 0) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }


                                else if(medRest>15){

                                }
                            }
                        }
                        else TA1.setText("try again");
                    }
                }

                if (found) {
                    TA1.setText("Medicamento dispensado: " + nameMedicine);
                } else {
                    TA1.setText("El medicamento no está disponible en los dispensadores.");
                }
         }
});

        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                        TA1.setText( "take one of them every 8 hours");




            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                TA1.setText(TF3.getText() + " unit/units of " + TF1.getText() + " have been dispensed.");
            }
        });

        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manufactures = TF2.getText();
                String name = TF1.getText();
                int amount = Integer.parseInt(TF3.getText());
                // Rellenar un medicamento específico en los dispensadores
                InterfazUni.this.ph.refillOneMedicine(name, manufactures, amount);

                // Actualizar el estado de los botones de los dispensadores
                RB1.setEnabled(true);
                RB2.setEnabled(true);
                RB3.setEnabled(true);
                RB4.setEnabled(true);ph.dispensers[0].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[0].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[0].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[0].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[0].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[0].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[0].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[0].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[0].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[0].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[0].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[0].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[0].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[0].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[0].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[0].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[0].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[0].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[0].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[0].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[0].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[0].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[0].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[0].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[0].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[0].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[0].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[0].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[0].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[0].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[0].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[0].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[0].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[0].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[0].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[0].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[0].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[0].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[0].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[0].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

                ph.dispensers[0].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[0].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



                ph.dispensers[1].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[1].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[1].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[1].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[1].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[1].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[1].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[1].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[1].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[1].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[1].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[1].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[1].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[1].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[1].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[1].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[1].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[1].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[1].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[1].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[1].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[1].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[1].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[1].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[1].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[1].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[1].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[1].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[1].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[1].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[1].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[1].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[1].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[1].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[1].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[1].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[1].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[1].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[1].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[1].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

                ph.dispensers[2].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



                ph.dispensers[2].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[2].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[2].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[2].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[2].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[2].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[2].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[2].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[2].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[2].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[2].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[2].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[2].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[2].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[2].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[2].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[2].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[2].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[2].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[2].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[2].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[2].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[2].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[2].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[2].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[2].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[2].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[2].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[2].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[2].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[2].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[2].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[2].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[2].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[2].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[2].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[2].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[2].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[2].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[2].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[2].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

                ph.dispensers[3].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



                ph.dispensers[3].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[3].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[3].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[3].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[3].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
                ph.dispensers[3].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
                ph.dispensers[3].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[3].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[3].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[3].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[3].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
                ph.dispensers[3].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
                ph.dispensers[3].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[3].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[3].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[3].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[3].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[3].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[3].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
                ph.dispensers[3].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
                ph.dispensers[3].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
                ph.dispensers[3].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[3].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[3].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[3].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[3].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[3].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[3].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
                ph.dispensers[3].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
                ph.dispensers[3].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
                ph.dispensers[3].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
                ph.dispensers[3].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[3].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[3].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[3].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[3].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
                ph.dispensers[3].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
                ph.dispensers[3].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
                ph.dispensers[3].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
                ph.dispensers[3].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
                ph.dispensers[3].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

                ph.dispensers[1].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
                ph.dispensers[1].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);




                // Restaurar el texto original

                // Asignar los textos originales a los botones de los dispensadores
                /*


                            // Obtener el texto del medicamento en la posición (i, j) del dispensador d

                            // Asignar el texto del medicamento al botón correspondiente
                            switch (j) {
                                case 0:
                                    if (RB1.isSelected()) {


                                        TA1.setText(originalTexts);
                                    }
                                    break;

                                case 1:
                                    RB2.setText(originalTexts);
                                    break;
                                case 2:
                                    RB3.setText(originalTexts);
                                    break;
                                case 3:
                                    RB4.setText(originalTexts);
                                    break;
                                // Añadir más casos si hay más botones de dispensadores
                                default:
                                    break;
                            }
                        }
                    }
                }*/
                TA1.setText("Refill completado ");



            }
        }
        );


    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Dispenser[] dispensers = new Dispenser[4];

            for(int i=0;i<3;i++){
                dispensers[i]= new Dispenser();
            }


            Pharmacy ph = new Pharmacy(dispensers);

            new InterfazUni(ph).setVisible(true);

            ph.dispensers[0].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[0].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[0].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[0].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[0].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[0].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[0].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[0].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[0].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[0].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[0].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[0].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[0].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[0].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[0].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[0].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[0].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[0].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[0].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

            ph.dispensers[0].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



            ph.dispensers[1].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[1].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[1].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[1].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[1].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[1].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[1].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[1].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[1].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[1].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[1].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[1].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[1].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[1].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[1].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[1].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[1].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[1].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[1].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

            ph.dispensers[2].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



            ph.dispensers[2].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[2].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[2].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[2].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[2].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[2].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[2].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[2].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[2].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[2].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[2].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[2].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[2].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[2].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[2].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[2].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[2].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[2].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[2].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

            ph.dispensers[3].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



            ph.dispensers[3].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[5][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[6][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[7][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[8][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[9][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[10][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[11][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[12][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[13][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[14][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[3].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[5][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[3].dispenser[6][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[7][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[8][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[9][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[10][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[3].dispenser[11][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[12][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[13][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[14][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[3].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[3].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[5][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[3].dispenser[6][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[3].dispenser[7][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[8][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[9][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[10][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[3].dispenser[11][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[3].dispenser[12][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[13][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[14][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[3].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[3].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[3].dispenser[5][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[6][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[3].dispenser[7][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[8][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[3].dispenser[9][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[3].dispenser[10][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[11][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[3].dispenser[12][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[13][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[3].dispenser[14][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[3].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[5][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[6][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[7][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[8][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[9][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[10][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[11][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[12][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[13][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[14][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

            ph.dispensers[1].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[5][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[6][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[7][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[8][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[9][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[10][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[11][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[12][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[13][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[14][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);





















        });

    }
}
