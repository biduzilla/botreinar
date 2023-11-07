package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity("CORRIDA")
data class Corrida(
    @PrimaryKey(true)
    @ColumnInfo("ID_CORRIDA")
    var idCorrida: Long = 0L,

    @ColumnInfo("ID_CARDIO")
    var idCardio: Long = 0L,

    @ColumnInfo("VELOCIDADE")
    var velocidade: BigDecimal  = BigDecimal(0.0),

    @ColumnInfo("TEMPO")
    var tempo: Int = 0
)
