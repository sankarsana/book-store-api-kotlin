package nrs.sankarsana.bookstore.features.books

class BooksService(
    private val repository: BooksRepository,
) {

    suspend fun getAll(): List<Book> {
        return repository.getAll()
    }
}