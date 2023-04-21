package common.error


abstract class SmsException(
    val errorProperty: ErrorProperty
) : RuntimeException() {
    override fun fillInStackTrace(): Throwable = this
}