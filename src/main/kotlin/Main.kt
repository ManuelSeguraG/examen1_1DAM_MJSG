// Realizado por Manuel Jesus Segura Garcia
package examen1

var entrada: String = ""
var listaEntrada = listOf<String>("0", "0")
var miNombre: String = "MANUEL JESUS SEGURA GARCIA"
var edad: Byte = 0
var mes: Byte = 0
var checkEdad: Boolean = true
var checkMes: Boolean = true

// #####################################
// DEFINICIÓN DEL CUERPO DEL PROGRAMA
// #####################################

//Entrada generica de texto, la he dividido del codigo pensando que se le daria mas de 1 uso.
//Ademas, delimita el texto
fun entradaTextoDelimitador(){
    entrada = readLine() ?: ""
    listaEntrada = entrada.split(",")
}

fun chequeoValoresDentroDeRango(ed: Byte, me: Byte){
    when(ed){
        !in 6..12 -> checkEdad = false
    }
    when(me) {
        !in 1..12 -> checkMes = false
    }
}

//Genera las tablas de multiplicar, necesita un numero que recibe, del cual genera la tabla.
fun tablaDeMultiplicar(entradaNumero: Byte){
    println("TABLA DE MULTIPLICAR DEL $entradaNumero")
    for(num in 1..10) {
        println("$entradaNumero x $num = ${entradaNumero*num}")
    }
    println("_".repeat(80))
}


fun main() {
    // Declaración de variables
    // Aqui tienes que definir las variables que se utilizan
    // Leo desde teclado la edad del alumno y el mes actual
    println("Introduzca la configuración del programa en este formato: <edadDelAlumno>,  <mesActual>")
    entradaTextoDelimitador()

    // Linea Inicial de programa
    println("*".repeat(80))
    println("PROGRAMA DE GENERACIÓN DE TABLAS: $miNombre")

    // Linea inicio cabecera
    println("_".repeat(80))

    if (listaEntrada.size != 2) //Compruebo el tamaño de la lista, si es != 2, finaliza el programa
    {
        println("La lista contiene mas de 2 elementos o menos de 1 elemento, no es valido")
        println("_".repeat(80))
    }
    else { // Sino, leo edad y mes. Asigno -1 si hay error en la lectura.
        edad = try {listaEntrada[0].trim().toByte()} catch (_: Exception) {-1}
        mes = try {listaEntrada[1].trim().toByte()} catch (_: Exception) {-1}
        chequeoValoresDentroDeRango(edad, mes)
        if (mes <= 0 || edad <= 0){
            println("Algo salio mal.")
            println("_".repeat(80))
        }else if (!checkEdad) // Si alguno es menor que -1, finaliza el programa
        {
            println("Edad: $edad. No se contempla esta edad.")
            println("_".repeat(80))
        } else if (!checkMes){
            println("Mes: $mes. El mes es erroneo.")
            println("_".repeat(80))
        }
        else //Sino, continuo
        {
            //Edad: 8. El alumno está dentro del rango [6-8]
            //Mes: 12. El mes es par, corresponden las tablas siguientes: {2,4}
            println("La edad es $edad y el mes es $mes")

            // Linea final cabecera
            println("_".repeat(80))

            //Imprime las  tablas en función de
            when (edad) {
                in 6..8 ->
                    if (mes % 2 != 0) {
                        tablaDeMultiplicar(1)
                        tablaDeMultiplicar(3)
                        tablaDeMultiplicar(5)
                    } else {
                        tablaDeMultiplicar(2)
                        tablaDeMultiplicar(4)
                    }
                in 9..10 ->
                    if (mes % 2 != 0) {
                        tablaDeMultiplicar(7)
                        tablaDeMultiplicar(9)
                    } else {
                        tablaDeMultiplicar(6)
                        tablaDeMultiplicar(8)
                        tablaDeMultiplicar(10)
                    }
                in 11..12 -> {
                    tablaDeMultiplicar(11)
                    tablaDeMultiplicar(12)
                    tablaDeMultiplicar(13)
                }
            }
        }
    }
    // Linea final de programa
    println("*".repeat(80))

}