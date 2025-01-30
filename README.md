# Pr-ctica-5.2

##Descripción:
La actividad consiste en generar el diagrama de clases y posteriormente un esquema de lo que sería el código que se derive del diagrama de clases que represente lo descrito en el supuesto

##Objetivo:

Conocer los elementos que forman parte de un diagrama de clases.
Conocer las relaciones que existen entre las clases.
Conocer herramientas
Trabajo a realizar:

# Para diseñar un sistema que gestione los pedidos de mi empresa, es necesario considerar los siguientes requerimientos:

- Los pedidos los realizan los clientes, y pueden contener uno o varios productos.
- Debe registrar la información de cada pedido, incluyendo la fecha en que se realizó.
- Estos productos deben estar registrados en el sistema junto con su información correspondiente (nombre, descripción, precio, impuestos, etc.).
- El sistema debe ser capaz de calcular el coste total de cada pedido, teniendo en cuenta la cantidad de cada producto incluido en el pedido, sus precios individuales y los impuestos correspondientes.
- Debe haber un registro actualizado del stock de cada producto, de forma que se pueda informar al cliente si habrá algún retraso en la entrega debido a falta de stock.
- Cada pedido puede ser pagado de una sola vez o en varios pagos. 
- Se debe ser capaz de registrar la información de cada pago realizado por el cliente.
- Las formas de pago aceptadas por el sistema son: Card (número, fecha de caducidad y tipo de tarjeta), Cash  (Tipo de moneda) y cheque (nombre y banco).
- Cada pedido puede estar en uno de los siguientes estados: pdte, pgdo, pcdo, envdo, entgdo. El estado de cada pedido debe ser actualizado en el sistema en función de su evolución.


## Recursos
Apuntes dados en clase
Recursos vistos en clase.
Herramientas para diagramas UML:
Dia: https://sourceforge.net/projects/dia-installer/files/latest/download
otras: https://gitmind.com/es/herramienta-gratis-diagrama-uml.html
⇒Evaluación y calificación
RA y CE evaluados: RA5

Conlleva presentación: SI, (El profesor podrá requerir para la evaluación/calificación de la actividad, la revisión de esta junto al alumnado)

⇒Entrega

La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada. 

Se entregará el enlace al repositorio

# En el readme.md Identifica claramente cada punto. Contendrá el diagrama de clases refinado a diseño, explicando como has llegado a la solución. Ademas:

- a) Los elementos que te has encontrado en UML y que tienen mapeo sobre conceptos orientados a objetos.
Al hacer el diagrama de clases en UML, he encontrado varios conceptos que se relacionan directamente con la programación orientada a objetos:

- Clases: Representan objetos en el programa, como Cliente, Pedido o Producto.
- Atributos: Son las variables dentro de una clase, como nombre, precio o estadoPedido.
- Métodos: Son las funciones que puede realizar una clase, como calcularTotal() en la clase Pedido.


- b) Explicación de la herramienta que has utilizado parra generar el diagrama UML, y si la has contrastado con otra y conclusiones de porque has elegido esa.
Para hacer el diagrama de clases he usado Lucidchart, ya que es una herramienta online muy sencilla de usar y permite hacer diagramas de forma rápida con una interfaz intuitiva.
He elegido Lucidchart porque es fácil de usar, permite trabajar online sin necesidad de instalar nada y tiene muchas plantillas listas para usar.

- c) Explicación sobre la conversión del diagrama UML al código, explicando las decisiones que has tomado. No tiene porque ser el codigo completo, pero si un esquema de lo que podría llegar a ser. 
- Cada clase del diagrama UML se convierte en una clase en Kotlin.
Clase Cliente con atributos id, nombre y correo.
Clase Pedido con id, fecha y estado.

- En código Kotlin:
class Cliente(val id: Int, val nombre: String, val correo: String)
class Pedido(val id: Int, val fecha: String, var estado: String)

- Si una clase tiene una relación con otra (por ejemplo, un Cliente tiene varios Pedidos), se usa una lista en el código.
class Cliente(val id: Int, val nombre: String, val correo: String) {
    val pedidos = mutableListOf<Pedido>()  
}

- Si en UML una clase tiene una función (calcularTotal() en Pedido), se implementa en Kotlin:
class Pedido(val id: Int, val fecha: String, var estado: String) {
    fun calcularTotal(): Double {
        return 100.0  
    }
}
