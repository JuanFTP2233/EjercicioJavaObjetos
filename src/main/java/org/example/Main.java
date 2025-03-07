package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cuenta> listCuenta = new ArrayList<>();

        Cuenta c1 = new Cuenta("Juan Pérez", 1500.75, "ES1234567890123456789012");
        Cuenta c2 = new Cuenta("María López", 2450.30, "ES9876543210987654321098");
        Cuenta c3 = new Cuenta("Carlos Gómez", 500.00, "ES5678901234567890123456");
        Cuenta c4 = new Cuenta();

        listCuenta.add(c1);
        listCuenta.add(c2);
        listCuenta.add(c3);
        listCuenta.add(c4);

        while (true) {
            System.out.println("\n--- Menú de Cuentas ---");
            System.out.println("1. Mostrar todas las cuentas");
            System.out.println("2. Consultar saldo de una cuenta");
            System.out.println("3. Ingresar saldo a una cuenta");
            System.out.println("4. Retirar saldo de una cuenta");
            System.out.println("5. Modificar titular de una cuenta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nLista de cuentas:");
                    listCuenta.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numCuentaConsulta = sc.nextLine();
                    Cuenta cuentaConsulta = buscarCuentaPorNumero(listCuenta, numCuentaConsulta);
                    if (cuentaConsulta != null) {
                        cuentaConsulta.consultarSaldo();
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numCuentaIngreso = sc.nextLine();
                    Cuenta cuentaIngreso = buscarCuentaPorNumero(listCuenta, numCuentaIngreso);
                    if (cuentaIngreso != null) {
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadIngreso = sc.nextDouble();
                        cuentaIngreso.ingresarSaldo(cantidadIngreso);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numCuentaRetiro = sc.nextLine();
                    Cuenta cuentaRetiro = buscarCuentaPorNumero(listCuenta, numCuentaRetiro);
                    if (cuentaRetiro != null) {
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidadRetiro = sc.nextDouble();
                        cuentaRetiro.retirarSaldo(cantidadRetiro);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numCuentaModificar = sc.nextLine();
                    Cuenta cuentaModificar = buscarCuentaPorNumero(listCuenta, numCuentaModificar);
                    if (cuentaModificar != null) {
                        System.out.print("Ingrese el nuevo titular: ");
                        String nuevoTitular = sc.nextLine();
                        cuentaModificar.setTitular(nuevoTitular);
                        System.out.println("Titular modificado correctamente.");
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    private static Cuenta buscarCuentaPorNumero(List<Cuenta> cuentas, String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}