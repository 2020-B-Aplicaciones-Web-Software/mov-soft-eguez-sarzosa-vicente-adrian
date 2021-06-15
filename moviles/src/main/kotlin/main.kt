import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println("Hola mundo")
    // JAVA Int edad = 12;

    // Duck Typing

    var edadProfesor = 31
    //    var edadProfesor: Int = 31
    var sueldoProfesor = 12.1
    //    var edadProfesor: Double = 12.1
    //    edadProfesor = "asadasd"
    //    edadProfesor = 12.1
    //    sueldoProfesor = "azzxc"
    //    sueldoProfesor = 1

    // MUTABLES (Re asignar) / INMUTABLES (No Re asignar)

    // MUTABLES
    var edadCachoro: Int = 0
    edadCachoro = 1
    edadCachoro = 2
    edadCachoro = 3

    // INMUTABLES
    val numeroCedula = 1818181818
    //  numeroCedula = 12

    // Tipos de variables (JAVA) -> Primitivos
    // Int Double Float Boolean Char
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 12.2
    val estadoCivil: Char = 'S'
    val casado: Boolean = false
    val fechaNacimiento: Date = Date()

    // Condicionales

    if (true) {
        // Verdadera
    } else {
        // Falso
    }

    when (estadoCivil) {
        ('C') -> {
            println("Huir")
        }
        'S' -> {
            println("Conversar")
        }
        'N' -> {
            println("Nada")
        }
        'P' -> println("Profesor")
        else -> {
            println("No tiene estado civil")
        }
    }

    val sueldoMayorAEstablecido = if (sueldo > 12.2) 500 else 0
    // condicion ? bloque-true : bloque-false
    imprimirNombre("Adrian")
//    imprimirNombre("Adrian")
    calcularSueldo(100.00)
    calcularSueldo(100.00, 14.00)
    calcularSueldo(100.00, 14.00, 25.00)

    // Named Parameters
    calcularSueldo(
        bono = 3.00,
//            12.00,
        sueldo = 1000.00
    )
    calcularSueldo(
        tasa = 14.00,
        bono = 3.00,
        sueldo = 250.00
    )

    // Arreglo Estáticos
    val arregloEstatico: Array<Int> = arrayOf(1, 2, 3)
    // arregloEstatico.add(12) -> NO TENEMOS AQUI, NO SE PUEDE MODIFICAR LOS
    //                            Elementos del arreglo
    // Arreglo Dinámicos
    val arregloDinamico: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // OPERADORES -> Sirven para los arreglos estáticos y dinámicos

    // FOR EACH -> Unit
    // Iterar un arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach { valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    println(respuestaForEach)
    arregloDinamico
        .forEach {
            // it -> Tipo de dato
            println("Valor actual: ${it}")
        }
    arregloDinamico.forEach { println("Valor actual: ${it}") }

    // FOR EACH -> INDEXED
    arregloDinamico
        .forEachIndexed { indice: Int, valorActual: Int ->
            println("Valor actual: ${valorActual}, Indice actual: ${indice}")
        }


    // MAP -> Muta el arreglo (Cambia el arreglo)
    // MAP -> List<....>
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble()
        }
    println(respuestaMap)
    val respuestaMapDos: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }
    println(respuestaMapDos)
    val respuestaMapTres: List<Date> = arregloDinamico
        .map { valorActual: Int ->
            return@map Date()
        }
    println(respuestaMapTres)

    // Filter -> FILTRAR EL ARREGLO
    // Filter -> Arreglo Filtrado
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5 // Expresion Condicion
            return@filter mayoresACinco // Boolean
        }
    val respuestaFilterDos: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val menorIgualACinco: Boolean = valorActual <= 5 // Expresion Condicion
            return@filter menorIgualACinco // Boolean
        }
    println(respuestaFilter)
    println(respuestaFilterDos)

    // OR AND
    // OR -> ANY (Alguno cumple?)
    // AND -> ALL (Todos cumplen?)

    val respuestaAny: Boolean = arregloDinamico
        .any { valorActual: Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) // true

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) // false

    // REDUCE -> Valor acumulado
    // 1) Devuelve el acumulado => 0
    // 2) En que valor empieza => 0
    // [1, 2, 3, 4, 5] -> Sumeme todos los valores del arreglo
    //  valorIteracion1 = valorEmpieza + 1 -> Iteracion 1
    //  3 = valorIteracion1 + 2 = 1 + 2 = acumulado -> Iteracion 2
    //  6 = valorIteracion3 + 3 = 3 + 3 = acumulado -> Iteracion 3
    //  10 = valorIteracion4 + 4 = 6 + 3 = acumulado -> Iteracion 4
    //  15 = valorIteracion5 + 5 = 10 + 5 = acumulado -> Iteracion 5
    // -> UltimoAcumulado = 15

    val respuestaReduce: Int = arregloDinamico
        .reduce { // acumulado = 0 -> SIEMPRE EMPIEZA EN 0
                acumulado: Int, valorActual: Int ->
            return@reduce (acumulado + valorActual) // -> Logica negocio
        }
    println(respuestaReduce) // 78

    // 100
    // [12, 15, 8, 10]
    val arregloDanio = arrayListOf<Int>(12, 15, 8, 10)
    val respuestaReduceFold = arregloDanio
        .fold(
            100,
            { acumulado, valorActualIteracion ->
                return@fold acumulado - valorActualIteracion
            }
        )
    println(respuestaReduceFold)

    val vidaActual: Double = arregloDinamico
        .map { it * 2.3 } // arreglo
        .filter { it > 20 } // arreglo
        .fold(100.00, { acc, i -> acc - i }) // valor
        .also { println(it) } // ejecutar codigo extra
    println("Valor vida actual ${vidaActual}")  // 3.4

    val ejemploUno = Suma(1, 2)
    // val ejemploUno = Suma(1,2)
    val ejemploDos = Suma(null, 2)
    // val ejemploDos = Suma(null,2)
    val ejemploTres = Suma(1, null)
    // val ejemploTres = Suma(1,null)
    println(ejemploUno.sumar())
    println(Suma.historialSumas)
    println(ejemploDos.sumar())
    println(Suma.historialSumas)
    println(ejemploTres.sumar())
    println(Suma.historialSumas)


} // FIN bloque MAIN

