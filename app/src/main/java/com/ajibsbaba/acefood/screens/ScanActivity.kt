package com.ajibsbaba.acefood.screens

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.acefood.ui.theme.AcefoodTheme
import com.google.common.util.concurrent.ListenableFuture
import org.tensorflow.lite.Interpreter
import java.nio.ByteBuffer

class ScanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcefoodTheme {
                ScanScreen(navController = rememberNavController())
            }
        }
    }
}


@Composable
fun CameraPreview() {
    val context = LocalContext.current
    val cameraProviderFuture: ListenableFuture<ProcessCameraProvider> by remember {
        mutableStateOf(ProcessCameraProvider.getInstance(context))
    }

}


@Composable
fun ScanScreen(navController: NavController) {
    var inputText by remember { mutableStateOf("") }
    var inferenceResult by remember { mutableStateOf("") }

    var interpreter: Interpreter? by remember { mutableStateOf(null) }

    val context = LocalContext.current

    // Load the TensorFlow Lite model on first composition
    LaunchedEffect(key1 = context) {
        interpreter = Interpreter(loadModelFile(context, "model/your_model.tflite"))
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScanPreview() {
    ScanScreen(navController = rememberNavController())
}

private fun loadModelFile(context: Context, fileName: String): ByteBuffer {
    val assetManager = context.assets
    val inputStream = assetManager.open(fileName)
    val byteArray = inputStream.readBytes()
    return ByteBuffer.wrap(byteArray)
}

private fun preprocessInputData(inputText: String): ByteBuffer {
    // Converts input data to a format suitable for the model and returns a placeholder ByteBuffer for demonstration
    return ByteBuffer.allocateDirect(INPUT_SIZE)
}

private fun processOutputData(outputData: Array<FloatArray>): String {
    return ""
}

private const val INPUT_SIZE = 224
private const val OUTPUT_SIZE = 10