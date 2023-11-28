package nrs.sankarsana.bookstore.service

import nrs.sankarsana.bookstore.dto.BookMovement
import nrs.sankarsana.bookstore.dto.BooksDeliveryRemote
import nrs.sankarsana.bookstore.repository.BooksRepository

class BooksDeliveryService(
    private val repository: BooksRepository,
) {

    suspend operator fun invoke(data: BooksDeliveryRemote): List<BookMovement> {
        return repository.performDelivery(data)
    }
}