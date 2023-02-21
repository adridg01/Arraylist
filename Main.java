import java.util.Scanner;
public class Main {

    static Scanner sc=new Scanner(System.in);
        public static void main(String[] args) {
            boolean continuar=true;
            Scanner st=new Scanner(System.in);
            añadir();
            do {
                Contacto.TelefonoMovil.imprimirMenu();
                System.out.println("Elija alguna opcion:");
                int opc = st.nextInt();

                switch (opc) {
                    case 0:
                        System.out.println("Gracias por usar la agenda, hasta pronto.");
                        continuar=false;
                        break;
                    case 1:
                        Contacto.TelefonoMovil.printContacts();
                        break;
                    case 2:
                        añadir();
                        break;
                    case 3:
                        actualizar();
                        break;
                    case 4:
                        borrar();
                        break;
                    case 5:
                        buscar();
                        break;
                    default:
                        System.out.println("Elige una opcion correcta.");
                }
            }while (continuar);
        }

        public static void añadir(){
            String num;
            String nom;
            do {
                System.out.print("Escriba el nombre del contacto que desea añadir: ");
                nom= sc.nextLine();
                if (!Contacto.TelefonoMovil.comprobarNom(nom)){
                    System.out.println("Este nombre ya tiene un contacto asociado.");
                }
            }while (!Contacto.TelefonoMovil.comprobarNom(nom));
            do {
                System.out.print("Escriba el numero del contacto que desea añadir: ");
                num= sc.nextLine();
            }while (!Contacto.TelefonoMovil.comprobarNum(num));
            Contacto cont=new Contacto(nom,num);
            Contacto.TelefonoMovil.addNewContact(cont);
        }
        public static void actualizar(){
            String num;
            String nomv;
            do {
                System.out.print("Escriba el nombre del contacto que desea modificar: ");
                nomv= sc.nextLine();
                if (Contacto.TelefonoMovil.comprobarNom(nomv)){
                    System.out.println("Este nombre no existe en tu agenda.");
                }
            }while (Contacto.TelefonoMovil.comprobarNom(nomv));
            System.out.print("Escriba un nuevo nombre: ");
            String nomn=sc.nextLine();
            do {
                System.out.print("Escriba un numero de telefono nuevo: ");
                num= sc.nextLine();
            }while (!Contacto.TelefonoMovil.comprobarNum(num));
            Contacto contv= Contacto.TelefonoMovil.queryContact(nomv);
            Contacto contn=new Contacto(nomn,num);
            Contacto.TelefonoMovil.updateContact(contv,contn);
        }
        public static void borrar(){
            String nom;
            do {
                System.out.print("Escriba el nombre del contacto que desea eliminar: ");
                nom=sc.nextLine();
                if (Contacto.TelefonoMovil.comprobarNom(nom)) {
                    System.out.println("Este nombre no tiene ningun contacto asociado.");
                }
            }while(Contacto.TelefonoMovil.comprobarNom(nom));
            Contacto cont= Contacto.TelefonoMovil.queryContact(nom);
            Contacto.TelefonoMovil.removeContact(cont);
        }
        public static void buscar(){
            String nom;
            do {
                System.out.print("Escriba el nombre del contacto que quiere buscar: ");
                nom= sc.nextLine();
                if (Contacto.TelefonoMovil.comprobarNom(nom)) {
                    System.out.println("Este nombre no tiene ningun contacto asociado.");
                }
            }while(Contacto.TelefonoMovil.comprobarNom(nom));
            Contacto.TelefonoMovil.queryContact(nom);
            Contacto.TelefonoMovil.print1contact(nom);
        }
}
