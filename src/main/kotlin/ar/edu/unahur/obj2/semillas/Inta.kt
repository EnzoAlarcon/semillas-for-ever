package ar.edu.unahur.obj2.semillas

class Inta(var listaParcelas: MutableList<Parcelas>) {

    fun agregarParcela(parcela: Parcelas) {
        listaParcelas.add(parcela)
    }

    fun promedioDePlantas(): Int {
        val cantidadDeParcelas = listaParcelas.size
        val totalDePlantas = listaParcelas.sumBy { p : Parcelas -> p.cantidadDePlantas() }
        return totalDePlantas / cantidadDeParcelas
    }

    fun masAutosustentable(): Parcelas {
        val parcelaConMas4Plantas = listaParcelas.filter { it.plantas.size > 4 }
        val laParcela = parcelaConMas4Plantas.maxByOrNull { it.porcentajePlantasBienAsociadas() }
        if (laParcela != null)
            return laParcela
        throw java.lang.RuntimeException("No hay parcelas mas autosustentable que tenga mas de 4 plantas")
    }

}