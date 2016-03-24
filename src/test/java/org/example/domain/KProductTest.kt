package org.example.domain

import org.assertj.core.api.Assertions
import org.junit.Test
import java.sql.Timestamp

class KProductTest {

    @Test
    fun where() {

        val products = Product.find.where()
            .setUseDocStore(true)
            .whenCreated.after(Timestamp(System.currentTimeMillis()))
            .sku.startsWith("C")
            .name.contains("Rob")
            .version.greaterOrEqualTo(1)
            .findList();

        Assertions.assertThat(products).hasSize(0);
    }

}