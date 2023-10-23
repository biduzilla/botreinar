package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "HISTORICO")
data class Historico(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_HISTORICO")
    val idHistorico: Long,

    @ColumnInfo(name = "TIPO")
    val tipo: String,

    @ColumnInfo(name = "ID_TREINO")
    val idTreino: Long,

    @ColumnInfo(name = "DATA")
    val data: LocalDate = LocalDate.now()
)
