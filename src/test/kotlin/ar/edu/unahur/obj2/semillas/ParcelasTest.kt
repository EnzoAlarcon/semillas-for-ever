package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({
    val soja = Soja(1.2, 2010)
    val plantas = mutableListOf<Planta>(soja,soja,soja,soja)
    val parcela1 = Parcelas(20, 1, 10, plantas)

    describe("Parcela 1") {
        it("tiene superficie 20 m2 y tolera 4 plantas maximo") {
            parcela1.superficie().shouldBe(20)
            parcela1.cantMaximaDePlantas().shouldBe(4)
        }
    }
    describe("Parcela1 se agrega 4 soja de mas de 1 metro") {
        it("no tiene complicaciones") {
            parcela1.tieneComplicaciones().shouldBeFalse()
        }

        it("Tiene complicaciones si se agrega 1 soja mas"){
            shouldThrowAny {
                parcela1.plantar(soja)
            }
        }
    }
    describe("Parcela ecologica") {
        val menta1 = Menta(1.0, 2021)
        val menta2 = Menta(1.3, 2020)
        val parcelaEco = ParcelasEcologicas(20, 12, 7, mutableListOf(menta1, menta2))
        it("Se asocia bien") {
            parcelaEco.seAsociaBien(menta2).shouldBeTrue()
        }
    }
    describe("Parcela Industrial") {
        val soja1 = Soja(1.0, 2021)
        val soja2 = Soja(1.3, 2020)
        val parcelaIndustrial = ParcelasIndustriales(20, 12, 7, mutableListOf(soja1, soja2))
        it ("Se asocia bien") {
            parcelaIndustrial.seAsociaBien(soja1).shouldBeTrue()
        }
    }
})

