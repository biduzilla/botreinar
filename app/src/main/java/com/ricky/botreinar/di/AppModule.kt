package com.ricky.botreinar.di

import android.content.Context
import androidx.room.Room
import com.ricky.botreinar.common.DataStoreUtil
import com.ricky.botreinar.data.AppDatebase
import com.ricky.botreinar.data.dao.CardioDao
import com.ricky.botreinar.data.dao.CorridaDao
import com.ricky.botreinar.data.dao.ExercicioDao
import com.ricky.botreinar.data.dao.HistoricoDao
import com.ricky.botreinar.data.dao.TreinoDao
import com.ricky.botreinar.data.repository.CardioRepositoryImpl
import com.ricky.botreinar.data.repository.CorridaRepositoryImpl
import com.ricky.botreinar.data.repository.ExercicioRepositoryImpl
import com.ricky.botreinar.data.repository.HistoricoRepositoryImpl
import com.ricky.botreinar.data.repository.TreinoRepositoryImpl
import com.ricky.botreinar.domain.repository.CardioRepository
import com.ricky.botreinar.domain.repository.CorridaRepository
import com.ricky.botreinar.domain.repository.ExercicioRepository
import com.ricky.botreinar.domain.repository.HistoricoRepository
import com.ricky.botreinar.domain.repository.TreinoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTreinoDao(database: AppDatebase): TreinoDao = database.treinoDao()

    @Singleton
    @Provides
    fun provideExercicioDao(database: AppDatebase): ExercicioDao = database.exercicioDao()

    @Singleton
    @Provides
    fun provideHistoricoDao(database: AppDatebase): HistoricoDao = database.historicoDao()

    @Singleton
    @Provides
    fun provideCardioDao(database: AppDatebase): CardioDao = database.cardioDao()

    @Singleton
    @Provides
    fun provideCorridaDao(database: AppDatebase): CorridaDao = database.corridaDao()

    @Singleton
    @Provides
    fun provideTreinoRepository(dao: TreinoDao): TreinoRepository = TreinoRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideExercicioRepository(dao: ExercicioDao): ExercicioRepository =
        ExercicioRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideCardioRepository(dao: CardioDao): CardioRepository = CardioRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideCorridaRepository(dao: CorridaDao): CorridaRepository = CorridaRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideHistoricoRepository(
        dao: HistoricoDao,
        treinoRepository: TreinoRepository,
        cardioRepository: CardioRepository
    ): HistoricoRepository = HistoricoRepositoryImpl(
        dao = dao,
        treinoRepository = treinoRepository,
        cardioRepository = cardioRepository
    )

    @Singleton
    @Provides
    fun provideDataStoreUtil(@ApplicationContext context: Context): DataStoreUtil =
        DataStoreUtil(context)

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatebase =
        Room.databaseBuilder(
            context,
            AppDatebase::class.java,
            "app_db"
        ).fallbackToDestructiveMigration()
            .build()
}