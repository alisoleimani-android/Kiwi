package com.kiwi.android.data.cache.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.kiwi.android.domain.model.Country

@Entity(
    tableName = "tbl_country",
    foreignKeys = [
        ForeignKey(
            entity = CachedFlight::class,
            parentColumns = ["id"],
            childColumns = ["flightId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("flightId")]
)
data class CachedCountry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val code: String,
    val name: String,
    val flightId: String
) {
    companion object {
        fun fromDomain(flightId: String, country: Country): CachedCountry {
            return CachedCountry(
                code = country.code,
                name = country.name,
                flightId = flightId
            )
        }
    }

    fun toDomain(): Country = Country(code = code, name = name)
}
