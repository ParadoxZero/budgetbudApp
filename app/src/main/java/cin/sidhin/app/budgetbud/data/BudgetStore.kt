package cin.sidhin.app.budgetbud.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object BudgetStore : Observable<Budget>() {

    fun refreshBudget() {
        // Perform the fetch operation asynchronously
        CoroutineScope(Dispatchers.IO).launch {
            val budget = fetchBudget();
            // Update the observable on the main thread
            setValue(budget);
        }
    }

    private fun fetchBudget(): Budget? {
        // Make network call
        return null;
    }
}