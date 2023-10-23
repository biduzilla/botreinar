package com.ricky.botreinar.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ricky.botreinar.data.converters.Converters
import com.ricky.botreinar.data.dao.CardioDao
import com.ricky.botreinar.data.dao.CorridaDao
import com.ricky.botreinar.data.dao.ExercicioDao
import com.ricky.botreinar.data.dao.HistoricoDao
import com.ricky.botreinar.data.dao.TreinoDao
import com.ricky.botreinar.domain.model.Cardio
import com.ricky.botreinar.domain.model.Corrida
import com.ricky.botreinar.domain.model.Exercicio
import com.ricky.botreinar.domain.model.Historico
import com.ricky.botreinar.domain.model.Treino

@Database(
    entities = [
        Treino::class,
        Exercicio::class,
        Cardio::class,
        Corrida::class,
        Historico::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatebase : RoomDatabase() {

    abstract fun treinoDao(): TreinoDao
    abstract fun exercicioDao(): ExercicioDao
    abstract fun cardioDao(): CardioDao
    abstract fun corridaDao(): CorridaDao
    abstract fun historicoDao(): HistoricoDao
}