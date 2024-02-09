package aa4_woodshops;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class AA4_WoodShops {

    private static aa4_woodshops.Producto buscarProductoPorCodigo(String codigoProducto, List<aa4_woodshops.Tienda> tiendas) {
        for (aa4_woodshops.Tienda tienda : tiendas) {
            for (aa4_woodshops.Producto producto : tienda.getProductos()) {
                if (producto.getCodigo().equals(codigoProducto)) {
                    return producto;
                }
            }
        }
        System.out.println("Producto con código " + codigoProducto + " no encontrado.");
        return null;
    }
    private static aa4_woodshops.Cliente buscarClientePorNIF(String nif, List<aa4_woodshops.Cliente> clientes) {
        for (aa4_woodshops.Cliente cliente : clientes) {
            if (cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        System.out.println("Cliente con NIF " + nif + " no encontrado.");
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        aa4_woodshops.WoodShop woodShop = new aa4_woodshops.WoodShop("NIF_WoodShop", "WoodShop Tienda Principal");

        aa4_woodshops.Tienda tienda1 = new aa4_woodshops.Tienda("Tienda 1");
        aa4_woodshops.Tienda tienda2 = new aa4_woodshops.Tienda("Tienda 2");
        aa4_woodshops.Tienda tienda3 = new aa4_woodshops.Tienda("Tienda 3");

        woodShop.agregarTienda(tienda1);
        woodShop.agregarTienda(tienda2);
        woodShop.agregarTienda(tienda3);

        int tiendaSeleccionada = -1;

        List<aa4_woodshops.Proveedor> proveedores = new ArrayList<>(); // Agregamos la lista de proveedores
        List<aa4_woodshops.Cliente> clientes = new ArrayList<>(); // Agregamos la lista de clientes
        List<aa4_woodshops.Venta> ventas = new ArrayList<>(); // Agregamos la lista de ventas

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú de WoodShops (PRODUCTOS):");
            System.out.println("1. Añadir nuevo producto en una tienda");
            System.out.println("2. Añadir más stock de un producto en una tienda");
            System.out.println("3. Listar productos de una tienda por tipo");
            System.out.println("4. Mostrar stock de un producto en todas las tiendas");
            System.out.println("-----------------------------------");
            System.out.println("Menú de WoodShops (CLIENTES):");
            System.out.println("5. Añadir nuevo cliente en WoodShops");
            System.out.println("6. Mostrar listado de todos los clientes");
            System.out.println("-----------------------------------");
            System.out.println("Menú de WoodShops (VENTAS):");
            System.out.println("7. Añadir ticket de venta en la tienda");
            System.out.println("8. Mostrar un listado de resumen de tickets en la tienda");
            System.out.println("9. Mostrar un resumen de ventas por tienda");
            System.out.println("-----------------------------------");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Selecciona una tienda:");
                    for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                        System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                    }

                    tiendaSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    if (tiendaSeleccionada >= 1 && tiendaSeleccionada <= woodShop.getTiendas().size()) {
                        System.out.println("Introduce el código del producto:");
                        String codigo = scanner.nextLine();
                        System.out.println("Introduce la descripción del producto:");
                        String descripcion = scanner.nextLine();
                        System.out.println("Introduce el precio de venta del producto:");
                        double precioVenta = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Introduce el stock del producto:");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Selecciona el tipo de producto:");
                        System.out.println("1. Tablero");
                        System.out.println("2. Barniz");
                        System.out.println("3. Artículo");
                        int tipoProducto = scanner.nextInt();
                        scanner.nextLine();

                        int altura = 0;
                        int anchura = 0;
                        int mililitros = 0;

                        aa4_woodshops.Tablero.TipoTablero tipoTablero = aa4_woodshops.Tablero.TipoTablero.AGLOMERADO;
                        aa4_woodshops.Barniz.TipoColorBarniz tipoColor = aa4_woodshops.Barniz.TipoColorBarniz.INCOLORO;
                        aa4_woodshops.Articulo.TipoArticulo tipoArticulo = aa4_woodshops.Articulo.TipoArticulo.ESTANTERIA;

                        if (tipoProducto == 1) {
                            System.out.println("Introduce la altura del tablero (cm):");
                            altura = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Introduce la anchura del tablero (cm):");
                            anchura = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Selecciona el tipo de tablero:");
                            System.out.println("1. Aglomerado");
                            System.out.println("2. Contrachapado");
                            System.out.println("3. MDF");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    tipoTablero = aa4_woodshops.Tablero.TipoTablero.AGLOMERADO;
                                    break;
                                case 2:
                                    tipoTablero = aa4_woodshops.Tablero.TipoTablero.CONTRACHAPADO;
                                    break;
                                case 3:
                                    tipoTablero = aa4_woodshops.Tablero.TipoTablero.MDF;
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    continue;
                            }
                        } else if (tipoProducto == 2) {
                            System.out.println("Introduce la cantidad de mililitros del barniz:");
                            mililitros = scanner.nextInt();

                            System.out.println("Selecciona el tipo de color del barniz:");
                            System.out.println("1. Incoloro");
                            System.out.println("2. Caoba");
                            System.out.println("3. Nogal");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    tipoColor = aa4_woodshops.Barniz.TipoColorBarniz.INCOLORO;
                                    break;
                                case 2:
                                    tipoColor = aa4_woodshops.Barniz.TipoColorBarniz.CAOBA;
                                    break;
                                case 3:
                                    tipoColor = aa4_woodshops.Barniz.TipoColorBarniz.NOGAL;
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    continue;
                            }
                        } else if (tipoProducto == 3) {
                            System.out.println("Selecciona el tipo de artículo:");
                            System.out.println("1. Estantería");
                            System.out.println("2. Mesa");
                            System.out.println("3. Silla");
                            System.out.println("4. Armario");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    tipoArticulo = aa4_woodshops.Articulo.TipoArticulo.ESTANTERIA;
                                    break;
                                case 2:
                                    tipoArticulo = aa4_woodshops.Articulo.TipoArticulo.MESA;
                                    break;
                                case 3:
                                    tipoArticulo = aa4_woodshops.Articulo.TipoArticulo.SILLA;
                                    break;
                                case 4:
                                    tipoArticulo = aa4_woodshops.Articulo.TipoArticulo.ARMARIO;
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    continue;
                            }
                        } else {
                            System.out.println("Opción no válida");
                            continue;
                        }

                        System.out.println("Introduce el NIF del proveedor:");
                        String nifProveedor = scanner.nextLine();
                        System.out.println("Introduce el nombre del proveedor:");
                        String nombreProveedor = scanner.nextLine();

                        aa4_woodshops.Proveedor proveedor = new aa4_woodshops.Proveedor(nifProveedor, nombreProveedor);

                        proveedores.add(proveedor);

                        aa4_woodshops.Producto nuevoProducto;

                        if (tipoProducto == 1) {
                            nuevoProducto = new aa4_woodshops.Tablero(codigo, descripcion, proveedor, precioVenta, stock, altura, anchura, tipoTablero);
                        } else if (tipoProducto == 2) {
                            nuevoProducto = new aa4_woodshops.Barniz(codigo, descripcion, proveedor, precioVenta, stock, mililitros, tipoColor);
                        } else {
                            nuevoProducto = new aa4_woodshops.Articulo(codigo, descripcion, proveedor, precioVenta, stock, tipoArticulo);
                        }

                        woodShop.getTiendas().get(tiendaSeleccionada - 1).agregarProducto(nuevoProducto);
                        System.out.println("El producto se ha añadido con exito!");
                    } else {
                        System.out.println("Tienda seleccionada no válida.");
                    }
                    break;

                case 2:
                    System.out.println("Selecciona una tienda:");
                    for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                        System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                    }

                    int tiendaSeleccionadaAddStock = scanner.nextInt();
                    scanner.nextLine();

                    if (tiendaSeleccionadaAddStock >= 1 && tiendaSeleccionadaAddStock <= woodShop.getTiendas().size()) {
                        System.out.println("Selecciona el tipo de producto:");
                        System.out.println("1. Tablero");
                        System.out.println("2. Barniz");
                        System.out.println("3. Artículo");
                        int tipoProductoAddStock = scanner.nextInt();
                        scanner.nextLine();

                        String tipoProductoAddStockStr = "";
                        if (tipoProductoAddStock == 1) {
                            tipoProductoAddStockStr = "Tablero";
                        } else if (tipoProductoAddStock == 2) {
                            tipoProductoAddStockStr = "Barniz";
                        } else if (tipoProductoAddStock == 3) {
                            tipoProductoAddStockStr = "Artículo";
                        } else {
                            System.out.println("Opción no válida");
                            continue;
                        }

                        List<aa4_woodshops.Producto> productosFiltradosAddStock = woodShop.getTiendas().get(tiendaSeleccionadaAddStock - 1).listarProductosPorTipo(tipoProductoAddStockStr);

                        if (productosFiltradosAddStock.isEmpty()) {
                            System.out.println("No hay productos de tipo " + tipoProductoAddStockStr + " en " + woodShop.getTiendas().get(tiendaSeleccionadaAddStock - 1).getNombreTienda());
                        } else {
                            System.out.println("Productos de tipo " + tipoProductoAddStockStr + " en " + woodShop.getTiendas().get(tiendaSeleccionadaAddStock - 1).getNombreTienda() + ":");

                            for (int i = 0; i < productosFiltradosAddStock.size(); i++) {
                                aa4_woodshops.Producto producto = productosFiltradosAddStock.get(i);
                                System.out.println((i + 1) + ". " + producto.getCodigo() + ": " + producto.getDescripcion() + " (Stock actual = " + producto.getStock() + ")");
                            }

                            System.out.println("Selecciona el producto al que deseas añadir más stock:");
                            int seleccionProducto = scanner.nextInt();
                            scanner.nextLine();

                            if (seleccionProducto >= 1 && seleccionProducto <= productosFiltradosAddStock.size()) {
                                aa4_woodshops.Producto productoSeleccionado = productosFiltradosAddStock.get(seleccionProducto - 1);

                                System.out.println("Introduce el número de unidades del producto que deseas añadir:");
                                int unidadesAAdd = scanner.nextInt();
                                scanner.nextLine();

                                productoSeleccionado.addStock(unidadesAAdd);

                                System.out.println("Stock actualizado con éxito. Nuevo stock de " + productoSeleccionado.getCodigo() + ": " + productoSeleccionado.getStock());
                            } else {
                                System.out.println("Selección de producto no válida.");
                            }
                        }
                    } else {
                        System.out.println("Tienda seleccionada no válida.");
                    }
                    break;


                case 3:
                    if (tiendaSeleccionada == -1) {
                        System.out.println("Debes seleccionar una tienda primero.");
                    } else {
                        System.out.println("Selecciona una tienda:");
                        for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                            System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                        }

                        int tiendaElegida = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        if (tiendaElegida >= 1 && tiendaElegida <= woodShop.getTiendas().size()) {
                            System.out.println("Selecciona el tipo de producto:");
                            System.out.println("1. Tablero");
                            System.out.println("2. Barniz");
                            System.out.println("3. Artículo");
                            int tipoProductoListar = scanner.nextInt();
                            scanner.nextLine();

                            String tipoProductoListarStr = "";
                            if (tipoProductoListar == 1) {
                                tipoProductoListarStr = "Tablero";
                            } else if (tipoProductoListar == 2) {
                                tipoProductoListarStr = "Barniz";
                            } else if (tipoProductoListar == 3) {
                                tipoProductoListarStr = "Artículo";
                            } else {
                                System.out.println("Opción no válida");
                                continue;
                            }

                            List<aa4_woodshops.Producto> productosFiltrados = woodShop.getTiendas().get(tiendaElegida - 1).listarProductosPorTipo(tipoProductoListarStr);

                            if (productosFiltrados.isEmpty()) {
                                System.out.println("No hay productos de tipo " + tipoProductoListarStr + " en " + woodShop.getTiendas().get(tiendaElegida - 1).getNombreTienda());
                            } else {
                                System.out.println("Productos de tipo " + tipoProductoListarStr + " en " + woodShop.getTiendas().get(tiendaElegida - 1).getNombreTienda() + ":");

                                for (aa4_woodshops.Producto producto : productosFiltrados) {
                                    System.out.println("Código: " + producto.getCodigo());
                                    System.out.println("Descripción: " + producto.getDescripcion());
                                    System.out.println("Proveedor: " + producto.getProveedor().getNombre());
                                    System.out.println("NIF del Proveedor: " + producto.getProveedor().getNif());

                                    if (producto instanceof aa4_woodshops.Tablero) {
                                        aa4_woodshops.Tablero tablero = (aa4_woodshops.Tablero) producto;
                                        System.out.println("Altura: " + tablero.getAltura());
                                        System.out.println("Anchura: " + tablero.getAnchura());
                                        System.out.println("Tipo de Tablero: " + tablero.getTipoTablero());
                                    } else if (producto instanceof aa4_woodshops.Barniz) {
                                        aa4_woodshops.Barniz barniz = (aa4_woodshops.Barniz) producto;
                                        System.out.println("Mililitros: " + barniz.getMililitros());
                                        System.out.println("Tipo de Color: " + barniz.getTipoColor());
                                    } else if (producto instanceof aa4_woodshops.Articulo) {
                                        aa4_woodshops.Articulo articulo = (aa4_woodshops.Articulo) producto;
                                        System.out.println("Tipo de Artículo: " + articulo.getTipoArticulo());
                                    }

                                    System.out.println("Stock: " + producto.getStock());
                                    System.out.println("Precio de Venta: " + producto.getPrecioVenta());
                                    System.out.println("------------------------------------------");
                                }
                            }
                        } else {
                            System.out.println("Tienda seleccionada no válida.");
                        }
                    }
                    break;




                case 4:
                    if (tiendaSeleccionada == -1) {
                        System.out.println("Debes seleccionar una tienda primero.");
                    } else {
                        System.out.println("Introduce el código del producto:");
                        String codigoProducto = scanner.nextLine();

                        System.out.println("Stock del producto " + codigoProducto + " en todas las tiendas:");

                        for (aa4_woodshops.Tienda tienda : woodShop.getTiendas()) {
                            int stockProducto = tienda.obtenerStockProducto(codigoProducto);
                            System.out.println(tienda.getNombreTienda() + ": " + stockProducto);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Introduce el NIF del cliente:");
                    String nifCliente = scanner.nextLine();
                    System.out.println("Introduce el nombre del cliente:");
                    String nombreCliente = scanner.nextLine();

                    System.out.println("Selecciona el tipo de cliente:");
                    System.out.println("1. Cliente Profesional");
                    System.out.println("2. WoodFriend");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine();

                    switch (tipoCliente) {
                        case 1:
                            System.out.println("Introduce el descuento del cliente profesional:");
                            double descuentoProfesional = scanner.nextDouble();
                            scanner.nextLine();
                            aa4_woodshops.ClienteProfesional nuevoClienteProfesional = new aa4_woodshops.ClienteProfesional(nifCliente, nombreCliente, descuentoProfesional);
                            clientes.add(nuevoClienteProfesional);
                            break;
                        case 2:
                            System.out.println("Introduce el código de socio del WoodFriend:");
                            String codigoSocio = scanner.nextLine();
                            aa4_woodshops.WoodFriend nuevoWoodFriend = new aa4_woodshops.WoodFriend(nifCliente, nombreCliente, codigoSocio);
                            clientes.add(nuevoWoodFriend);
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    System.out.println("Cliente añadido con éxito.");
                    break;

                case 6:
                    System.out.println("Listado de clientes en WoodShops:");
                    for (aa4_woodshops.Cliente cliente : clientes) {
                        System.out.println("NIF: " + cliente.getNif());
                        System.out.println("Nombre: " + cliente.getNombre());
                        System.out.println("Tipo de Cliente: " + cliente.getTipoCliente());

                        if (cliente instanceof aa4_woodshops.ClienteProfesional) {
                            System.out.println("Descuento: " + ((aa4_woodshops.ClienteProfesional) cliente).getDescuento() + "%");
                        } else if (cliente instanceof aa4_woodshops.WoodFriend) {
                            System.out.println("Número de Socio: " + ((aa4_woodshops.WoodFriend) cliente).getCodigoSocio());
                        }

                        System.out.println("------------------------------------------");
                    }
                    break;


                case 7:
                    System.out.println("Selecciona una tienda:");
                    for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                        System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                    }

                    int tiendaSeleccionadaVenta = scanner.nextInt();
                    scanner.nextLine();

                    if (tiendaSeleccionadaVenta >= 1 && tiendaSeleccionadaVenta <= woodShop.getTiendas().size()) {
                        // Crear un nuevo ticket de venta
                        aa4_woodshops.TicketVenta nuevoTicket = new aa4_woodshops.TicketVenta();

                        // Lógica para obtener la fecha de la venta
                        System.out.println("Introduce la fecha de la venta (formato dd/mm/yyyy):");
                        String fechaVentaStr = scanner.nextLine();
                        // Convertir la cadena de fecha a un objeto LocalDate (puedes usar DateTimeFormatter aquí)
                        // LocalDate fechaVenta = ...

                        // Lógica para obtener el cliente registrado (si lo hay)
                        System.out.println("Introduce el NIF del cliente (o '0' para cliente anónimo):");
                        String nifClienteVenta = scanner.nextLine();
                        aa4_woodshops.Cliente clienteVenta = null;

                        if (!nifClienteVenta.equals("0")) {
                            // Buscar el cliente por NIF en la lista de clientes
                            clienteVenta = buscarClientePorNIF(nifClienteVenta, clientes);
                        }
                        nuevoTicket.setCliente(clienteVenta);

                        // Lógica para añadir productos al ticket
                        boolean agregarProducto = true;
                        while (agregarProducto) {
                            System.out.println("Introduce el código del producto:");
                            String codigoProducto = scanner.nextLine();

                            aa4_woodshops.Producto producto = buscarProductoPorCodigo(codigoProducto, woodShop.getTiendas());

                            if (producto != null) {
                                System.out.println("Introduce la cantidad de unidades:");
                                int cantidad = scanner.nextInt();
                                scanner.nextLine();

                                // Añadir una línea de detalle al ticket
                                aa4_woodshops.LineaTicket linea = new aa4_woodshops.LineaTicket(producto, cantidad);
                                nuevoTicket.agregarLinea(linea);
                            } else {
                                System.out.println("Producto no encontrado.");
                            }

                            // Preguntar si se quiere agregar otro producto
                            System.out.println("¿Deseas agregar otro producto? (S/N):");
                            String respuesta = scanner.nextLine();
                            agregarProducto = respuesta.equalsIgnoreCase("S");
                        }

                        // Calcular el total del ticket y aplicar descuento si hay cliente y es ClienteProfesional
                        double totalTicket = nuevoTicket.calcularTotal(true);
                        double totalOriginal = totalTicket; // Almacena el total original sin descuento

                        if (nuevoTicket.getCliente() != null) {
                            if (nuevoTicket.getCliente() instanceof aa4_woodshops.ClienteProfesional) {
                                aa4_woodshops.ClienteProfesional clienteProfesional = (aa4_woodshops.ClienteProfesional) nuevoTicket.getCliente();
                                double descuento = clienteProfesional.getDescuento();
                                double descuentoAplicado = (descuento / 100.0) * totalTicket;

                                // Establecer el descuento en el ticket
                                nuevoTicket.setDescuento(descuento);

                                System.out.println("Total: " + String.format("%.2f", totalTicket));

                                // Mostrar descuento aplicado si se aplicó
                                if (descuentoAplicado > 0) {
                                    System.out.println("Descuento aplicado: " + String.format("%.2f", descuentoAplicado) + " (" + descuento + "%)");
                                }

                                // Restar el descuento al total original
                                totalTicket = totalOriginal - descuentoAplicado;

                                // Mostrar el total después del descuento solo si hay descuento aplicado
                                System.out.println("Total después del descuento: " + String.format("%.2f", totalTicket));
                            } else if (nuevoTicket.getCliente() instanceof aa4_woodshops.WoodFriend) {
                                aa4_woodshops.WoodFriend woodFriend = (aa4_woodshops.WoodFriend) nuevoTicket.getCliente();
                                // Mostrar el total solo si no hay descuento aplicado
                                System.out.println("Total: " + String.format("%.2f", totalTicket));
                                // Mostrar numero de cliente WoodFriend
                                System.out.println("Cliente WoodFriend - Nº" + woodFriend.getCodigoSocio());
                            }
                        } else {
                            // Si el cliente es anónimo, simplemente mostrar el total
                            System.out.println("Total: " + String.format("%.2f", totalTicket));
                        }
                        // Agregar el ticket a la lista de ventas
                        woodShop.getTiendas().get(tiendaSeleccionadaVenta - 1).agregarVenta(nuevoTicket);

                        System.out.println("Venta registrada con éxito.");
                    } else {
                        System.out.println("Tienda seleccionada no válida.");
                    }
                    break;




                case 8:
                    if (tiendaSeleccionada == -1) {
                        System.out.println("Debes seleccionar una tienda primero.");
                    } else {
                        System.out.println("Introduce la fecha de inicio (formato: DD-MM-AAAA):");
                        String fechaInicioStr = scanner.nextLine();
                        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                        System.out.println("Introduce la fecha de fin (formato: DD-MM-AAAA):");
                        String fechaFinStr = scanner.nextLine();
                        LocalDate fechaFin = LocalDate.parse(fechaFinStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                        List<aa4_woodshops.TicketVenta> ticketsFiltrados = woodShop.getTiendas().get(tiendaSeleccionada - 1).listarTicketsPorFecha(fechaInicio, fechaFin);

                        if (ticketsFiltrados.isEmpty()) {
                            System.out.println("No hay tickets en el rango de fechas seleccionado.");
                        } else {
                            System.out.println("Resumen de tickets en " + woodShop.getTiendas().get(tiendaSeleccionada - 1).getNombreTienda() + " entre " + fechaInicioStr + " y " + fechaFinStr + ":");

                            for (aa4_woodshops.TicketVenta ticket : ticketsFiltrados) {
                                System.out.println("Número de Ticket: " + ticket.getNumeroTicket());
                                System.out.println("Fecha: " + ticket.getFecha());

                                aa4_woodshops.Cliente cliente = ticket.getCliente();
                                if (cliente != null) {
                                    System.out.println("Cliente: " + cliente.getNombre() + " (NIF: " + cliente.getNif() + ")");
                                    if (cliente instanceof aa4_woodshops.ClienteProfesional) {
                                        aa4_woodshops.ClienteProfesional clienteProfesional = (aa4_woodshops.ClienteProfesional) cliente;
                                        System.out.println("Tipo de Cliente: Profesional");
                                        System.out.println("Descuento aplicado: " + clienteProfesional.getDescuento() + "%");
                                    } else if (cliente instanceof aa4_woodshops.WoodFriend) {
                                        aa4_woodshops.WoodFriend woodFriend = (aa4_woodshops.WoodFriend) cliente;
                                        System.out.println("Tipo de Cliente: WoodFriend");
                                        System.out.println("Código de Socio: " + woodFriend.getCodigoSocio());
                                    }
                                } else {
                                    System.out.println("Cliente: Anónimo");
                                }

                                System.out.println("-----------------------------------------------");
                                System.out.println("Detalle del Ticket:");
                                System.out.println("-----------------------------------------------");

// Utiliza una lista auxiliar para almacenar las líneas de ticket ya impresas
                                List<aa4_woodshops.LineaTicket> lineasImpresas = new ArrayList<>();

                                for (aa4_woodshops.LineaTicket linea : ticket.getLineasTicket()) {
                                    // Verifica si ya has impreso esta línea de ticket
                                    if (!lineasImpresas.contains(linea)) {
                                        System.out.println("Producto: " + linea.getProducto().getDescripcion());
                                        System.out.println("Cantidad: " + linea.getCantidad());
                                        System.out.println("Precio Unitario: " + linea.getPrecioUnitario());
                                        System.out.println("Subtotal: " + linea.calcularSubtotal());
                                        System.out.println("-------------------------");

                                        lineasImpresas.add(linea);
                                    }
                                }

                                System.out.println("Descuento aplicado: " + ticket.getDescuento() + "%");
                                System.out.println("Total del Ticket: " + ticket.calcularTotal(true));
                                System.out.println("-----------------------------------------------");


                            }
                        }
                    }
                    break;

                case 9:
                    System.out.println("Introduce la fecha de inicio (formato: DD-MM-AAAA):");
                    String fechaInicioStr = scanner.nextLine();
                    LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    System.out.println("Introduce la fecha de fin (formato: DD-MM-AAAA):");
                    String fechaFinStr = scanner.nextLine();
                    LocalDate fechaFin = LocalDate.parse(fechaFinStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    System.out.println("Resumen de ventas por tienda entre " + fechaInicioStr + " y " + fechaFinStr + ":");

                    for (Tienda tienda : woodShop.getTiendas()) {
                        List<TicketVenta> ventasFiltradas = tienda.listarVentasPorFecha(fechaInicio, fechaFin);

                        double totalVentasTienda = 0;

                        System.out.println("Resumen ventas " + tienda.getNombreTienda() + " entre " + fechaInicioStr + " y " + fechaFinStr + ":");

                        if (!ventasFiltradas.isEmpty()) {
                            for (TicketVenta venta : ventasFiltradas) {
                                totalVentasTienda += venta.calcularTotal(false);  // No imprimir detalles en el case 9
                            }

                            System.out.println("Importe total: " + totalVentasTienda);
                        } else {
                            System.out.println("Importe total: Sin registros");
                        }

                        System.out.println(); // Salto de línea entre tiendas
                    }
                    break;




                case 0:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        System.out.println("Gracias por utilizar WoodShops.");
    }
}

