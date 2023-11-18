package nrs.sankarsana.bookstore.features

import kotlinx.coroutines.delay

class BookDataSource {
    
    suspend fun getAll(): List<Book> {
        delay(500)
        return listOf(
            Book(
                id = 1,
                name = "Бхагавад-гита",
                price = 320,
            ),
            Book(
                id = 2,
                name = "Совершенные вопросы совершенные ответы",
                price = 50,
            ),
            Book(
                id = 3,
                name = "Наука самоосознания",
                price = 100,
            )
        )
    }

}
