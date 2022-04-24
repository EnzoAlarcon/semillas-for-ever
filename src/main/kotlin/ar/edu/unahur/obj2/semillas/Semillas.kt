package ar.edu.unahur.obj2.semillas

abstract class Planta(var altura: Double, val anioObtencion: Int) {

    open fun toleranciaAlSol() = 7
    fun esFuerte() : Boolean {
        return this.toleranciaAlSol() > 9
    }
    open fun daNuevasSemillas() : Boolean {
        return this.esFuerte()
    }
    open fun esParcelaIdeal(parcela: Parcelas) : Boolean = true
}

open class Menta(altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun daNuevasSemillas() : Boolean {
        return super.daNuevasSemillas() || this.altura > 0.4
    }
    open fun espacioQueOcupa() = this.altura + 1
    override fun esParcelaIdeal(parcela: Parcelas) : Boolean = parcela.superficie() > 6
}

open class Soja (altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        if (this.altura < 0.5) {return 6}
        else if (this.altura < 1.0) {return 8}
        else {return 12}
    }
    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || this.anioObtencion < 2007 && (this.altura < 0.9 && this.altura > 0.75)
    }
    fun espacioQueOcupa() = this.altura / 2
    override fun esParcelaIdeal(parcela: Parcelas) : Boolean {
        return parcela.horasAlSol == this.toleranciaAlSol()
    }
}

class Quinoa(var espacioQueOcupa: Double, anioObtencion: Int) : Planta(espacioQueOcupa, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        val resultado : Int

        if (espacioQueOcupa < 0.3) {resultado = 10}
        else {return super.toleranciaAlSol()}
        return resultado
    }
    override fun daNuevasSemillas(): Boolean {
        if (this.anioObtencion > 2001) {return true}
        else if (this.anioObtencion < 2008) {return true}
        else {return super.daNuevasSemillas()}
    }
    override fun esParcelaIdeal(parcela: Parcelas) : Boolean {
        return parcela.plantas.all{ p : Planta -> p.altura < 1.5 }
    }

}

class SojaTransgenica(altura: Double, anioObtencion: Int) : Soja(altura, anioObtencion) {

    override fun daNuevasSemillas(): Boolean {
        return false
    }
    override fun esParcelaIdeal(parcela: Parcelas) : Boolean {
        return parcela.plantas.size == 0
    }
}

class Peperina(altura: Double, anioObtencion: Int) : Menta(altura, anioObtencion) {

    override fun espacioQueOcupa(): Double {
        return super.espacioQueOcupa() * 2
    }
}

