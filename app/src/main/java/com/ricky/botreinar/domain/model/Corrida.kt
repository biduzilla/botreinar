package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity("CORRIDA")
data class Corrida(
    @PrimaryKey(true)
    @ColumnInfo("ID_CORRIDA")
    val idCorrida: Long,

    @ColumnInfo("VELOCIDADE")
    val velocidade: BigDecimal,

    @ColumnInfo("TEMPO")
    val tempo: Int
)
