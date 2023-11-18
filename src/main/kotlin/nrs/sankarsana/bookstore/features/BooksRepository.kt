package nrs.sankarsana.bookstore.features

class BooksRepository(
    private val dataSource: BookDataSource,
) {
    
    suspend fun getAll(): List<Book> {
        return dataSource.getAll()
    }
}