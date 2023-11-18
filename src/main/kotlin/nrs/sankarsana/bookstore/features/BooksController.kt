package nrs.sankarsana.bookstore.features

class BooksController(
    private val repository: BooksRepository,
) {
     
    suspend operator fun invoke(): Any {
        return repository.getAll()
    }
}