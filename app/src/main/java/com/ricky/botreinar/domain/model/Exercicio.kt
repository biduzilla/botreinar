package com.ricky.botreinar.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EXERCICIO")
data class Exercicio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_EXERCICIO")
    var idExercicio: Long = 0L,

    @ColumnInfo(name = "NOME")
    var nome: String = "",

    @ColumnInfo(name = "DESCRICAO")
    var descricao: String = "",

    @ColumnInfo(name = "REPETICOES")
    var repeticao: Int = 0,

    @ColumnInfo(name = "SERIES")
    var series: Int = 0,
    )
