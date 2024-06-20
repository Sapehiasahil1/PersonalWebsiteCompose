package org.example.personalwebsitecompose.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.personalwebsitecompose.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ProfileCard(colorMode: ColorMode) {
    val breakPoint = rememberBreakpoint()
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2),
        modifier = Modifier
            .fillMaxWidth(
                if(breakPoint<= Breakpoint.MD) 100.percent
                else Res.Dimens.MAX_CARD_WIDTH.px
            )
            .thenIf(
                condition = breakPoint > Breakpoint.MD,
                other = Modifier.height(Res.Dimens.MAX_CARD_HEIGHT.px)
            )
            .boxShadow(
                color = Colors.Black.copy(alpha = 10),
                blurRadius = 50.px,
                spreadRadius = 50.px
            )
            .padding(all = 12.px)
            .borderRadius(Res.Dimens.BORDER_RADIUS.px)
            .background(
                if (colorMode.isLight) Colors.White else
                    Res.Theme.DARK_BLUE.color
            )
    ) {
        LeftSide(colorMode, breakPoint)
        RightSide(breakpoint = breakPoint)
    }
}