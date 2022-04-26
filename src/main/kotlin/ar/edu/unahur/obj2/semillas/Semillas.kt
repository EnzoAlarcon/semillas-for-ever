package ar.edu.unahur.obj2.semillas

abstract class Planta(val altura: Double, val anioObtencion: Int) {

    open fun toleranciaAlSol() = 7
    fun esFuerte() = this.toleranciaAlSol() > 9
    open fun daNuevasSemillas() = this.esFuerte()
    open fun esParcelaIdeal(parcela: Parcelas) = true
    
}

open class Menta(altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun daNuevasSemillas() = super.daNuevasSemillas() || this.altura > 0.4
    open fun espacioQueOcupa() = this.altura + 1
    override fun esParcelaIdeal(parcela: Parcelas) = parcela.superficie() > 6
    
}

open class Soja (altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        return if (this.altura < 0.5) { 6 } 
        else if (this.altura < 1.0) { 8 } 
        else { 12 }
    }
    override fun daNuevasSemillas() = super.daNuevasSemillas() || this.anioObtencion < 2007 && (this.altura < 0.9 && this.altura > 0.75)
    fun espacioQueOcupa() = this.altura / 2
    override fun esParcelaIdeal(parcela: Parcelas) = parcela.horasAlSol == this.toleranciaAlSol()
}

class Quinoa(private var espacioQueOcupa: Double, anioObtencion: Int) : Planta(espacioQueOcupa, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        return if (espacioQueOcupa < 0.3) { 10 }
        else { super.toleranciaAlSol() }
    }
    override fun daNuevasSemillas() = this.anioObtencion in 2002..2007 || super.daNuevasSemillas()
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

