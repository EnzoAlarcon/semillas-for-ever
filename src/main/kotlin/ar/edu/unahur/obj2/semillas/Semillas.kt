package ar.edu.unahur.obj2.semillas

abstract class Planta(var altura: Double, val anioObtencion: Int) {

    open fun toleranciaAlSol() = 7

    fun esFuerte() : Boolean {
        return this.toleranciaAlSol() > 9
    }

    open fun daNuevasSemillas() : Boolean {
        return this.esFuerte()
    }

}

open class Menta(altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun daNuevasSemillas() : Boolean {
        return super.daNuevasSemillas() || this.altura > 0.4
    }

    open fun espacioQueOcupa() = this.altura + 1

}

open class Soja (altura: Double, anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        val resultado : Int

        if (this.altura < 0.5) {resultado = 6}
        else if (this.altura < 1.0) {resultado = 8}
        else {resultado = 12}

        return resultado
    }

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || this.anioObtencion < 2007 && (this.altura < 0.9 && this.altura > 0.75)
    }

    fun espacioQueOcupa() = this.altura / 2


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

}

class SojaTransgenica(altura: Double, anioObtencion: Int) : Soja(altura, anioObtencion) {

    override fun daNuevasSemillas(): Boolean {
        return false
    }

}

class Peperina(altura: Double, anioObtencion: Int) : Menta(altura, anioObtencion) {

    override fun espacioQueOcupa(): Double {
        return super.espacioQueOcupa() * 2
    }
}

