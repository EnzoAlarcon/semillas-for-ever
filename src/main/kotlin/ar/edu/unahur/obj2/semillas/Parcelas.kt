package ar.edu.unahur.obj2.semillas

class Parcelas(val ancho: Int, val largo: Int, val horasAlSol: Int, var plantas : MutableList<Planta>) {

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
}
