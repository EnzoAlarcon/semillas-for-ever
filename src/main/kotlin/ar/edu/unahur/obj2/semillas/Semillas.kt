package ar.edu.unahur.obj2.semillas

open class Planta(open var altura: Double, open val anioObtencion: Int) {

    open fun toleranciaAlSol() = 7

    fun esFuerte() : Boolean {
        return this.toleranciaAlSol() > 9
    }

    open fun daNuevasSemillas() : Boolean {
        return this.esFuerte()
    }

}

open class Menta(override var altura: Double, override val anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun daNuevasSemillas() : Boolean {
        return super.daNuevasSemillas() || this.altura > 0.4
    }

    open fun espacioQueOcupa() = this.altura + 1

}

open class Soja (override var altura: Double, override val anioObtencion: Int) : Planta(altura, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        if (this.altura < 0.5) {return 6}
        else if (this.altura < 1.0) {return 8}
        else {return 12}
    }

    override fun daNuevasSemillas(): Boolean {
        return super.daNuevasSemillas() || this.anioObtencion < 2007 && (this.altura < 0.9 && this.altura > 0.75)
    }

    fun espacioQueOcupa() = this.altura / 2


}

class Quinoa(var espacioQueOcupa: Double, override val anioObtencion: Int) : Planta(espacioQueOcupa, anioObtencion) {

    override fun toleranciaAlSol(): Int {
        if (espacioQueOcupa < 0.3) {return 10}
        else {return super.toleranciaAlSol()}
    }

    override fun daNuevasSemillas(): Boolean {
        if (this.anioObtencion > 2001) {return true}
        else if (this.anioObtencion < 2008) {return true}
        else {return super.daNuevasSemillas()}
    }

}

class SojaTransgenica(override var altura: Double, override val anioObtencion: Int) : Soja(altura, anioObtencion) {

    override fun daNuevasSemillas(): Boolean {
        return false
    }

}

class Peperina(override var altura: Double, override val anioObtencion: Int) : Menta(altura, anioObtencion) {

    override fun espacioQueOcupa(): Double {
        return super.espacioQueOcupa() * 2
    }
}

