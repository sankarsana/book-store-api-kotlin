package nrs.sankarsana.bookstore.exception

class ForbiddenException @JvmOverloads constructor(
    message: String? = null,
    cause: Throwable? = null,
) : RuntimeException(message, cause)