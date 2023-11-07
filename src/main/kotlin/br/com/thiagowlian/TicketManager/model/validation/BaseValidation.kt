package br.com.thiagowlian.TicketManager.model.validation

abstract class BaseValidation<T>(var entity: T) {
    private var nextValidation: BaseValidation<T>? = null

    abstract fun isValid() : Boolean

    fun setNextValidation(validation: BaseValidation<T>): BaseValidation<T> {
        nextValidation = validation
        return nextValidation!!
    }

    fun startNextValidation(): Boolean {
        nextValidation?.run {
            this.isValid()
        }
        return true
    }

    fun nextValidationsExists(): Boolean {
        return nextValidation != null
    }
}