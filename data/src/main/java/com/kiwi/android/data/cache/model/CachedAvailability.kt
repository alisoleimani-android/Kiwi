package com.kiwi.android.data.cache.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.kiwi.android.domain.model.FlyAvailability

@Entity(
    tableName = "tbl_availability",
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
data class CachedAvailability(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val seats: Int,
    val flightId: String
) {
    companion object {
        fun fromDomain(flightId: String, availability: FlyAvailability): CachedAvailability {
            return CachedAvailability(
                seats = availability.seats,
                flightId = flightId
            )
        }
    }

    fun toDomain(): FlyAvailability = FlyAvailability(seats = seats)
}
