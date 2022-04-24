package ar.edu.unahur.obj2.semillas

open class Parcelas(val ancho: Int, val largo: Int, val horasAlSol: Int, var plantas : MutableList<Planta>) {

    fun superficie() = ancho * largo

    fun cantMaximaDePlantas() : Int {
        if (ancho > largo) {return this.superficie() / 5}
        else {return this.superficie() / 3 + largo}
    }
    fun tieneComplicaciones() : Boolean {
        return plantas.any{ p : Planta -> p.toleranciaAlSol() < horasAlSol }
    }
    fun hayLugarParaPlantar() : Boolean {
        return plantas.size < this.cantMaximaDePlantas()
    }
    fun plantaToleraElSolDeParcela(planta : Planta) : Boolean {
        return this.horasAlSol < planta.toleranciaAlSol() + 2
    }
    fun plantar(planta: Planta){
        if (!this.hayLugarParaPlantar() || this.plantaToleraElSolDeParcela(planta)) {
            error("No puede plantarse esta planta en la parcela")
        }
        else { plantas.add(planta) }
    }
    fun cantidadDePlantas() : Int {
        return plantas.size
    }

    open fun porcentajePlantasBienAsociadas() : Int {return 0}

}

class ParcelasEcologicas(ancho: Int, largo: Int, horasAlSol: Int, plantas : MutableList<Planta>) : Parcelas(ancho, largo, horasAlSol, plantas) {
    fun seAsociaBien(planta: Planta) : Boolean{
        return !this.tieneComplicaciones() && planta.esParcelaIdeal(this)
    }

    override fun porcentajePlantasBienAsociadas(): Int {
        val plantasBienAsociadas = plantas.count { this.seAsociaBien(it) }
        return plantasBienAsociadas * 100 / this.cantidadDePlantas()
    }
}

class ParcelasIndustriales(ancho: Int, largo: Int, horasAlSol: Int, plantas : MutableList<Planta>) : Parcelas(ancho, largo, horasAlSol, plantas) {
    fun seAsociaBien(planta: Planta) : Boolean{
        return this.cantidadDePlantas() <= 2 && planta.esFuerte()
    }

    override fun porcentajePlantasBienAsociadas(): Int {
        val plantasBienAsociadas = plantas.count { this.seAsociaBien(it) }
        return plantasBienAsociadas * 100 / this.cantidadDePlantas()
    }

}
