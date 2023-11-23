package nrs.sankarsana.bookstore.util

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

class DateTimeSerializer : KSerializer<DateTime> {

    private val dateFormat = ISODateTimeFormat.dateHourMinuteSecond()

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "DateTime",
        kind = PrimitiveKind.STRING
    )

    override fun serialize(encoder: Encoder, value: DateTime) {
        val formattedString = dateFormat.print(value)
        encoder.encodeString(formattedString)
    }

    override fun deserialize(decoder: Decoder): DateTime {
        val formattedString = decoder.decodeString()
        return dateFormat.parseDateTime(formattedString)
    }
}