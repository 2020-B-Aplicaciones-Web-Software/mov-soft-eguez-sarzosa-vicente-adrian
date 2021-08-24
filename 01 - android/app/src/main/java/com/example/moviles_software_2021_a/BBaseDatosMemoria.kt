package com.example.moviles_software_2021_a

class BBaseDatosMemoria {

    companion object {
        // Propiedades
        // Metodos
        // Estaticos (Singleton)
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador("Adrian", "a@a.com", null)
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Vicente", "b@b.com", null)
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Carolina", "c@c.com", null)
                )
        }
    }
}
//fun a(){
//    BBaseDatosMemoria.arregloBEntrenador
//}