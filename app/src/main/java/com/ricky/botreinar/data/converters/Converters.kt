package com.ricky.botreinar.data.converters

import androidx.room.TypeConverter
import com.ricky.botreinar.domain.enums.TipoEnum
import java.math.BigDecimal
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }

    @TypeConverter
    fun fromTipo(tipo: TipoEnum): String {
        return tipo.name
    }

    @TypeConverter
    fun toTip(value: String): TipoEnum {
        return enumValueOf(value)
    }

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun toBigDecimal(value: String?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }
}