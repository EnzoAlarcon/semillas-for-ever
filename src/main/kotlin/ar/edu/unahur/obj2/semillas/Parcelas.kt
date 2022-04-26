package ar.edu.unahur.obj2.semillas

open class Parcelas(private var ancho: Int, private var largo: Int, val horasAlSol: Int, var plantas : MutableList<Planta>) {

    fun superficie() = ancho * largo

    fun cantMaximaDePlantas() : Int {
        return if (ancho > largo) { this.superficie() / 5 }
        else { this.superficie() / 3 + largo }
    }
    fun tieneComplicaciones() = plantas.any{ p : Planta -> p.toleranciaAlSol() < horasAlSol }

    private fun hayLugarParaPlantar() = plantas.size < this.cantMaximaDePlantas()

    private fun plantaToleraElSolDeParcela(planta : Planta) = this.horasAlSol < planta.toleranciaAlSol() + 2

    fun plantar(planta: Planta){
        if (!this.hayLugarParaPlantar() || this.plantaToleraElSolDeParcela(planta)) { error("No puede plantarse esta planta en la parcela") }
        else { plantas.add(planta) }
    }
    fun cantidadDePlantas() = plantas.size

    open fun porcentajePlantasBienAsociadas() = 0
}

class ParcelasEcologicas(ancho: Int, largo: Int, horasAlSol: Int, plantas : MutableList<Planta>) : Parcelas(ancho, largo, horasAlSol, plantas) {

    fun seAsociaBien(planta: Planta) = !this.tieneComplicaciones() && planta.esParcelaIdeal(this)

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
