package com.naden.sdk.util

import org.threeten.bp._

object DateUtils {
	private[this] val isoFmt = format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
	private[this] val dateFmt = format.DateTimeFormatter.ofPattern("yyyy-MM-dd")
	private[this] val niceDateFmt = format.DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy")
	private[this] val niceTimeFmt = format.DateTimeFormatter.ofPattern("HH:mm:ss")

	def today = LocalDate.now
	def now = LocalDateTime.now
	def nowMillis = toMillis(now)
	def currentTime = LocalTime.now

	def toMillis(ldt: LocalDateTime) = ldt.atZone(ZoneId.systemDefault).toInstant.toEpochMilli
	def fromMillis(millis: Long) = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault).toLocalDateTime

	def toIsoString(ldt: LocalDateTime) = isoFmt.format(ldt)
	def fromIsoString(s: String) = LocalDateTime.from(isoFmt.parse(s))
	def fromDateString(s: String) = LocalDate.from(dateFmt.parse(s))

	def niceDate(d: LocalDate) = niceDateFmt.format(d)
	def niceTime(t: LocalTime) = niceTimeFmt.format(t)
	def niceDateTime(dt: LocalDateTime) = s"${niceDate(dt.toLocalDate)} ${niceTime(dt.toLocalTime)} UTC"
}