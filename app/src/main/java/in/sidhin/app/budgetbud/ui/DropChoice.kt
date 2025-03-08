package `in`.sidhin.app.budgetbud.ui

import android.graphics.drawable.Icon
import androidx.compose.runtime.Composable

data class DropChoiceItem(val displayName: String, val id: String, val icon: Icon? = null)

@Composable
fun DropChoice(itemList: List<DropChoiceItem>, selectionChanged:((String) -> Unit) ) {}