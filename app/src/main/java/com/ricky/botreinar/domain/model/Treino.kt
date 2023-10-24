package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "TREINO")
data class Treino(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="ID_TREINO")
    var idTreino:Long = 0L,

    @ColumnInfo(name="LETRA")
    var letra:String = "",

    @ColumnInfo("DATA")
    var data:LocalDate = LocalDate.now()
)
