package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.features.dto.BookMovement
import nrs.sankarsana.bookstore.features.dto.BooksDeliveryRemote

class BooksDeliveryService(
    private val repository: BooksRepository,
) {

    suspend operator fun invoke(data: BooksDeliveryRemote): List<BookMovement> {
        return repository.performDelivery(data)
    }
}