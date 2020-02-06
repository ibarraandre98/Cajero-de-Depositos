package edcajerodedepositos;

import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.InputMismatchException;

public class EDCajerodedepositos {

    static Scanner leer = new Scanner(System.in);
    static int accion, tdinero, donacion;
    static boolean continuar = true;

    public static void main(String[] args) {
        Vector<Cajero> v1 = new Vector();
        v1.addElement(new Cajero(500, 200));
        v1.addElement(new Cajero(200, 500));
        v1.addElement(new Cajero(100, 1000));
        v1.addElement(new Cajero(50, 2000));
        Vector<ClientesBanco> v2 = new Vector();
        Vector<NoClientesBanco> v3 = new Vector();
        v2.addElement(new ClientesBanco("Andre", 1000, 1000, 9000));
        v3.addElement(new NoClientesBanco("Miguel", 1001, 9999, 5500));
        Vector<Recarga> v4 = new Vector();
        Vector<Historial> v5 = new Vector();
        v4.addElement(new Recarga("Movistar"));
        v4.addElement(new Recarga("Telcel"));
        v4.addElement(new Recarga("AT&T"));
        Vector<Donaciones> v6 = new Vector();
        String nombre, rec;
        int numero, nip, cant, monto, ret, dep, qui, dos, cien, cin, nq, nd, nc, ncin, don;
        for (int i = 0; i < v1.size(); i++) {
            tdinero = tdinero + (v1.elementAt(i).getBillete() * v1.elementAt(i).getCantidad());
        }
        do {
            do {
                boolean nom = false, n = false, nume = false;
                try {
                    for (int i = 0; i < v1.size(); i++) {
                        System.out.println("Los billetes son " + v1.elementAt(i).getBillete() + " y su cantidad es " + v1.elementAt(i).getCantidad());
                    }
                    System.out.println(tdinero);
                    System.out.println("Ingrese que desea realizar: 1.- Consultar, 2.-Retirar, 3.-Depositar, 4.-Recarga, 5.-Mostrar donaciones, 6.-Historial 0.- Salir");
                    accion = leer.nextInt();
                    switch (accion) {
                        case 1:
                            System.out.println("-----------------CONSULTAR----------------");
                            System.out.println("Ingrese su nombre: ");
                            nombre = leer.next();
                            //-----------------------------------------CLIENTE DEL BANCO--------------------------------
                            for (int i = 0; i < v2.size(); i++) {
                                if (nombre.equals(v2.elementAt(i).getNombre())) {
                                    System.out.println("Usted es cliente del banco");
                                    System.out.println("Ingrese su numero de tarjeta y su nip respectivamente");
                                    numero = leer.nextInt();
                                    nip = leer.nextInt();
                                    for (int j = 0; j < v2.size(); j++) {
                                        if (numero == v2.elementAt(j).getNumero() && nip == v2.elementAt(j).getNip()) {
                                            System.out.println("A continuacion se mostrará su saldo: ");
                                            System.out.println("Su saldo actual es " + v2.elementAt(j).getCant() + " pesos");
                                            System.out.println("");
                                            n = true;
                                        }
                                    }
                                    if (n == false) {
                                        System.out.println("El numero o el nip son incorrectos.");
                                        System.out.println("");
                                    }
                                    nom = true;
                                }
                            }
                            //-----------------------------------CLIENTE DE OTRO BANCO---------------------------------------
                            if (nom == false) {
                                for (int i = 0; i < v3.size(); i++) {
                                    if (nombre.equals(v3.elementAt(i).getNombre())) {
                                        System.out.println("Usted no es cliente del banco.");
                                        System.out.println("Ingrese el numero de su tarjeta y su nip respectivamente: ");
                                        numero = leer.nextInt();
                                        nip = leer.nextInt();
                                        for (int j = 0; j < v3.size(); j++) {
                                            if (numero == v3.elementAt(j).getNumero() && nip == v3.elementAt(j).getNip()) {
                                                System.out.println("Su saldo actual es de " + v3.elementAt(i).getCant() + " pesos");
                                                System.out.println("");
                                                n = true;
                                            }
                                        }
                                        if (n == false) {
                                            System.out.println("Su numero y/o nip son incorrectos.");
                                        }
                                        System.out.println("");
                                        nom = true;
                                    }
                                }
                                //------------------------------CLIENTE DE NINGUNO NO EXISTE--------------------------------
                                if (nom == false) {
                                    System.out.println("Este nombre no esta en ninguna base de datos.");
                                    System.out.println("");
                                }
                            }

                            break;
                        case 2:
                            System.out.println("---------------RETIRAR-------------");
                            System.out.println("Ingrese su nombre para retirar: ");
                            nombre = leer.next();
                            //---------------------------------------CLIENTE DEL BANCO-----------------------------------------------
                            for (int i = 0; i < v2.size(); i++) {
                                if (nombre.equals(v2.elementAt(i).getNombre())) {
                                    System.out.println("Usted es cliente del banco");
                                    System.out.println("Ingrese su numero de tarjeta y su nip respectivamente");
                                    numero = leer.nextInt();
                                    nip = leer.nextInt();
                                    for (int j = 0; j < v2.size(); j++) {
                                        if (numero == v2.elementAt(j).getNumero() && nip == v2.elementAt(j).getNip()) {
                                            System.out.println("Ingrese la cantidad a retirar: ");
                                            ret = leer.nextInt();
                                            if (ret > v2.elementAt(i).getCant() || ret > 7000 || ret > tdinero) {
                                                System.out.println("Usted no dispone de esa cantidad de dinero o ha rebasado el tope o el cajero no dispone de suficiente dinero.");
                                            } else {
                                                cant = v2.elementAt(i).getCant() - ret;
                                                v2.elementAt(i).setCant(cant);
                                                System.out.println("¿DESEA DONAR? 1.-Si, 2.-No");
                                                don = leer.nextInt();
                                                if (don == 1) {
                                                    System.out.println("Ingrese el monto a donar en multiplos de 50");
                                                    donacion = leer.nextInt();
                                                    if (donacion > v2.elementAt(j).getCant()) {
                                                        System.out.println("Usted no puede donar, no tiene dinero suficiente. ");
                                                        donacion = 0;
                                                    } else {
                                                        donacion = donacion;
                                                        for (int k = 0; k < v6.size(); k++) {
                                                            if (nombre.equals(v6.elementAt(k).getNombre())) {

                                                            } else {
                                                                v6.addElement(new Donaciones(nombre));
                                                            }
                                                        }
                                                    }
                                                } else if (don == 2) {
                                                    donacion = 0;
                                                }
                                                cant = v2.elementAt(i).getCant() - donacion;
                                                v2.elementAt(i).setCant(cant);
                                                System.out.println("Retiro de " + ret + " Exitoso");
                                                System.out.println("El saldo disponible en su cuenta es de " + v2.elementAt(i).getCant());
                                                System.out.println("");
                                                tdinero = tdinero - ret;
                                                qui = ret;
                                                System.out.println("Billetes de quinientos: " + (qui / 500));
                                                dos = (qui % 500);
                                                System.out.println("Billetes de doscientos: " + (dos / 200));
                                                cien = (dos % 200);
                                                System.out.println("Billetes de cien: " + cien / 100);
                                                cin = (cien % 100);
                                                System.out.println("Billetes de 50: " + cin / 50);
                                                System.out.println("");
                                                for (int k = 0; k < v1.size(); k++) {
                                                    if (500 == v1.elementAt(k).getBillete()) {
                                                        if (v1.elementAt(k).getCantidad() <= 0) {
                                                            System.out.println("Ya no hay billetes de 500");
                                                        } else {
                                                            v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (qui / 500));
                                                        }
                                                    } else if (200 == v1.elementAt(k).getBillete()) {
                                                        if (v1.elementAt(i).getCantidad() <= 0) {
                                                            System.out.println("Ya no hay billetes de 200");
                                                        } else {
                                                            v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (dos / 200));
                                                        }
                                                    } else if (100 == v1.elementAt(k).getBillete()) {
                                                        if (v1.elementAt(k).getCantidad() <= 0) {
                                                            System.out.println("Ya no hay billetes de 100");
                                                        } else {
                                                            v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (cien / 100));
                                                        }
                                                    } else if (50 == v1.elementAt(k).getBillete()) {
                                                        if (v1.elementAt(k).getCantidad() <= 0) {
                                                            System.out.println("Ya no hay billetes de 50");
                                                        } else {
                                                            v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (cin / 50));
                                                        }
                                                    }
                                                }
                                                v5.addElement(new Historial(nombre,numero,nip,"Retiro",ret));
                                            }
                                            System.out.println("");
                                            n = true;
                                        }
                                    }
                                    if (n == false) {
                                        System.out.println("El numero o el nip son incorrectos.");
                                        System.out.println("");
                                    }
                                    nom = true;
                                }
                            }
                            //-----------------------------------CLIENTE DE OTRO BANCO-------------------------------------------
                            if (nom == false) {
                                for (int i = 0; i < v3.size(); i++) {
                                    if (nombre.equals(v3.elementAt(i).getNombre())) {
                                        System.out.println("Ingrese el numero de su tarjeta y su nip respectivamente: ");
                                        numero = leer.nextInt();
                                        nip = leer.nextInt();
                                        for (int j = 0; j < v3.size(); j++) {
                                            if (numero == v3.elementAt(j).getNumero() && nip == v3.elementAt(j).getNip()) {

                                                System.out.println("Ingrese la cantidad a retirar: ");
                                                ret = leer.nextInt();
                                                if (ret > v3.elementAt(i).getCant() || ret > 7000 || ret > tdinero) {
                                                    System.out.println("Usted no dispone de esa cantidad de dinero o ha rebasado el tope o el cajero no dispone de suficiente dinero.");
                                                } else {
                                                    cant = v3.elementAt(i).getCant() - ret - (40);
                                                    v3.elementAt(i).setCant(cant);

                                                    System.out.println("¿DESEA DONAR? 1.-Si, 2.-No");
                                                    don = leer.nextInt();
                                                    if (don == 1) {
                                                        System.out.println("Ingrese el monto a donar en multiplos de 50");
                                                        donacion = leer.nextInt();
                                                        if (donacion > v3.elementAt(j).getCant()) {
                                                            System.out.println("Usted no puede donar, no tiene dinero suficiente. ");
                                                            donacion = 0;
                                                        } else {
                                                            donacion = donacion;
                                                            for (int k = 0; k < v6.size(); k++) {
                                                                if (nombre.equals(v6.elementAt(k).getNombre())) {

                                                                } else {
                                                                    v6.addElement(new Donaciones(nombre));
                                                                }
                                                            }
                                                        }
                                                    } else if (don == 2) {
                                                        donacion = 0;
                                                    }
                                                    cant = v3.elementAt(i).getCant() - donacion;
                                                    v3.elementAt(i).setCant(cant);
                                                    System.out.println("Retiro exitoso de " + ret);
                                                    System.out.println("El saldo disponible en su cuenta es de " + v3.elementAt(i).getCant());
                                                    System.out.println("Se le aplico la comision de 40 pesos");

                                                    System.out.println("");
                                                    tdinero = tdinero - ret;
                                                    qui = ret;
                                                    System.out.println("Billetes de quinientos: " + (qui / 500));
                                                    dos = (qui % 500);
                                                    System.out.println("Billetes de doscientos: " + (dos / 200));
                                                    cien = (dos % 200);
                                                    System.out.println("Billetes de cien: " + cien / 100);
                                                    cin = (cien % 100);
                                                    System.out.println("Billetes de 50: " + cin / 50);
                                                    System.out.println("");
                                                    for (int k = 0; k < v1.size(); k++) {
                                                        if (500 == v1.elementAt(k).getBillete()) {
                                                            if (v1.elementAt(k).getCantidad() <= 0) {
                                                                System.out.println("Ya no hay billetes de 500");
                                                            } else {
                                                                v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (qui / 500));
                                                            }
                                                        } else if (200 == v1.elementAt(k).getBillete()) {
                                                            if (v1.elementAt(i).getCantidad() <= 0) {
                                                                System.out.println("Ya no hay billetes de 200");
                                                            } else {
                                                                v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (dos / 200));
                                                            }
                                                        } else if (100 == v1.elementAt(k).getBillete()) {
                                                            if (v1.elementAt(k).getCantidad() <= 0) {
                                                                System.out.println("Ya no hay billetes de 100");
                                                            } else {
                                                                v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (cien / 100));
                                                            }
                                                        } else if (50 == v1.elementAt(k).getBillete()) {
                                                            if (v1.elementAt(k).getCantidad() <= 0) {
                                                                System.out.println("Ya no hay billetes de 50");
                                                            } else {
                                                                v1.elementAt(k).setCantidad(v1.elementAt(k).getCantidad() - (cin / 50));
                                                            }
                                                        }
                                                    }
                                                    v5.addElement(new Historial(nombre,numero,nip,"Retiro",ret));
                                                }

                                                System.out.println("");
                                                n = true;
                                            }
                                        }
                                        if (n == false) {
                                            System.out.println("Su numero y/o nip son incorrectos.");
                                        }
                                        System.out.println("");
                                        nom = true;
                                    }
                                }
                                //---------------------------------------------CLIENTE DE NINGUNO NO EXISTE-------------------------------------
                                if (nom == false) {
                                    System.out.println("Este nombre no esta en ninguna base de datos.");
                                    System.out.println("");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("---------------DEPOSITAR-------------");
                            System.out.println("Ingrese el numero de tarjeta a depositar: ");
                            numero = leer.nextInt();
                            //----------------------------CLIENTE DEL BANCO-----------------------------------
                            for (int i = 0; i < v2.size(); i++) {
                                if (numero == v2.elementAt(i).getNumero()) {
                                    System.out.println("Ingrese la cantidad a depositar: ");
                                    dep = leer.nextInt();
                                    tdinero = tdinero + dep;
                                    qui = dep;
                                    System.out.println("Los billetes de 500 son: " + qui / 500);
                                    dos = (qui % 500);
                                    System.out.println("Los billetes de 200 son: " + dos / 200);
                                    cien = (dos % 200);
                                    System.out.println("Los billetes de 100 son: " + cien / 100);
                                    cin = (cien % 100);
                                    System.out.println("Los billetes de 50 son: " + cin / 50);
                                    System.out.println("");
                                    for (int j = 0; j < v1.size(); j++) {
                                        if (500 == v1.elementAt(j).getBillete()) {
                                            v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (qui / 500));
                                        } else if (200 == v1.elementAt(j).getBillete()) {
                                            v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (dos / 200));
                                        } else if (100 == v1.elementAt(j).getBillete()) {
                                            v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (cien / 100));
                                        } else if (50 == v1.elementAt(j).getBillete()) {
                                            v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (cin / 50));
                                        }
                                    }
                                    v5.addElement(new Historial(v2.elementAt(i).getNombre(),numero,v2.elementAt(i).getNip(),"Deposito",dep));
                                    nume = true;
                                }
                            }
                            if (nume == false) {
                                for (int i = 0; i < v3.size(); i++) {
                                    if (numero == v3.elementAt(i).getNumero()) {
                                        System.out.println("Ingrese la cantidad a depositar: ");
                                        dep = leer.nextInt();
                                        tdinero = tdinero + dep;
                                        qui = dep;
                                        System.out.println("Los billetes de 500 son: " + qui / 500);
                                        dos = (qui % 500);
                                        System.out.println("Los billetes de 200 son: " + dos / 200);
                                        cien = (dos % 200);
                                        System.out.println("Los billetes de 100 son: " + cien / 100);
                                        cin = (cien % 100);
                                        System.out.println("Los billetes de 50 son: " + cin / 50);
                                        System.out.println("");
                                        for (int j = 0; j < v1.size(); j++) {
                                            if (500 == v1.elementAt(j).getBillete()) {
                                                v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (qui / 500));
                                            } else if (200 == v1.elementAt(j).getBillete()) {
                                                v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (dos / 200));
                                            } else if (100 == v1.elementAt(j).getBillete()) {
                                                v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (cien / 100));
                                            } else if (50 == v1.elementAt(j).getBillete()) {
                                                v1.elementAt(j).setCantidad(v1.elementAt(j).getCantidad() + (cin / 50));
                                            }
                                        }
                                        v5.addElement(new Historial(v3.elementAt(i).getNombre(),numero,v3.elementAt(i).getNip(),"Deposito",dep));
                                        nume = true;
                                    }
                                }
                                if (nume == false) {
                                    System.out.println("Este numero de tarjeta no existe.");
                                    System.out.println("");
                                }
                            }

                            break;
                        case 4:
                            System.out.println("---------------RECARGA----------------");
                            System.out.println("Ingrese su numero de tarjeta: ");
                            numero = leer.nextInt();
                            //------------------------------------CLIENTE BANCO---------------------------------------------
                            for (int i = 0; i < v2.size(); i++) {
                                if (numero == v2.elementAt(i).getNumero()) {
                                    System.out.println("Ingrese el numero de su nip.");
                                    nip = leer.nextInt();
                                    if (nip == v2.elementAt(i).getNip()) {
                                        System.out.println("Ingrese la compañia de la recarga: Movistar, Telcel, AT&T");
                                        rec = leer.next();
                                        for (int j = 0; j < v4.size(); j++) {
                                            if (rec.equals(v4.elementAt(j).getCompañia())) {
                                                System.out.println("Ingrese el monto de la recarga: 20,50,100,200,500");
                                                monto = leer.nextInt();
                                                if (monto == 20 || monto == 50 || monto == 100 || monto == 200 || monto == 500) {
                                                    System.out.println("Recarga exitosa.");
                                                    v2.elementAt(i).setCant(v2.elementAt(i).getCant() - monto);
                                                    System.out.println("Su saldo actual es de: " + v2.elementAt(i).getCant());
                                                    v5.addElement(new Historial(v2.elementAt(i).getNombre(),numero,v2.elementAt(i).getNip(),"Recarga",monto));
                                                } else {
                                                    System.out.println("No se puede realizar recarga por este monto");
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Este nip es incorrecto.");
                                    }
                                    nume = true;
                                }
                            }
                            //-------------------------CLIENTE OTRO BANCO---------------------------------------
                            if (nume == false) {
                                for (int i = 0; i < v3.size(); i++) {
                                    if (numero == v3.elementAt(i).getNumero()) {
                                        System.out.println("Ingrese el numero de su nip.");
                                        nip = leer.nextInt();
                                        if (nip == v3.elementAt(i).getNip()) {
                                            System.out.println("Ingrese la compañia de la recarga: Movistar, Telcel, AT&T");
                                            rec = leer.next();
                                            for (int j = 0; j < v4.size(); j++) {
                                                if (rec.equals(v4.elementAt(j).getCompañia())) {
                                                    System.out.println("Ingrese el monto de la recarga: 20,50,100,200,500");
                                                    monto = leer.nextInt();
                                                    if (monto == 20 || monto == 50 || monto == 100 || monto == 200 || monto == 500) {
                                                        System.out.println("Recarga exitosa.");
                                                        v3.elementAt(i).setCant(v3.elementAt(i).getCant() - monto);
                                                        System.out.println("Su saldo actual es de: " + v3.elementAt(i).getCant());
                                                        v5.addElement(new Historial(v3.elementAt(i).getNombre(),numero,v3.elementAt(i).getNip(),"Recarga",monto));
                                                    } else {
                                                        System.out.println("No se puede realizar recarga por este monto");
                                                    }
                                                }
                                            }
                                        } else {
                                            System.out.println("Este nip es incorrecto.");
                                        }
                                        nume = true;
                                    }
                                }
                                if (nume == false) {
                                    System.out.println("Este numero de tarjeta no existe");
                                }
                            }
                            break;
                        case 5:
                            System.out.println("---------------DONACIONES-----------------");
                            System.out.println("Se mostraran los nombres de los donadores.");
                            for (int i = 0; i < v6.size(); i++) {
                                System.out.println("Los nombres de los donadores de este banco son: " + v6.elementAt(i).getNombre());
                            }
                            System.out.println("");
                            break;
                        case 6:
                            System.out.println("------------------HISTORIAL--------------------");
                            System.out.println("Ingrese el numero de su cuenta: ");
                            numero=leer.nextInt();
                            for (int i = 0; i < v5.size(); i++) {
                                if(numero==v5.elementAt(i).getNumero()){
                                    System.out.println("Ingrese su nip");
                                    nip=leer.nextInt();
                                    if(nip==v5.elementAt(i).getNip()){
                                        System.out.println("Nombre: "+v5.elementAt(i).getNombre()+" ha realizado un "+v5.elementAt(i).getAccion()+" por un monto de "+v5.elementAt(i).getCantidad());
                                    }else{
                                        System.out.println("El nip es incorrecto");
                                    }
                                    nom=true;
                                }
                            }
                            if(nom==false){
                                System.out.println("Este numero de tarjeta no existe");
                                System.out.println("");
                            }
                            break;
                        case 0:
                            System.out.println("Ha salido con exito.");
                            break;
                        default:
                            System.out.println("Ingrese una opcion correcta.");
                            System.out.println("");
                            break;
                    }
                    continuar = false;
                } catch (InputMismatchException e) {
                    leer.nextLine();
                    System.err.println("Ingrese el formato que se pide " + e);
                } catch (ArrayIndexOutOfBoundsException e) {
                    leer.nextLine();
                    System.err.println("Esta fuera del vector " + e);
                } catch (ArithmeticException e) {
                    leer.nextLine();
                    System.err.println("Ha ocurrido un error aritmetico");
                }
            } while (continuar == true);
        } while (accion != 0);
    }

}
