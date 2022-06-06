package dev.damodaran.testcompose.ray_compose.ui.composeUI

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.damodaran.testcompose.R

@Composable
fun ActionButton(modifier: Modifier = Modifier,
                 text: String="Librarian",
                 isEnabled: Boolean=true,
                 enabledColor: Color = colorResource(id = R.color.colorPrimary),
                 disabledTextColor: Color = Color.Gray,
                 onClick: () -> Unit){
    val backgroundColor = if (isEnabled) enabledColor else Color.LightGray

    TextButton(onClick = onClick,
    enabled = isEnabled,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
            contentColor = Color.White,
            disabledContentColor = disabledTextColor
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.padding(16.dp),
        content = { Text(text) },
    )

}