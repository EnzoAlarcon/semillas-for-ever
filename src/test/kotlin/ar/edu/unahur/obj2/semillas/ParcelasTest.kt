package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({
    val soja = Soja(0.6, 2009)
    val menta = Menta(1.0, 2021)
    val plantass = mutableListOf<Planta>(soja, menta)
    val parcela1 = Parcelas(20, 1, 10, plantass)

    describe("Parcela 1") {
        it("tiene superficie 20 m2 y tolera 4 plantas maximo") {
            parcela1.superficie().shouldBe(20)
            parcela1.cantMaximaDePlantas().shouldBe(4)
        }
    }

})

