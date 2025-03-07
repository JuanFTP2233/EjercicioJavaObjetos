package org.example;

public class Cuenta {
    private String titular;
    private Double saldo;
    private String numeroCuenta;

    public Cuenta() {
        this.titular = "Sin titular";
        this.saldo = 0.0;
        this.numeroCuenta = "Sin número de cuenta";
    }

    public Cuenta(String titular, Double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void consultarSaldo() {
        System.out.println("El saldo actual de la cuenta de " + titular + " es: " + saldo + " €");
    }

    public void ingresarSaldo(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se han ingresado " + cantidad + " € a la cuenta de " + titular);
        } else {
            System.out.println("La cantidad a ingresar debe ser mayor que 0.");
        }
    }

    public void retirarSaldo(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Se han retirado " + cantidad + " € de la cuenta de " + titular);
        } else if (cantidad > saldo) {
            System.out.println("Fondos insuficientes. Saldo actual: " + saldo + " €");
        } else {
            System.out.println("La cantidad a retirar debe ser mayor que 0.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                '}';
    }
}
