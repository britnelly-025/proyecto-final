/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Sistemadeventas {

    static Scanner teclado = new Scanner(System.in);

    public static void Sistemadeventas() {

        int opcion;
        int ventasRealizadas = 0;
        int productosVendidos = 0;
        int ventasEnEfectivo = 0;
        int ventasConTransferencia = 0;
        int ventasConTarjeta = 0;
        double totalVendido = 0;
        double ventaMayor = 0;
        double ventaMenor = 0;

        do {
            System.out.println("----------------------------------");
            System.out.println("Menu sistema de ventas");
            System.out.println("1 Registrar una venta");
            System.out.println("2 Consultar caja"); 
            System.out.println("3 Mostrar estadistica");
            System.out.println("4 Salir");
            System.out.println("------------------------------------");
            System.out.println("Seleccione la opcion");

            opcion = teclado.nextInt();

            while (opcion < 1 || opcion > 4) {
                System.out.println("Opcion invalida");
                System.out.println("Selecione la opcion entre 1 y 4");
                opcion = teclado.nextInt();
            }
            switch (opcion) {
                case 1:
                    System.out.println("**REGISTRAR UNA VENTA**");
                    System.out.println("Cuantos productos desea registrar");
                    int numeroDeProductos = teclado.nextInt();

                    while (numeroDeProductos <= 0) {
                        System.out.println("Opcion invalida, debe ser un numero mayor que cero");
                        System.out.println("Ingrese nuevamente: ");
                        numeroDeProductos = teclado.nextInt();
                    }
                    double subTotalDeVentas = 0;
                    int cantidadDeProductos = 0;

                    for (int contador = 1; contador <= numeroDeProductos; contador++) {
                        System.out.println("#" + contador);
                        System.out.println("Ingrese codigo: ");
                        int codigo = teclado.nextInt();
                        System.out.println(" Ingrese el nombre del producto: ");
                        String nombre = teclado.next();
                        System.out.println("Ingrese precio: ");
                        double precio = teclado.nextDouble();

                        while (precio <= 0) {
                            System.out.println("Opcion invalida, debe ser un numero mayor que cero");
                            System.out.println("Ingrese nuevamente: ");
                            precio = teclado.nextDouble();
                        }

                        System.out.println("Ingrese la cantidad: ");
                        int cantidad = teclado.nextInt();

                        while (cantidad <= 0) {
                            System.out.println("Opcion invalida, debe ser un numero mayor que cero");
                            System.out.println("Ingrese nuevamente: ");
                            cantidad = teclado.nextInt();
                        }
                        double subTotalDeProductos = precio * cantidad;
                        subTotalDeVentas = subTotalDeVentas + subTotalDeProductos;
                        cantidadDeProductos = cantidadDeProductos + cantidad;

                        System.out.println("----------------------------------");
                        System.out.println("codigo: " + codigo);
                        System.out.println("producto: " + nombre);
                        System.out.println("subtotal de producto: " + subTotalDeProductos);
                        System.out.println("----------------------------------");
                    }
                    double porcentajeDescuento;
                    if (subTotalDeVentas < 200) {
                        porcentajeDescuento = 0;
                    } else if (subTotalDeVentas < 500) {
                        porcentajeDescuento = 0.05;
                    } else if (subTotalDeVentas < 1000) {
                        porcentajeDescuento = 0.08;
                    } else {
                        porcentajeDescuento = 0.10;
                    }

                    double descuento = subTotalDeVentas * porcentajeDescuento;
                    double montoConDescuento = subTotalDeVentas - descuento;
                    double iva = montoConDescuento * 0.12;
                    double totalVenta = montoConDescuento + iva;

                    System.out.println("Forma de pago:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Transferencia");
                    System.out.print("Seleccione una forma de pago: ");
                    int formaPago = teclado.nextInt();

                    while (formaPago < 1 || formaPago > 3) {
                        System.out.println("Forma de pago invalida.");
                        System.out.print("Seleccione 1, 2 o 3: ");
                        formaPago = teclado.nextInt();
                    }

                    String nombreFormaPago = "";
                    double efectivoRecibido = 0;
                    double cambio = 0;

                    switch (formaPago) {
                        case 1:
                            nombreFormaPago = "Efectivo";
                            ventasEnEfectivo++;

                            System.out.println("Total a pagar: Q" + totalVenta);
                            System.out.print("Efectivo recibido: Q");
                            efectivoRecibido = teclado.nextDouble();

                            while (efectivoRecibido < totalVenta) {
                                System.out.println("Efectivo insuficiente.");
                                System.out.print("Ingrese nuevamente el efectivo: Q");
                                efectivoRecibido = teclado.nextDouble();
                            }

                            cambio = efectivoRecibido - totalVenta;
                            break;

                        case 2:
                            nombreFormaPago = "Tarjeta";
                            ventasConTarjeta++;
                            break;

                        case 3:
                            nombreFormaPago = "Transferencia";
                            ventasConTransferencia++;
                            break;
                    }

                    ventasRealizadas++;
                    productosVendidos = productosVendidos + cantidadDeProductos;
                    totalVendido = totalVendido + totalVenta;

                    if (ventasRealizadas == 1) {
                        ventaMayor = totalVenta;
                        ventaMenor = totalVenta;
                    } else {
                        if (totalVenta > ventaMayor) {
                            ventaMayor = totalVenta;
                        }

                        if (totalVenta < ventaMenor) {
                            ventaMenor = totalVenta;
                        }
                    }

                    System.out.println("==============================");
                    System.out.println("       RESUMEN DE VENTA");
                    System.out.println("==============================");
                    System.out.println("Cantidad de productos: " + cantidadDeProductos);
                    System.out.println("Subtotal: Q" + subTotalDeVentas);
                    System.out.println("Descuento: Q" + descuento);
                    System.out.println("IVA: Q" + iva);
                    System.out.println("Total: Q" + totalVenta);
                    System.out.println("Forma de pago: " + nombreFormaPago);

                    if (formaPago == 1) {
                        System.out.println("Efectivo recibido: Q" + efectivoRecibido);
                        System.out.println("Cambio: Q" + cambio);
                    }

                    break;

                case 2:
                    System.out.println("**CONSULTAR CAJA**");
                    System.out.println("-----------------------------------------");
                    System.out.println("Ventas realizadas:" + ventasRealizadas);
                    System.out.println("Productos vendidos:" + productosVendidos);
                    System.out.println("Total Vendido:" + totalVendido);
                    System.out.println("Ventas en efectivo: " + ventasEnEfectivo);
                    System.out.println("Ventas con tarjeta: " + ventasConTarjeta);
                    System.out.println("Ventas por transferencia: " + ventasConTransferencia);
                    System.out.println("-----------------------------------------");
                    break;

                case 3:
                    System.out.println("**ESTADISTICAS**");
                    if (ventasRealizadas == 0) {
                        System.out.println("No existe ventas realizadas");
                    } else {
                        double promedioDeVentas = totalVendido / ventasRealizadas;
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Numero total de ventas: " + ventasRealizadas);
                        System.out.println("Cantidad total de productos vendidos: " + productosVendidos);
                        System.out.println("Total de dinero vendido: Q" + totalVendido);
                        System.out.println("Promedio de dinero por venta: Q" + promedioDeVentas);
                        System.out.println("Ventas en efectivo: " + ventasEnEfectivo);
                        System.out.println("Ventas con tarjeta: " + ventasConTarjeta);
                        System.out.println("Ventas por transferencia: " + ventasConTransferencia);
                        System.out.println("Venta de mayor valor: Q" + ventaMayor);
                        System.out.println("Venta de menor valor: Q" + ventaMenor);
                        System.out.println("-----------------------------------------------------------");
                    }
                    break;

                default:
                    System.out.println("Ingrese una accion disponible");
                    break;
            }

        } while (opcion != 4);

    }
}
