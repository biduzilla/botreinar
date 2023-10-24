package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "CARDIO")
data class Cardio(
    @PrimaryKey(true)
    @ColumnInfo("ID_CARDIO")
    var idCardio: Long = 0L,

    @ColumnInfo("TEMPO_TOTAL")
    var tempoTotal: Int = 0,

    @ColumnInfo("VELOCIDADE_MEDIA")
    var velocidadeTotal: BigDecimal = BigDecimal(0.0),

    @ColumnInfo("DISTANCIA_TOTAL")
    var distanciaTotal: BigDecimal = BigDecimal(0.0)
)
