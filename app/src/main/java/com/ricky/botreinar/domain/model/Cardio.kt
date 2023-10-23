package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "CARDIO")
data class Cardio(
    @PrimaryKey(true)
    @ColumnInfo("ID_CARDIO")
    val idCardio: Long,

    @ColumnInfo("TEMPO_TOTAL")
    val tempoTotal: Int,

    @ColumnInfo("VELOCIDADE_MEDIA")
    val velocidadeTotal: BigDecimal,

    @ColumnInfo("DISTANCIA_TOTAL")
    val distanciaTotal: BigDecimal
)
