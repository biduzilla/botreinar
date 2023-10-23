package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "TREINO")
data class Treino(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="ID_TREINO")
    val idTreino:Long,

    @ColumnInfo(name="EXERCICIO")
    val exercicios:List<Exercicio>,

    @ColumnInfo(name="LETRA")
    val letra:String,

    @ColumnInfo("DATA")
    val data:LocalDate = LocalDate.now()
)
