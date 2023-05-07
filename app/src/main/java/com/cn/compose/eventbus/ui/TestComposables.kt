package com.cn.compose.eventbus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2023/5/7]
 */

@Composable
fun Screen1(navController: NavController) {
    Column {

        MyButton(text = "To Screen1") {
            navController.navigate("screen2")
        }
        Spacer(modifier = Modifier.height(20.dp))

        MyButton(text = "Send normal event") {

        }
    }

}

@Composable
fun Screen2(navController: NavController) {
    Column {
        MyButton(text = "To Screen2") {
            navController.navigate("screen1")
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}


@Composable
fun MyButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}