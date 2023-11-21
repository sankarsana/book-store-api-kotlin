package nrs.sankarsana.bookstore.features

interface Service<T> {

    suspend operator fun invoke(request: T): Any
}