// void imprimirNombre(Int nombre){}
fun imprimirNombre(nombre: String): Unit {
    println("Nombre ${nombre}") // Template Strings
}

fun calcularSueldo(
    sueldo: Double, // Requerido
    tasa: Double = 12.00, // Opcionales - Defecto
    bono: Double? = null // Variables que PUEDEN ser null
): Double {
    // String -> String?
    // Int -> Int?
    // Date -> Date?
    if (bono != null) {
        return sueldo * (100 / tasa) + bono
    } else {
        return sueldo * (100 / tasa)
    }
}


abstract class NumerosJava {
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno: Int, // Parametros requeridos
        dos: Int  // Parametros requeridos
    ) {
        numeroUno = uno
        numeroDos = dos
        println("Inicializar")
    }
}

// instancia.numeroUno
// instancia.numeroDos
abstract class Numeros( // Constructor Primario
    protected var numeroUno: Int, // propiedad
    protected var numeroDos: Int  // propiedad
) {
    init { // Bloque inicio del constructor primario
        println("Inicializar")
    }
}

// instancia.numeroUno
// instancia.numeroDos
class Suma(
    // constructor primario
    uno: Int, // Parametro requerido
    dos: Int, // Parametro requerido
) : Numeros(
    // constructor papa (super)
    uno,
    dos,
) {
    init {
        this.numeroUno
        this.numeroDos
        // X -> this.uno -> NO EXISTEN
        // X -> this.dos -> NO EXISTEN
    }

    constructor( //  Segundo constructor
        uno: Int?, // parametros
        dos: Int // parametros
    ) : this( // llamada constructor primario
        if (uno == null) 0 else uno,
        dos
    )

    constructor( //  Tercer constructor
        uno: Int, // parametros
        dos: Int? // parametros
    ) : this( // llamada constructor primario
        uno,
        if (dos == null) 0 else dos
    )

    // public fun sumar():Int{
    fun sumar(): Int {
        // val total: Int = this.numeroUno + this.numeroDos
        val total: Int = numeroUno + numeroDos
        agregarHistorial(total)
        return total
    }

    // SINGLETON
    companion object {
        val historialSumas = arrayListOf<Int>()

        fun agregarHistorial(valorNuevaSuma: Int) {
            // this.historialSumas.add(valorNuevaSuma)
            historialSumas.add(valorNuevaSuma)
            println(historialSumas)
        }
    }
}














