package com.StudentRegister;

import java.util.regex.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Menu {


    public static void MenuOPT() {
        System.out.println("-----------------------------------------------------");
        System.out.println("|        Welcome to Java Student Register           |");
        System.out.println("-----------------------------------------------------");
        System.out.println("|\t 1.Search by NAME");
        System.out.println("|\t 2.Search by Student ID");
        System.out.println("|\t 3.Search by University");
        System.out.println("|");
        System.out.println("|----------------------------------------------------");
        System.out.println("|");
        System.out.println("|\t 4.NEW RECORD");
        System.out.println("|\t 5.NEW UNIVERSITY-[ADMIN]");
        System.out.println("|\t 6.See Messages-[ADMIN]");
        System.out.println("|");
        System.out.println("|----------------------------------------------------");
        System.out.println("|");
        System.out.println("|\t 7.The list of ALL STUDENTS");
        System.out.println("|\t 8.The list of ALL STUDENTS (With ID)-[ADMIN]");
        System.out.println("|====================================================");
        System.out.println("|");
        System.out.println("|\t 9.Send us a message");
        System.out.println("|");
        System.out.println("|-----------------------=====------------------------");
        System.out.println("|                     10.EXIT                       |");
        System.out.println("-----------------------------------------------------");

    }

    public static void Abbrev_List() {
        File ABR_file = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ABR_List.txt");
        try {
            Scanner scanABR = new Scanner(ABR_file);
            while (scanABR.hasNextLine()) {
                String line = scanABR.nextLine();
                if (line != null) {
                    System.out.println(line);
                }

            }

        } catch (Exception exFN) {
            exFN.printStackTrace();
        }
    }


    public static void Read_Messages() {
        File M_file = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\UserMessages.txt");
        try {
            Scanner scanM = new Scanner(M_file);
            while (scanM.hasNextLine()) {
                String line = scanM.nextLine();
                if (line != null) {
                    System.out.println(line);


                }
            }
        } catch (Exception exFN) {
            exFN.printStackTrace();
        }
    }


    public static void StudentsList_List() {
        File STD_file = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
        try {
            Scanner scanSTD = new Scanner(STD_file);
            while (scanSTD.hasNextLine()) {
                String lineSTD = scanSTD.nextLine();
                if (lineSTD != null) {
                    System.out.println(lineSTD);


                }


            }


        } catch (Exception ex_ABR) {
            ex_ABR.printStackTrace();
        }
    }

    public static void promptENTER() {
        Scanner scanKEY = new Scanner(System.in);
        scanKEY.nextLine();
    }

    public static void RunMenu() {

        int choice;
        Scanner K_Input = new Scanner(System.in);
        MenuOPT();
        System.out.println("Please Chose a Category (1-10): ");
        choice = K_Input.nextInt();

        switch (choice) {
            case 1:
                // SEARCH BY STUDENT's NAME
                System.out.println("Example: ");
                System.out.println("----------------------");
                System.out.println("| 'First NAME: Andrei |");
                System.out.println("| 'Last NAME: Popescu'|");
                System.out.println("----------------------");
                System.out.println("ENTER THE NAME YOU WANT TO SEARCH ACORDING TO THE EXAMPLE ABOVE");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Enter the FIRST name: ");
                Scanner f_name = new Scanner(System.in);
                String f_name_of_std = f_name.next();

                while (!f_name_of_std.matches("[a-zA-Z]+")) {
                    System.out.println("ERROR: Please enter a valid last name.");
                    System.out.println("Try again: ");
                    System.out.println("Enter the FIRST NAME again: ");
                    f_name_of_std = f_name.next();

                }
                System.out.println("Enter the LAST name:");
                Scanner l_name = new Scanner(System.in);
                String l_name_of_std = l_name.next();


                while (!l_name_of_std.matches("[a-zA-Z]+")) {
                    System.out.println("ERROR: Please enter a valid last name.");
                    System.out.println("Try again: ");
                    System.out.println("Enter the LAST NAME again: ");
                    l_name_of_std = l_name.next();
                }


                File file = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
                try {
                    Scanner scan = new Scanner(file);
                    int match = 0;
                    int count = 0;
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        if (line.contains(f_name_of_std) && line.contains(l_name_of_std)) {

                            match = 1;
                            count += 1;

                        }


                    }
                    if (count != 0) {
                        System.out.println(f_name_of_std + " " + l_name_of_std + " is registered in our records.");
                        System.out.println("We found " + count + " records that match with your search.");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Privacy is important to us.At this section, we can't tell you more.");
                        System.out.println("| For more information, you need to acces another section of this program. | \n\n");

                    }
                    if (match != 1) {
                        System.out.println("The name you entered (" + f_name_of_std + " " + l_name_of_std + ") is not registered in our database.Please retry if you think this is and ERROR.");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("TIP: Check if you enter the name with first capital letter.");
                        System.out.println("---------------------------------------------------------------------\n\n\n");
                        break;
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                //SEARCH BY STUDENT ID
                System.out.println("Enter the ID of your student: ");
                Scanner ID_s = new Scanner(System.in);
                String in_id = ID_s.next();
                while (!in_id.matches("[0-9]+")) {
                    System.out.println("ERROR:Please enter a valid student ID.");
                    System.out.println("Enter a student ID again: ");
                    in_id = ID_s.next();
                }

                try {
                    File f = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
                    BufferedReader freader = new BufferedReader(new FileReader(f));
                    String s;
                    int aux = 0;
                    while ((s = freader.readLine()) != null) {
                        String[] st = s.split(" ");
                        String F_Name = st[0];
                        String L_Name = st[1];
                        String ID_S = st[2];
                        String UNIV_S = st[3];

                        if (ID_S.equals(in_id)) {

                            aux = 1;
                            System.out.println("ID REGISTERED");
                            System.out.println("The Full Name of the student registered with ID=" + in_id + " is:");
                            System.out.println(F_Name + " " + L_Name);
                            System.out.println("Student's University: " + UNIV_S);
                            System.out.println("------------------------------------------------------------------\n\n\n");


                        }

                        if (aux == 1)
                            break;


                    }
                    if (aux == 0)
                        System.out.println("No record has been found.\n\n\n");


                } catch (ArrayIndexOutOfBoundsException | FileNotFoundException aob1) {
                    aob1.printStackTrace();
                } catch (IOException iox1) {
                    System.out.println("Error");
                }
                break;

            case 3:
                //SEARCH BY UNIVERSITY's ABBREVIATION
                System.out.println("---------------------------------------");
                System.out.println("Enter the abbreviation of your student's University. ");
                System.out.println("Consider the LIST of abbreviations below !");
                System.out.println("----------------------------------------");
                System.out.println("Show List of abbreviations ? (Y/N)");
                Scanner opt = new Scanner(System.in);
                int aux_ch = 0;
                while (aux_ch == 0) {
                    char opt_ch = opt.next().charAt(0);
                    if (opt_ch == 'Y' || opt_ch == 'y') {
                        Abbrev_List();
                        System.out.println("Enter one abbreviation: ");
                        aux_ch = 1;
                    }
                    if (opt_ch == 'N' || opt_ch == 'n') {
                        System.out.println("If you know the abbreviation, type it now: ");
                        aux_ch = 1;
                    }
                    while (aux_ch == 0) {
                        System.out.println("You entered an wrong character.Please try \"Y\" for \"YES\" and \"N\" for \"NO\".");
                        break;
                    }
                }

                Scanner ID_s2 = new Scanner(System.in);
                String in_univ = ID_s2.next();
                while (!in_univ.matches("[a-zA-Z]+")) {
                    System.out.println("ERROR:Please enter a VALID abbreviation.");
                    System.out.println("Enter the abbreviation again: ");
                    in_univ = ID_s2.next();
                }

                try {
                    File f2 = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
                    BufferedReader freader2 = new BufferedReader(new FileReader(f2));
                    String s_u;
                    int auxil = 0;
                    int count_u = 0;
                    while ((s_u = freader2.readLine()) != null) {
                        String[] st2 = s_u.split(" ");
                        String F_Name2 = st2[0];
                        String L_Name2 = st2[1];
                        String UNIV_S2 = st2[3];

                        if (UNIV_S2.equals(in_univ)) {
                            auxil = 1;
                            count_u += 1;
                            System.out.println("We found a record !");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("The Full Name of the student registered is:" + F_Name2 + " " + L_Name2);
                            System.out.println("The ID of the student is CONFIDENTIAL.");
                            System.out.println("Student's University: " + UNIV_S2);
                            System.out.println("---------------------------------------------------------------------\n\n");
                        }


                    }
                    if (count_u != 0) {
                        System.out.println("We currently have " + count_u + " students registerd at " + in_univ + ".\n");
                        System.out.println("All the records were listed above.\n\n");
                    }
                    if (auxil == 0)
                        System.out.println("We currently have no students registered at the University you entered.(" + in_univ + ")");


                } catch (ArrayIndexOutOfBoundsException ex2_2) {
                    System.out.println("\n");
                } catch (Exception exc_2) {
                    exc_2.printStackTrace();

                }
                break;
            case 4:
                //ENTER NEW RECORD INTO "ListaStudenti.txt"
                Scanner First_Name = new Scanner(System.in);
                System.out.println("Enter the FIRST NAME: ");
                String F_Name = First_Name.next();

                ///CHECK IF THE INPUT IS CORRECT (ONLY LETTERS)
                while (!F_Name.matches("[a-zA-z]+")) {
                    System.out.println("ERROR: Please enter a valid NAME.");
                    System.out.println("Enter the FIRST NAME again: ");
                    F_Name = First_Name.next();
                }

                Scanner Last_Name = new Scanner(System.in);
                System.out.println("Enter the LAST NAME: ");
                String L_Name = Last_Name.next();

                ///CHECK IF THE INPUT IS CORRECT (ONLY LETTERS)
                while (!L_Name.matches("[a-zA-z]+")) {
                    System.out.println("ERROR: Please enter a valid NAME.");
                    System.out.println("Enter the FIRST NAME again: ");
                    L_Name = Last_Name.next();
                }

                System.out.println("List of current abbreviations: ");
                System.out.println("--------------------------------");
                Abbrev_List();
                System.out.println("---------------------------------");
                Scanner UNIV = new Scanner(System.in);
                System.out.println("Enter student's University (Abbreviation): ");
                String UNIV_Name = UNIV.next();

                ///CHECK IF THE INPUT IS OK
                while (!UNIV_Name.matches("[a-zA-Z]+")) {
                    System.out.println("ERROR:Invalid abbreviation.Please try again.");
                    System.out.println("Enter student's University (Abbreviation) again:");
                    UNIV_Name = UNIV.next();
                }

                try {
                    File AE_check = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
                    BufferedReader ae_ch = new BufferedReader(new FileReader(AE_check));
                    String s_u;
                    int aux_EXIT = 1;
                    while ((s_u = ae_ch.readLine()) != null) {
                        String[] st_ch_2 = s_u.split(" ");
                        String F_Name3 = st_ch_2[0];
                        String L_Name3 = st_ch_2[1];
                        String ID_S3 = st_ch_2[2];
                        String UNIV_S3 = st_ch_2[3];
                        if (F_Name3.contains(F_Name) && L_Name3.contains(L_Name) && UNIV_S3.contains(UNIV_Name)) {
                            System.out.println("We found a match for the data you entered.We need the student's ID: ");
                            System.out.println("INFO: If you don't have the ID, it means that you are not registered.In this case, please type : \"0\". ");
                            Scanner input_mID = new Scanner(System.in);
                            String i_manualID = input_mID.next();
                            while (!i_manualID.matches("[0-9]+")) {
                                System.out.println("ERROR: Please enter a valid number.");
                                System.out.println("Try again: ");
                                System.out.println("Enter the sudent's ID: ");
                                i_manualID = input_mID.next();
                            }
                            if (ID_S3.equals(i_manualID)) {
                                System.out.println("Student already registered.");
                                aux_EXIT = 0;
                                break;

                            }
                            break;
                        }
                    }

                    //RANDOM ID FOR EVERY NEW RECORD && Check if the generated number has already been generated.
                    Random rand_ID_NO = new Random();
                    int F_ID = rand_ID_NO.nextInt(1000);
                    File AE_check2 = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
                    BufferedReader ae_ch2 = new BufferedReader(new FileReader(AE_check2));
                    String s_u2;
                    String aux_EXIT2 = String.valueOf(F_ID);
                    while ((s_u2 = ae_ch2.readLine()) != null) {
                        String[] st_ch_3 = s_u2.split(" ");
                        String ID_S4 = st_ch_3[2];

                        while (ID_S4.contains(aux_EXIT2)) {
                            F_ID = rand_ID_NO.nextInt(1000);
                        }
                    }


                    File ABR_check = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ABR_List.txt");
                    BufferedReader univ2 = new BufferedReader(new FileReader(ABR_check));
                    String a_u;
                    int aux_ABR = 0;
                    while ((a_u = univ2.readLine()) != null) {
                        String[] ab1 = a_u.split(" ");
                        String UNIV_ABR = ab1[0];
                        if (UNIV_ABR.equals(UNIV_Name)) {
                            aux_ABR = 1;
                        }
                    }
                    FileWriter RWriter = new FileWriter("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt", true);
                    if (aux_ABR == 0) {
                        System.out.println("ERROR: No such University is available.");
                        break;
                    } else {
                        if (aux_EXIT == 1) {
                            RWriter.append("\n");
                            RWriter.write(F_Name + " " + L_Name + " " + F_ID + " " + UNIV_Name);
                            RWriter.close();
                            System.out.println("Student RECORD entered successfully!");
                            System.out.println("Please write down this id: " + F_ID + " or remember it.\n");
                            System.out.println("Warning: PLEASE DON'T SHARE YOUR ID WITH ANYONE.YOUR ID IS UNIQUE AND CONFIDENTIAL.\n");
                            System.out.println("-----------------------------------------------------\n\n");
                        }
                    }

                } catch (IOException exR) {
                    System.out.println("An error occured");
                    exR.printStackTrace();
                } catch (Exception exR2) {
                    exR2.printStackTrace();
                }


                break;

            case 5:

                Scanner authen = new Scanner(System.in);
                System.out.println("Enter username: ");
                String u_name = authen.nextLine();
                System.out.println("Enter your password: ");
                String passWord = authen.nextLine();


                try {
                    File CRED_check = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ADMIN.txt");
                    BufferedReader cred_ch = new BufferedReader(new FileReader(CRED_check));
                    String c_b;
                    int aux_cred = 0;

                    while ((c_b = cred_ch.readLine()) != null) {
                        String[] ab_ch_2 = c_b.split(";");
                        String usserN = ab_ch_2[0];
                        String passW = ab_ch_2[1];
                        if (u_name.equals(usserN) && passWord.equals(passW)) {
                            aux_cred = 1;

                        } else {
                            System.out.println("Acces Denied!");
                            System.out.println("ERROR: Wrong Username or password.");
                            break;
                        }
                    }

                    if (aux_cred == 1) {
                        System.out.println("----====The list of already registered Universities====----\n");
                        Abbrev_List();
                        System.out.println("---------------------------=====-----------------------------");
                        System.out.println("\nPlease press \"[ENTER]\" to continue");
                        promptENTER();
                        System.out.println("---------------------------=====-----------------------------\n");
                        System.out.println("Follow the instructions below in order to add a new University.\n");
                        System.out.println("---------------------------=====-----------------------------");
                        Scanner UnivName = new Scanner(System.in);
                        System.out.println("Enter FULL University NAME: ");
                        String UN = UnivName.nextLine();
                        while (!UN.matches("[a-zA-Z]+") || UN.matches("[0-9]+")) {
                            System.out.println("ERROR: Please enter a VALID input.If you see this error, you entered an unwanted character.Retry");
                            System.out.println("Enter FULL University NAME: ");
                            UN = UnivName.nextLine();
                        }


                        Scanner AbrName = new Scanner(System.in);
                        System.out.println("Enter the abbreviation for the University you entered previously (UPPER CASE ONLY): ");
                        String ABR_N = AbrName.next();

                        while (!ABR_N.matches("[A-Z]+")) {

                            System.out.println("ERROR: Please enter a VALID input.If you see this error, you entered an unwanted character.Retry.");
                            System.out.println("Enter an abbreviation for the University NAME you entered previously: ");
                            ABR_N = AbrName.next();
                        }

                        File ABR_check = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ABR_List.txt");
                        BufferedReader ab_ch = new BufferedReader(new FileReader(ABR_check));
                        String a_b;
                        int aux_ver = 0;
                        while ((a_b = ab_ch.readLine()) != null) {

                            String[] ab_ch_2 = a_b.split(" ");
                            String ABREVIATION_E = ab_ch_2[0];

                            if (ABREVIATION_E.equals(ABR_N)) {
                                System.out.println("ERROR:University already exists.Please retry.");
                                aux_ver = 1;
                                break;
                            }
                        }
                        if (aux_ver == 0) {


                            FileWriter PWriter = new FileWriter("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ABR_List.txt", true);
                            PWriter.append("\n");
                            PWriter.write(ABR_N + " = " + UN);
                            PWriter.close();
                            System.out.println("University RECORD entered successfully!");
                        }


                    }
                } catch (Exception ex_02) {
                    System.out.println("Error1");
                }

                break;
            case 6:
                Scanner authen_2 = new Scanner(System.in);
                System.out.println("Enter username: ");
                String u_name2 = authen_2.nextLine();
                System.out.println("Enter your password: ");
                String passWord2 = authen_2.nextLine();
                try {
                    File CRED_check = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ADMIN.txt");
                    BufferedReader cred_ch = new BufferedReader(new FileReader(CRED_check));
                    String c_b;


                    while ((c_b = cred_ch.readLine()) != null) {
                        String[] ab_ch_2 = c_b.split(";");
                        String usserN = ab_ch_2[0];
                        String passW = ab_ch_2[1];
                        if (!u_name2.equals(usserN) && !passWord2.equals(passW)) {
                            System.out.println("Acces Denied!");
                            System.out.println("ERROR: Wrong Username or password.");
                            break;

                        } else {
                            Read_Messages();
                            System.out.println("\nINFO: If you don't see a message above this message, it means that there are no messages at the moment!\n");
                        }


                    }
                } catch (IOException ex02) {
                    ex02.printStackTrace();
                }
                break;

            case 7:
                System.out.println("--------------------------");
                System.out.println("You are about to see the full list of our recorded students.");
                System.out.println("Please confirm you choice: Press \"[ENTER]\" on your keyboard.");
                promptENTER();
                try {
                    File f_c = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ListaStudenti.txt");
                    BufferedReader freader = new BufferedReader(new FileReader(f_c));
                    String s_c;
                    int aux = 0;
                    while ((s_c = freader.readLine()) != null) {
                        String[] st_c = s_c.split(" ");
                        String F2_Name = st_c[0];
                        String L2_Name = st_c[1];
                        String UNIV2_S = st_c[3];
                        System.out.println(F2_Name + " " + L2_Name + " " + "registered at " + UNIV2_S + ";");
                    }
                    System.out.println("--------------------------\n");
                    System.out.println("NOTE:If you want to see the ID of each student listed above, please chose option 8.");
                    System.out.println("Keep in mind that, for option 8 you will need the username and password of an administrator!\n");
                    System.out.println("--------------------------\n\n");
                } catch (FileNotFoundException fnf2) {
                    fnf2.printStackTrace();
                } catch (IOException iox2) {
                    iox2.printStackTrace();
                }
                break;
            case 8:
                ///STUDENTS LIST INCLUDING ID
                Scanner authen_3 = new Scanner(System.in);
                System.out.println("Enter username: ");
                String u_name3 = authen_3.nextLine();
                System.out.println("Enter your password: ");
                String passWord3 = authen_3.nextLine();
                try {
                    File CRED_check = new File("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\ADMIN.txt");
                    BufferedReader cred_ch = new BufferedReader(new FileReader(CRED_check));
                    String c_b;


                    while ((c_b = cred_ch.readLine()) != null) {
                        String[] ab_ch_3 = c_b.split(";");
                        String usserN3 = ab_ch_3[0];
                        String passW3 = ab_ch_3[1];
                        if (!u_name3.equals(usserN3) && !passWord3.equals(passW3)) {
                            System.out.println("\n\nAcces Denied!");
                            System.out.println("ERROR: Wrong Username or password.");
                            break;

                        } else {
                            System.out.println("\n\n");
                            StudentsList_List();
                            System.out.println("\nINFO: If you don't see a list above this line, it means that there are no students registered at the moment!\n");
                        }


                    }
                } catch (IOException ex02) {
                    ex02.printStackTrace();
                }
                break;

            case 9:
                ///SEND A MESSAGE
                System.out.println("Welcome!");
                System.out.println("---------");
                System.out.println("If you want to send us a message, please complete the following formular");
                System.out.println("Make sure that your data is correct, so that we can give you a fast response");
                System.out.println("------------------------------------------------------------------------------" + "\n");
                System.out.println("Press \"[ENTER]\" to start");
                promptENTER();

                System.out.println("First Name: ");
                Scanner n_message = new Scanner(System.in);
                String F_n_message = n_message.next();
                while (!F_n_message.matches("[a-zA-z]+")) {
                    System.out.println("ERROR: Please enter a valid NAME.");
                    System.out.println("Enter the FIRST NAME again: ");
                    F_n_message = n_message.next();
                }

                System.out.println("Last Name: ");
                Scanner m_message = new Scanner(System.in);
                String L_n_message = m_message.next();
                while (!L_n_message.matches("[a-zA-z]+")) {
                    System.out.println("ERROR: Please enter a valid NAME.");
                    System.out.println("Enter the LAST NAME again: ");
                    L_n_message = m_message.next();
                }


                System.out.println("Phone Number");
                System.out.println("---------------");
                System.out.println("Example: 0755998787");
                Scanner ph_message = new Scanner(System.in);
                String p_message = ph_message.next();

                //PHONE NUMBER CHECK
                Pattern p = Pattern.compile("^\\d{10}$");
                Matcher ma = p.matcher(p_message);
                while (!p.matcher(p_message).matches()) {
                    System.out.println("ERROR:Invalid phone number!");
                    System.out.println("Please enter the phone number again: ");
                    p_message = ph_message.next();

                }

                System.out.println("Email: ");
                Scanner em_message = new Scanner(System.in);
                String em_m = em_message.next();

                //EMAIL ADDRESS CHECK
                while (!em_m.matches("[a-zA-Z@._0-9]+")) {
                    System.out.println("ERROR: Please enter a valid input.");
                    System.out.println("Please type your EMAIL ADDRESS again: ");
                    em_m = em_message.next();
                }


                System.out.println("Enter your message: ");
                Scanner mes_message = new Scanner(System.in);
                String me_mess = mes_message.nextLine();
                try {
                    FileWriter RCWriter = new FileWriter("C:\\Users\\remhq\\Desktop\\Student Register\\src\\com\\Files\\UserMessages.txt", true);

                    RCWriter.write(F_n_message + "\n" + L_n_message + "\n" + p_message + "\n" + em_m + "\n" + me_mess + "\n");
                    RCWriter.write("-----------------------------Separator");
                    RCWriter.write("\n");
                    RCWriter.close();
                    System.out.println("Your message has been received!" + "\n" + "We will answer soon." + "\n" + "Thank you!");
                } catch (IOException excm) {
                    excm.printStackTrace();
                    System.out.println("ERROR");
                }


                break;
            case 10:
                ///EXIT PROGRAM BY THE USER
                System.out.println("Are you sure ?");
                System.out.println("Press \"[ENTER]\" to confirm !");
                promptENTER();
                System.out.println("See you soon!");
                Runtime.getRuntime().exit(1);


            default:
                System.out.println("Not a number between 1 and 10.Please try again.");
                System.out.println("Press \"[ENTER]\" to continue.");
                promptENTER();

        }

    }

}


