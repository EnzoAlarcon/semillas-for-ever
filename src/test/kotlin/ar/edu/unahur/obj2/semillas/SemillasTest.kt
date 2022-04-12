package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioObtencion.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daNuevasSemillas().shouldBeTrue()
            mentita.daNuevasSemillas().shouldBeFalse()
            soja.daNuevasSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacioQueOcupa().shouldBe(2.0)
            mentita.espacioQueOcupa().shouldBe(1.3)
            soja.espacioQueOcupa().shouldBe(0.3)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacioQueOcupa(),
                menta.espacioQueOcupa(),
                mentita.espacioQueOcupa()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }
    }
})

// TEST NUESTROS

class PlantasTest : DescribeSpec ({
    // una menta de 1 metro, debería dar semillas y ocupar un espacio de 2 metros cuadrados.

    describe("Planta Menta") {
        val menta = Menta(1.0, 2021)
        it("Da semillas nuevas y ocupa 2 m2") {
            menta.daNuevasSemillas().shouldBeTrue()
            menta.espacioQueOcupa().shouldBe(2)
        }
    }
    // una menta de solo 0.3 metros, no debería dar semillas y ocuparía 1.3 metros cuadrados de espacio.
    describe("Planta Menta 2") {
        val menta2 = Menta(0.3, 2021)
        it("No da semillas y ocupa 1.3 m2") {
            menta2.daNuevasSemillas().shouldBeFalse()
            menta2.espacioQueOcupa().shouldBe(1.3)
        }
    }
    // si tuviesemos una soja de 0.6 metros y de semilla de 2009,
    // la planta tendría una tolerancia al sol de 8 horas, no daría semillas y ocuparía 0.3 metros cuadrados.
    describe("Planta Soja") {
        val soja = Soja(0.6, 2009)
        it("toleracia al sol 8, no da semillas y ocuparia 0.3 m2") {
            soja.toleranciaAlSol().shouldBe(8)
            soja.daNuevasSemillas().shouldBeFalse()
            soja.espacioQueOcupa().shouldBe(0.3)
        }
    }
    //si tenemos una quinoa que ocupa 0.2 m2 y su semilla de origen es de 2010, se trata de una planta que da semillas.
    describe("Planta Quinoa") {
        val quinoa = Quinoa(0.2,2010)
        it("da semillas") {
            quinoa.daNuevasSemillas().shouldBeTrue()
        }
    }
    // si tenemos una planta que ocupa 0.9 m2 pero cuya semilla de origen es de 2006, también da semillas.
    describe("Planta Quinoa 2") {
        val quinoa2 = Quinoa(0.9, 2006)
        it ("Da semillas") {
            quinoa2.daNuevasSemillas().shouldBeTrue()
        }
    }
    describe("Planta Soja Trans") {
        val sojaTrans = SojaTransgenica(2.0, 2009)
        it("no da semillas") {
            sojaTrans.daNuevasSemillas().shouldBeFalse()
        }
    }
    describe("Planta peperina") {
        val peperina = Peperina(1.0, 2021)
        it("Da semillas nuevas y ocupa 4 m2") {
            peperina.daNuevasSemillas().shouldBeTrue()
            peperina.espacioQueOcupa().shouldBe(4.0)
        }
    }
})

