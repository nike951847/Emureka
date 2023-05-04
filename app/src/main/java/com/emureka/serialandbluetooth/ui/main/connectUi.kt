package com.emureka.serialandbluetooth.ui.main

import android.hardware.usb.UsbAccessory
import android.hardware.usb.UsbDevice
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emureka.serialandbluetooth.communication.SerialCommunication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Connect(
    serial: SerialCommunication,
    scaffoldState: ScaffoldState,
    activity: ComponentActivity
) {
    TextButton(
        onClick = {
            if (!serial.openDevice(activity)) {
                CoroutineScope(Dispatchers.IO).launch {
                    scaffoldState.snackbarHostState.showSnackbar("No devices found!", "OK", SnackbarDuration.Short)
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
            .height(70.dp)
    ) {
        Text(text = "Connect via USB")
    }
}