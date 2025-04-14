package cin.sidhin.app.budgetbud.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Generic observable class to manage listeners for any type of data
abstract class Observable<T> {
    private var value: T? = null
    private val listeners = mutableListOf<(T) -> Unit>()

    fun setValue(newValue: T?) {
        value = newValue
        notifyListeners()
    }

    fun getValue(): T? = value

    fun registerListener(listener: (T) -> Unit) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: (T) -> Unit) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        CoroutineScope(Dispatchers.Main).launch {
            value?.let { v ->
                listeners.forEach { it.invoke(v) }
            }
        }
    }
}