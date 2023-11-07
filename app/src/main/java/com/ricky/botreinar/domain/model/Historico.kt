package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ricky.botreinar.domain.enums.TipoEnum
import java.time.LocalDate

@Entity(tableName = "HISTORICO")
data class Historico(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_HISTORICO")
    var idHistorico: Long = 0L,

    @ColumnInfo(name = "TIPO")
    var tipo: TipoEnum = TipoEnum.TREINO,

    @ColumnInfo(name = "LETRA")
    var letra: String = "",

    @ColumnInfo(name = "DATA")
    var data: LocalDate = LocalDate.now()
)
