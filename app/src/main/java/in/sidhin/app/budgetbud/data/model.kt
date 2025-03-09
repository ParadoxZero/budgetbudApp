package `in`.sidhin.app.budgetbud.data

data class Expense(
    val id: Int,
    val title: String,
    val amount: Double,
    val categoryId: Int,
    val timestamp: Long
)

data class Unplanned(
    val id: Int,
    val name: String,
    val description: String? = null,
    val isActive: Boolean
)

enum class RecurringType {
    WEEKLY,
    BIWEEKLY,
    MONTHLY,
    QUARTERLY, // unsupported
    HALF_YEARLY, // unsupported
    YEARLY
}

data class Recurring(
    val id: Int,
    val name: String,
    val description: String,
    val isActive: Boolean,
    val lastUpdated: Long,
    val frequency: RecurringType,
    val frequencyUnit: Int, // This has different meanings based on the frequency, if monthly, it will be day of month, if weekly, it will be day of week etc.
    val startDate: Long,
    val endDate: Long,
    val amount: Double
)

data class Category(
    val id: Int,
    val name: String,
    val description: String,
    val allocation: Double,
    val isActive: Boolean,
    val lastUpdated: Long,
    val currency: String,
    val expenseList: List<Expense>
)

data class TimeUnit(
    val month: Int,
    val year: Int
)

enum class UserActionType {
    ADD_CATEGORY,
    DELETE_CATEGORY,
    UPDATE_CATEGORY,
    ADD_EXPENSE,
    DELETE_EXPENSE,
    UPDATE_EXPENSE,
    ADD_RECURRING,
    DELETE_RECURRING,
    UPDATE_RECURRING,
    ADD_UNPLANNED,
    DELETE_UNPLANNED,
    UPDATE_UNPLANNED
}

data class UserAction(
    val timestamp: Long,
    val type: UserActionType,
    val payload: Any? // Can be Category, Expense, Recurring, Unplanned, or null
)

data class Budget(
    val id: String,
    val name: String,
    val historyId: String,
    val categoryList: List<Category>,
    val recurringList: List<Recurring>,
    val unplannedList: List<Unplanned>,
    val period: TimeUnit,
    val userActions: List<UserAction>,
    val lastUpdated: Long,
    val authorizedUsers: List<String>
)

data class BudgetHistory(
    val id: String,
    val history: List<Budget>
)