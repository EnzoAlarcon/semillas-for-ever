package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


val soja = Soja(1.2, 2010)
val menta = Menta(1.0, 2021)
val quinoa = Quinoa(0.2,2010)
val parcela1 = ParcelasEcologicas(20, 1, 10, mutableListOf(soja,menta,quinoa))
val parcela2 = ParcelasIndustriales(20, 1, 10, mutableListOf(soja,soja))
val parcela3 = ParcelasEcologicas(20, 1, 10, mutableListOf(quinoa))
val parcela4 = ParcelasEcologicas(20, 1, 10, mutableListOf(quinoa, quinoa, quinoa, quinoa, quinoa))
val listaParcelas = mutableListOf<Parcelas>()

class IntaTest : DescribeSpec({
    val inta1 = Inta(listaParcelas)
    describe("Creacion de inta con 3 parcelas") {
        inta1.agregarParcela(parcela1)
        inta1.agregarParcela(parcela2)
        inta1.agregarParcela(parcela3)
        it("el promedio de plantas es 2") {
            inta1.promedioDePlantas().shouldBe(2)
        }
        describe("Parcela mas autosustentable") {
            inta1.agregarParcela(parcela4)
            it("parcela 4") {
                inta1.masAutosustentable().shouldBe(parcela4)
            }
        }
    }
})