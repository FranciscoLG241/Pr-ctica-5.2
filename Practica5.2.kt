


enum class EstadoPedido {
    PDTE, PGDO, PCDO, ENVDO, ENTGDO
}




class Cliente(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val telefono: String,
    val direccion: String
) {
    val pedidos = mutableListOf<Pedido>()

    fun realizarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }

    fun consultarEstadoPedido(pedidoId: Int): EstadoPedido? {
        return pedidos.find { it.id == pedidoId }?.estado
    }
}




class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val impuestos: Double,
    var stock: Int
) {
    fun actualizarStock(cantidadVendida: Int): Boolean {
        return if (stock >= cantidadVendida) {
            stock -= cantidadVendida
            true
        } else {
            false
        }
    }
}




class PedidoProducto(
    val producto: Producto,
    val cantidad: Int
)




class Pedido(
    val id: Int,
    val fecha: String,
    var estado: EstadoPedido
) {
    val productos = mutableListOf<PedidoProducto>()
    val pagos = mutableListOf<Pago>()

    fun agregarProducto(producto: Producto, cantidad: Int): Boolean {
        if (producto.actualizarStock(cantidad)) {
            productos.add(PedidoProducto(producto, cantidad))
            return true
        } else {
            println("No hay suficiente stock de ${producto.nombre}")
            return false
        }
    }

    fun calcularTotal(): Double {
        return productos.sumOf { it.producto.precio * it.cantidad * (1 + it.producto.impuestos) }
    }

    fun actualizarEstado(nuevoEstado: EstadoPedido) {
        estado = nuevoEstado
    }
}



class Pago(
    val id: Int,
    val monto: Double,
    val fechaPago: String,
    val tipoPago: String,
    val detallePago: String
)




fun main() {

    val cliente = Cliente(1, "Fran", "EGFIWGE", "DEEFE@FERFE.com", "123456789", "Calle 767")


    val producto1 = Producto(1, "Laptop", "Laptop Gamer", 1500.0, 0.21, 2)
    val producto2 = Producto(2, "Mouse", "Mouse", 50.0, 0.18, 1)


    val pedido = Pedido(1, "2025-01-30", EstadoPedido.PDTE)


    pedido.agregarProducto(producto1, 1)
    pedido.agregarProducto(producto2, 2)


    cliente.realizarPedido(pedido)


    println("Total del pedido: ${pedido.calcularTotal()}")


    val pago = Pago(1, 500.0, "2025-01-31", "Card", "Visa - 1234 5678 9012 3456")
    pedido.pagos.add(pago)


    pedido.actualizarEstado(EstadoPedido.PGDO)
    println("Estado del pedido: ${pedido.estado}")
}


